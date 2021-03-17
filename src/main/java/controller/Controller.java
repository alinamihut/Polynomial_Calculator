package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import model.Monomial;
import model.Operations;
import model.Polynomial;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import view.UserInterface;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller  {

    private Polynomial polynomial1 = new Polynomial();
    private Polynomial polynomial2 = new Polynomial();
    public Button buttonAddition;
    public Button buttonSubtraction;
    public Button buttonMultiplication;
    public Button buttonDivision;
    public Button buttonDerivation;
    public Button buttonIntegration;
    public Button buttonClear;
    public TextField tfFirstPolynomial;
    public TextField tfSecondPolynomial;
    public TextField tfResult;
    @FXML
    AnchorPane anchorPane;
    private UserInterface userInterface;
    public void start() throws IOException {

        userInterface = new UserInterface();
       new Thread(() ->Application.launch(UserInterface.class)).start();
    }

    public Polynomial parsePolynomString(TextField textField) {
        Polynomial polynomial = new Polynomial();
        String polynomString = textField.getText();
        String polynomRegex = "([-+]?)(\\d*\\.?\\d*)?([xX](\\^-?\\d*\\.?\\d*)?)?";
        //if (!textField.getText().matches(polynomRegex)){
        //   UserInterface.handleButtonAction();
        //}
        Pattern pattern = Pattern.compile(polynomRegex);
        Matcher matcher = pattern.matcher(polynomString);
        boolean reachedEnd = false;
        double coefficient = 0;
        int power = 0;
        while (matcher.find() && !reachedEnd) {
            if (matcher.group(1).compareTo("-") == 0) {    //monomial with sign -
                if(matcher.group(2).isEmpty()) {  //no coefficient => 1 by default
                    coefficient=-1.0;
                }
                else{
                    coefficient = (Double.parseDouble(matcher.group(2))) * (-1);  //coeficient found (different from 1)
                }
              }
            else {
                if(matcher.group(2).isEmpty()) { //monomial with sign +
                    coefficient=1.0;
                }
                else{
                    coefficient = Double.parseDouble(matcher.group(2)); //coeficient found (different from 1)
                }
            }
            if (matcher.group(3) != null && matcher.group(4) != null) {   //monomial exists at power p
                power = Integer.parseInt(matcher.group(4).substring(1));
            } else if ((matcher.group(3) != null && matcher.group(4) == null)) {   //power1
                power = 1;
            } else if (matcher.group(3) == null && matcher.group(4) == null && matcher.group(2)!=null) {  //power 0
                if(matcher.group(2).isEmpty()) {  //no coefficient at monomial with power 0=> 0 by default
                    coefficient=0.0;
                }
                power = 0;
                reachedEnd = true;
            }
            Monomial newMonom = new Monomial(power, coefficient);
            polynomial.getPolynomial().add(newMonom);
        }
        return polynomial;
    }

    public void createPolynomials (){
        if (tfFirstPolynomial.getText().isEmpty() || tfSecondPolynomial.getText().isEmpty()){
                UserInterface.showAlertForEmptyTextfields();
        }
       polynomial1 =  parsePolynomString(tfFirstPolynomial);
       polynomial2 = parsePolynomString(tfSecondPolynomial);

       polynomial1.sortDegrees();
       polynomial2.sortDegrees();
    }


    public void addition(){
        createPolynomials();
        Polynomial resultPolynomial = Operations.addPolynomials(polynomial1,polynomial2);
        String resultString = resultPolynomial.getPolynomialStringWithIntegers(resultPolynomial);
        displayResultToTextField(resultString);
    }

    public void subtraction(){
        createPolynomials();
        Polynomial resultPolynomial = Operations.subtractPoynomials(polynomial1,polynomial2);
        String resultString = resultPolynomial.getPolynomialStringWithIntegers(resultPolynomial);
        displayResultToTextField(resultString);
    }


    public void derivation(){
        if (tfFirstPolynomial.getText().isEmpty()){
            UserInterface.showAlertForTextField1();
        }
        polynomial1 =  parsePolynomString(tfFirstPolynomial);
        polynomial1.sortDegrees();
        Polynomial resultPolynomial = Operations.derivatePolynomial(polynomial1);
        String resultString = resultPolynomial.getPolynomialStringWithDoubles(resultPolynomial);
        displayResultToTextField(resultString);


    }
    public void integration(){
        if (tfFirstPolynomial.getText().isEmpty()){
            UserInterface.showAlertForTextField1();
        }
        else {
            polynomial1 = parsePolynomString(tfFirstPolynomial);
            polynomial1.sortDegrees();
            Polynomial resultPolynomial = Operations.integratePolynomial(polynomial1);
            String resultString = resultPolynomial.getPolynomialStringWithDoubles(resultPolynomial);
            resultString = resultString + '+' + 'C';
            displayResultToTextField(resultString);
        }
    }

    public void multiplication() {
        createPolynomials();
        Polynomial resultPolynomial = Operations.multiplyPolynomials(polynomial1, polynomial2);
        String resultString = resultPolynomial.getPolynomialStringWithIntegers(resultPolynomial);
        displayResultToTextField(resultString);
    }

    public void displayResultToTextField (String s){
        tfResult.setText(s);
    }

    public void division() {
        createPolynomials();
        Polynomial[] resultPolynomial = Operations.dividePolynomials(polynomial1,polynomial2);
            if (resultPolynomial==null){
                UserInterface.showAlertForDivision();
            }
            else {
                String quotientString = resultPolynomial[0].getPolynomialStringWithDoubles(resultPolynomial[0]);
                displayResultToTextField(quotientString);
                displayResultToTextField("Remainder:");
                String remainderString = resultPolynomial[1].getPolynomialStringWithDoubles(resultPolynomial[1]);
                String resultString = "Quotient: " + quotientString+ " Remainder:"+ remainderString;
                displayResultToTextField(resultString);
            }
    }
    public void clearTextFields(javafx.event.ActionEvent actionEvent) {
        tfFirstPolynomial.clear();
        tfSecondPolynomial.clear();
        tfResult.clear();
    }

}