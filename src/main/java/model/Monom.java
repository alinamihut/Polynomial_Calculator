package model;

public class Monom {
    private int power;
    private double coefficient;

    public Monom(int power, double coefficient) {
        this.power = power;
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
}
