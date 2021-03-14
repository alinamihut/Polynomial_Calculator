package controller;
            //2x^3-4x+10
//2x^4-33x^3+2x^2-11
//x^3-2x^2+6x-5
            //15x^2-4x+110
import model.Monomial;
import model.Operations;
import model.Polynomial;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

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


    public void clearTextFields(javafx.event.ActionEvent actionEvent) {
        tfFirstPolynomial.clear();
        tfSecondPolynomial.clear();
    }

    public Polynomial parsePolynomString(TextField textField) {
        Polynomial polynomial = new Polynomial();
        String polynomString = textField.getText();
        String polynomRegex = "([-+]?)(\\d*\\.?\\d*)?([xX](\\^-?\\d*\\.?\\d*)?)?";
        Pattern pattern = Pattern.compile(polynomRegex);
        Matcher matcher = pattern.matcher(polynomString);
        boolean reachedEnd = false;
        double coefficient = 0;
        int power = 0;
        while (matcher.find() && !reachedEnd) {
            //System.out.println("sign" + matcher.group(1));
           // System.out.println("coeff" + matcher.group(2));
            //System.out.println("x" + matcher.group(3));
            //System.out.println("power" + matcher.group(4));
            if (matcher.group(1).compareTo("-") == 0) {
                if(matcher.group(2).isEmpty()) {
                    coefficient=-1.0;
                }
                else{
                    coefficient = (Double.parseDouble(matcher.group(2))) * (-1);

                }
            } else {
                if(matcher.group(2).isEmpty()) {
                    coefficient=1.0;
                }
                else{
                    coefficient = Double.parseDouble(matcher.group(2));
                }
            }
            if (matcher.group(3) != null && matcher.group(4) != null) {
                power = Integer.parseInt(matcher.group(4).substring(1));
            } else if ((matcher.group(3) != null && matcher.group(4) == null)) {
                power = 1;
            } else if (matcher.group(3) == null && matcher.group(4) == null && matcher.group(2)!=null) {
                power = 0;
                reachedEnd = true;
            }
            //System.out.println("coef" + coefficient);
            //System.out.println("power" + power);

            Monomial newMonom = new Monomial(power, coefficient);
            polynomial.getPolynomial().add(newMonom);
        }

        return polynomial;
    }
       // StringTokenizer multiTokenizer = new StringTokenizer(polynomString, "x^");
        //int count = 0;
       // int power=0;
       // double coefficient=0.0;
       // String coeff=null, pow=null;
        /*
        while (multiTokenizer.hasMoreTokens()) {
        System.out.println(multiTokenizer.nextToken());
            if (count==0){
                coeff=(String.valueOf(multiTokenizer.nextToken("x^")));
                count=1;
            }

            if (count==1){
                pow=(multiTokenizer.nextToken("x"));
                count=0;
            }
*/

    public void createPolynomials (){
       polynomial1 =  parsePolynomString(tfFirstPolynomial);
       polynomial2 = parsePolynomString(tfSecondPolynomial);

       polynomial1.sortDegrees();
       polynomial2.sortDegrees();
       for ( Monomial monom: polynomial1.getPolynomial()){
           System.out.println( "coeff" + monom.getCoefficient() + "power" + monom.getPower());
       }

        for ( Monomial monom: polynomial2.getPolynomial()) {
            System.out.println("coeff" + monom.getCoefficient() + "power" + monom.getPower());
        }
    }


    public void addition(){
        createPolynomials();
        Polynomial resultPolynomial = Operations.addPolynomials(polynomial1,polynomial2);
        System.out.println("Addition result is: ");
        for ( Monomial monom: resultPolynomial.getPolynomial()) {
            System.out.println("coeff" + monom.getCoefficient() + "power" + monom.getPower());
        }
    }

    public void subtraction(){
        createPolynomials();
        Polynomial resultPolynomial = Operations.subtractPoynomials(polynomial1,polynomial2);
        System.out.println("Subtraction result is: ");
        for ( Monomial monom: resultPolynomial.getPolynomial()) {
            System.out.println("coeff" + monom.getCoefficient() + "power" + monom.getPower());
        }
    }


    public void derivation(){
        polynomial1 =  parsePolynomString(tfFirstPolynomial);
        polynomial1.sortDegrees();
        Polynomial resultPolynomial = Operations.derivatePolynomial(polynomial1);
        System.out.println("Derivation result is: ");
        for ( Monomial monom: resultPolynomial.getPolynomial()) {
            System.out.println("coeff" + monom.getCoefficient() + "power" + monom.getPower());
        }

    }
    public void integration(){
        polynomial1 =  parsePolynomString(tfFirstPolynomial);
        polynomial1.sortDegrees();
        Polynomial resultPolynomial = Operations.integratePolynomial(polynomial1);
        System.out.println("Integration result is: ");
        for ( Monomial monom: resultPolynomial.getPolynomial()) {
            System.out.println("coeff" + monom.getCoefficient() + "power" + monom.getPower());
        }

    }
}