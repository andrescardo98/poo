package com.andres.geometricShapes.domain;

public class Square extends GeometricShape{
    private double sideMeasure;

    public Square(double sideMeasure) {
        this.sideMeasure = sideMeasure;
    }

    @Override
    public double getArea() {
            return Math.pow(this.sideMeasure, 2);
    }

    @Override
    public double getPerimeter() {
        return 4 * this.sideMeasure;
    }
}
