package model;

public class Operations {

    public static Polynomial addPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial resultPolynomial;
        resultPolynomial = polynomial1;
        int power;
        double oldCoeff, newCoeff;
        for (Monomial monom : polynomial2.getPolynomial()) {
            power = monom.getPower();
            if (resultPolynomial.findMonomialInPolynom(resultPolynomial, power) != null) {
                Monomial newMonomial = resultPolynomial.findMonomialInPolynom(resultPolynomial, power);
                oldCoeff = newMonomial.getCoefficient();
                newCoeff = oldCoeff + monom.getCoefficient();
                newMonomial.setCoefficient(newCoeff);
            } else {
                resultPolynomial.getPolynomial().add(monom);
            }
        }
        resultPolynomial.getPolynomial().removeIf(monom -> monom.getCoefficient() == 0);
        resultPolynomial.sortDegrees();
            return resultPolynomial;
    }

    public static Polynomial subtractPoynomials(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial resultPolynomial;
        resultPolynomial = polynomial1;
        int power;
        double oldCoeff, newCoeff, coefficient;
        for (Monomial monom : polynomial2.getPolynomial()) {
            power = monom.getPower();
            coefficient = monom.getCoefficient();
            if (resultPolynomial.findMonomialInPolynom(resultPolynomial, power) != null) {
                Monomial newMonomial = resultPolynomial.findMonomialInPolynom(resultPolynomial, power);
                oldCoeff = newMonomial.getCoefficient();
                newCoeff = oldCoeff-coefficient;
                newMonomial.setCoefficient(newCoeff);
            } else {
                Monomial newMonomial=new Monomial(power, -coefficient);
                resultPolynomial.getPolynomial().add(newMonomial);
            }
        }
        resultPolynomial.getPolynomial().removeIf(monom -> monom.getCoefficient() == 0);
        resultPolynomial.sortDegrees();
        return resultPolynomial;
    }


    public static Polynomial derivatePolynomial(Polynomial polynomial1){
        Polynomial resultPolynomial = new Polynomial();
        int oldPower;
        double oldCoeff;

        for (Monomial monom : polynomial1.getPolynomial()) {
            oldCoeff = monom.getCoefficient();
            oldPower = monom.getPower();
            Monomial newMonomial = new Monomial(oldPower - 1, oldPower * oldCoeff);
            resultPolynomial.getPolynomial().add(newMonomial);
        }
        resultPolynomial.sortDegrees();
        resultPolynomial.getPolynomial().remove(resultPolynomial.getPolynomial().size()-1);
        resultPolynomial.getPolynomial().removeIf(monom -> monom.getCoefficient() == 0);
        return resultPolynomial;
    }

    public static Polynomial integratePolynomial(Polynomial polynomial1){
        Polynomial resultPolynomial = new Polynomial();
        int oldPower;
        double oldCoeff;

        for (Monomial monom : polynomial1.getPolynomial()) {
            oldCoeff = monom.getCoefficient();
            oldPower = monom.getPower();
            Monomial newMonomial = new Monomial(oldPower +1,  oldCoeff/(oldPower+1));
            resultPolynomial.getPolynomial().add(newMonomial);
        }
        resultPolynomial.getPolynomial().removeIf(monom -> monom.getCoefficient() == 0);
        resultPolynomial.sortDegrees();
        return resultPolynomial;
    }

    public static Polynomial multiplyPolynomials(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial resultPolynomial = new Polynomial();
        double newCoefficient, oldCoefficient, coefficient1, coefficient2;
        int newPower, power1, power2;
        for (Monomial monom1 : polynomial1.getPolynomial()){
            for (Monomial monom2 : polynomial2.getPolynomial()){
                power1= monom1.getPower();
                power2=monom2.getPower();
                coefficient1= monom1.getCoefficient();
                coefficient2= monom2.getCoefficient();

                newPower=power1+power2;
                newCoefficient=coefficient1*coefficient2;
                if (resultPolynomial.findMonomialInPolynom(resultPolynomial, newPower)!=null){
                    oldCoefficient=resultPolynomial.findMonomialInPolynom(resultPolynomial, newPower).getCoefficient();
                    resultPolynomial.findMonomialInPolynom(resultPolynomial, newPower).setCoefficient(oldCoefficient+newCoefficient);
                }
                else{
                    Monomial newMonomial = new Monomial(newPower,newCoefficient);
                    resultPolynomial.getPolynomial().add(newMonomial);
                }
            }
        }
        resultPolynomial.getPolynomial().removeIf(monom -> monom.getCoefficient() == 0);
        resultPolynomial.sortDegrees();
        return resultPolynomial;
    }

            /*
    public static Polynomial dividePolynomials(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial();
        Polynomial[] resultPolynomial= new Polynomial[2];

    }
            */

}
