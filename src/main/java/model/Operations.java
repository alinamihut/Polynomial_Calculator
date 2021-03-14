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
       // resultPolynomial.getPolynomial().removeIf(monom -> monom.getCoefficient() == 0);
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
        //resultPolynomial.getPolynomial().removeIf(monom -> monom.getCoefficient() == 0);
        resultPolynomial.sortDegrees();

        return resultPolynomial;
    }
}
