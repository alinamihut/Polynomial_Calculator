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


    public static Comparator<Monomial>  monomialComparator = (o1, o2) -> Integer.compare(o2.getPower(), o1.getPower());


    public void sortDegrees (){

        Collections.sort(polynomial,monomialComparator );
    }


    public Monomial findMonomialInPolynom (Polynomial p, int power){
        for (Monomial mon:p.getPolynomial()){
            if (mon.getPower()==power){
                return mon;
            }
        }
        return null;
    }
}
