package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Polynomial {

    private ArrayList<Monomial> polynomial = new ArrayList<>();

    public ArrayList<Monomial> getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(ArrayList<Monomial> polynomial) {
        this.polynomial = polynomial;
    }

    public static Comparator<Monomial> monomialComparator = (o1, o2) -> Integer.compare(o2.getPower(), o1.getPower());


    public void sortDegrees() {

        Collections.sort(polynomial, monomialComparator);
    }


    public Monomial findMonomialInPolynom(Polynomial p, int power) {
        for (Monomial mon : p.getPolynomial()) {
            if (mon.getPower() == power) {
                return mon;
            }
        }
        return null;
    }
    public String getPolynomialStringWithIntegers(Polynomial p) {
        StringBuilder polynomString = new StringBuilder();
        for (Monomial mon : p.getPolynomial()) {
            if (mon.getCoefficient() > 0) {
                if (mon.getCoefficient() != 1) {
                    if (mon.getPower() == 1) {
                        polynomString.append("+").append(((int) mon.getCoefficient())).append("x");
                    } else if (mon.getPower() == 0) {
                        polynomString.append("+").append(((int) mon.getCoefficient()));
                    } else {
                        polynomString.append("+").append((int) mon.getCoefficient()).append("x^").append(mon.getPower());
                    }
                } else {
                    if (mon.getPower() == 1) {
                        polynomString.append("+").append("x");
                    } else if (mon.getPower() == 0) {
                        polynomString.append("+").append("1");
                    } else {
                        polynomString.append("+").append("x^").append(mon.getPower());
                    }
                }
            }
            if (mon.getCoefficient() < 0) {
                if ((mon.getCoefficient() != -1)) {
                    if (mon.getPower() == 1) {
                        polynomString.append(((int) mon.getCoefficient())).append("x");
                    } else if (mon.getPower() == 0) {
                        polynomString.append(((int) mon.getCoefficient()));
                    } else {
                        polynomString.append((int) mon.getCoefficient()).append("x^").append(mon.getPower());
                    }
                } else {
                    if (mon.getPower() == 1) {
                        polynomString.append("-").append("x");
                    } else if (mon.getPower() == 0) {
                        polynomString.append("-").append("1");
                    } else {
                        polynomString.append("-").append("x^").append(mon.getPower());
                    }
                }
            }
        }
        return polynomString.toString();
    }

    public String getPolynomialStringWithDoubles(Polynomial p) {
        StringBuilder polynomString = new StringBuilder();
        for (Monomial mon : p.getPolynomial()) {
            if (mon.getCoefficient() > 0) {
                if (mon.getCoefficient() != 1) {
                    if (mon.getPower() == 1) {
                        polynomString.append("+").append(String.format("%.2f", mon.getCoefficient())).append("x");
                    } else if (mon.getPower() == 0) {
                        polynomString.append("+").append(String.format("%.2f", mon.getCoefficient()));
                    } else {
                        polynomString.append("+").append(String.format("%.2f", mon.getCoefficient())).append("x^").append(mon.getPower());
                    }
                } else {
                    if (mon.getPower() == 1) {
                        polynomString.append("+").append("x");
                    } else if (mon.getPower() == 0) {
                        polynomString.append("+").append("1");
                    } else {
                        polynomString.append("+").append("x^").append(mon.getPower());
                    }
                }
            }
            if (mon.getCoefficient() < 0) {
                if ((mon.getCoefficient() != -1)) {
                    if (mon.getPower() == 1) {
                        polynomString.append("+").append(String.format("%.2f", mon.getCoefficient())).append("x");
                    } else if (mon.getPower() == 0) {
                        polynomString.append("+").append(String.format("%.2f", mon.getCoefficient()));
                    } else {
                        polynomString.append("+").append(String.format("%.2f", mon.getCoefficient())).append("x^").append(mon.getPower());
                    }
                } else {
                    if (mon.getPower() == 1) {
                        polynomString.append("-").append("x)");
                    } else if (mon.getPower() == 0) {
                        polynomString.append("-").append("1");
                    } else {
                        polynomString.append("-").append("x^").append(mon.getPower());
                    }
                }
            }
        }
        return polynomString.toString();
    }

}

