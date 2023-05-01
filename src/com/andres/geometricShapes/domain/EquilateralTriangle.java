package com.andres.geometricShapes.domain;

public class EquilateralTriangle extends Triangle{
    private double sideMeasure;
    private double height;

    public EquilateralTriangle(double sideMeasure) {
        this.sideMeasure = sideMeasure;
    }

    @Override
    public double getArea() {
        this.height = (Math.sqrt(3) * this.sideMeasure)/2;
        return (this.sideMeasure * this.height)/2;
    }

    @Override
    public double getPerimeter() {
        return this.sideMeasure * 3;
    }
}
