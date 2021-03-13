package controller;
            //2x^3-4x+10
//2x^4-33x^3+2x^2-11
            //15x^2-4x+110
import javafx.fxml.FXML;
import model.Monom;
import model.Polynom;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {


    private Polynom polynom1 = new Polynom();
    private Polynom polynom2 = new Polynom();


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

    public Polynom parsePolynomString(TextField textField) {
        Polynom polynom = new Polynom();
        String polynomString = textField.getText();
        String polynomRegex = "([-+]?)(\\d*\\.?\\d*)?([xX](\\^-?\\d*\\.?\\d*)?)?";
        Pattern pattern = Pattern.compile(polynomRegex);
        Matcher matcher = pattern.matcher(polynomString);
        boolean reachedEnd = false;
        double coefficient = 0;
        int power = 0;
        while (matcher.find() && !reachedEnd) {
            //System.out.println(matcher.group(1));
            //System.out.println(matcher.group(2));
            //System.out.println(matcher.group(3));
            //System.out.println(matcher.group(4));
            if (matcher.group(1).compareTo("-") == 0) {
                coefficient = (Double.parseDouble(matcher.group(2))) * (-1);

            } else {
                coefficient = Double.parseDouble(matcher.group(2));
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

            Monom newMonom = new Monom(power, coefficient);
            polynom.getPolynom().add(newMonom);

            coefficient = 0.0;
        }

        return polynom;
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


//^ ([-+]? ([0-9] * \.? [0-9] + )? (X (\ ^ [+-]? [0-9] + )?)?)
           // "((-?\\d+(?=x))?(-?[xX])(\\^(-?\\d+))?)|((-?)[xX])|(-?\\d+)"
            System.out.println( "coeff" + coeff+ "power" + pow);
        }*/
         /*   int coeffient;

        boolean negativeCoefficient=false;
        for (int i=0;i<polynomString.length();i++){
            negativeCoefficient=false;
            if (i%5==0){
                if (polynomString.charAt(i)== '-'){
                    negativeCoefficient=true;
                }
            }
            if (i%5==1){

            }
        }
        */



    public void parseBothStrings (){
       polynom1=  parsePolynomString(tfFirstPolynomial);
       polynom2= parsePolynomString(tfSecondPolynomial);

       for ( Monom monon: polynom1.getPolynom()){
           System.out.println( "coeff" + monon.getCoefficient() + "power" + monon.getPower());
       }

        for ( Monom monon: polynom2.getPolynom()){
            System.out.println( "coeff" + monon.getCoefficient() + "power" + monon.getPower());
        }
    }




}