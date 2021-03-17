
import static org.junit.Assert.assertTrue;

import model.Monomial;
import model.Operations;
import model.Polynomial;
import org.junit.Test;


public class OperationsTest {

    @Test
    public void additionTest() {
        Monomial m1 = new Monomial(3, 3);
        Monomial m2 = new Monomial(2, 2);
        Monomial m3 = new Monomial(0, 1);
        Monomial m4 = new Monomial(1, 4);
        Monomial m5 = new Monomial(0, -2);

        Polynomial p1 = new Polynomial();
        p1.getPolynomial().add(m1);
        p1.getPolynomial().add(m2);
        p1.getPolynomial().add(m3);
        p1.sortDegrees();

        Polynomial p2 = new Polynomial();
        p2.getPolynomial().add(m4);
        p2.getPolynomial().add(m5);
        p2.sortDegrees();

        Polynomial result;
        result= Operations.addPolynomials(p1,p2);
        result.sortDegrees();
        String resultString= result.getPolynomialStringWithIntegers(result);

        assertTrue("The result of the addition operation should be +3x^3+2x^2+4x-1", resultString.equals("+3x^3+2x^2+4x-1"));
    }

    @Test
    public void subtractionTest() {
        Monomial m1 = new Monomial(3, 3);
        Monomial m2 = new Monomial(2, 2);
        Monomial m3 = new Monomial(0, 1);
        Monomial m4 = new Monomial(1, 4);
        Monomial m5 = new Monomial(0, -2);

        Polynomial p1 = new Polynomial();
        p1.getPolynomial().add(m1);
        p1.getPolynomial().add(m2);
        p1.getPolynomial().add(m3);
        p1.sortDegrees();

        Polynomial p2 = new Polynomial();
        p2.getPolynomial().add(m4);
        p2.getPolynomial().add(m5);
        p2.sortDegrees();

        Polynomial result;
        result= Operations.subtractPoynomials(p1,p2);
        result.sortDegrees();
        String resultString= result.getPolynomialStringWithIntegers(result);

        assertTrue("The result of the subtraction operation should be +3x^3+2x^2-4x+3", resultString.equals("+3x^3+2x^2-4x+3"));
    }

    @Test
    public void multiplicationTest() {
        Monomial m1 = new Monomial(3, 3);
        Monomial m2 = new Monomial(2, 2);
        Monomial m3 = new Monomial(0, 1);
        Monomial m4 = new Monomial(1, 4);
        Monomial m5 = new Monomial(0, -2);

        Polynomial p1 = new Polynomial();
        p1.getPolynomial().add(m1);
        p1.getPolynomial().add(m2);
        p1.getPolynomial().add(m3);
        p1.sortDegrees();

        Polynomial p2 = new Polynomial();
        p2.getPolynomial().add(m4);
        p2.getPolynomial().add(m5);
        p2.sortDegrees();

        Polynomial result;
        result= Operations.multiplyPolynomials(p1,p2);
        result.sortDegrees();
        String resultString= result.getPolynomialStringWithIntegers(result);

        assertTrue("The result of the multiplication operation should be +12x^4+2x^3-4x^2+4x-2", resultString.equals("+12x^4+2x^3-4x^2+4x-2"));
    }
    public void divisionTest() {
        Monomial m1 = new Monomial(3, 3);
        Monomial m2 = new Monomial(2, 2);
        Monomial m3 = new Monomial(0, 1);
        Monomial m4 = new Monomial(1, 4);
        Monomial m5 = new Monomial(0, -2);

        Polynomial p1 = new Polynomial();
        p1.getPolynomial().add(m1);
        p1.getPolynomial().add(m2);
        p1.getPolynomial().add(m3);
        p1.sortDegrees();

        Polynomial p2 = new Polynomial();
        p2.getPolynomial().add(m4);
        p2.getPolynomial().add(m5);
        p2.sortDegrees();

        Polynomial[] result;
        result= Operations.dividePolynomials(p1,p2);
        assert result != null;
        String quotientString = result[0].getPolynomialStringWithDoubles(result[0]);
        String remainderString = result[1].getPolynomialStringWithDoubles(result[1]);
        String resultString = "Quotient: " + quotientString+ " Remainder:"+ remainderString;

        assertTrue( resultString.equals("Quotient: +0.75x^2+0.88x+0.44 Remainder:+1.88"));
    }
    @Test
    public void derivationTest() {
        Monomial m1 = new Monomial(3, 3);
        Monomial m2 = new Monomial(2, 2);
        Monomial m3 = new Monomial(0, 1);

        Polynomial p1 = new Polynomial();
        p1.getPolynomial().add(m1);
        p1.getPolynomial().add(m2);
        p1.getPolynomial().add(m3);
        p1.sortDegrees();

        Polynomial result;
        result= Operations.derivatePolynomial(p1);
        result.sortDegrees();
        String resultString= result.getPolynomialStringWithDoubles(result);

        assertTrue("The result of the derivation operation should be +9x^2+4x ", resultString.equals("+9.00x^2+4.00x"));
    }
    @Test
    public void integrationTest() {
        Monomial m1 = new Monomial(3, 3);
        Monomial m2 = new Monomial(2, 3);
        Monomial m3 = new Monomial(0, 1);

        Polynomial p1 = new Polynomial();
        p1.getPolynomial().add(m1);
        p1.getPolynomial().add(m2);
        p1.getPolynomial().add(m3);
        p1.sortDegrees();

        Polynomial result;
        result= Operations.integratePolynomial(p1);
        result.sortDegrees();
        String resultString= result.getPolynomialStringWithDoubles(result);
        resultString =resultString+"+C";
        assertTrue( resultString.equals("+0.75x^4+x^3+x+C"));
    }

}
