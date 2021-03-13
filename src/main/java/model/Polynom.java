package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Polynom {

    private ArrayList<Monom> polynom = new ArrayList<>();

    public ArrayList<Monom> getPolynom() {
        return polynom;
    }

    public void setPolynom(ArrayList<Monom> polynom) {
        this.polynom = polynom;
    }
}
