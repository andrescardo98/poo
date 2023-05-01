package com.andres.geometricShapes.domain;

public class ScaleneTriangle extends Triangle{
    private double base;
    private double measureSide2;
    private double measureSide3;
    private double semiPerimeter;

    public ScaleneTriangle(double measureSide1, double measureSide2, double measureSide3) {
        this.base = measureSide1;
        this.measureSide2 = measureSide2;
        this.measureSide3 = measureSide3;
    }

    private void calculateSemiPerimeter(){
        this.semiPerimeter = ((this.base + this.measureSide2 + this.measureSide3)/2);
    }

    @Override
    public double getArea() {
        calculateSemiPerimeter();
        return (Math.sqrt(this.semiPerimeter*(this.semiPerimeter - this.base)*
                (this.semiPerimeter - this.measureSide2) * (this.semiPerimeter - this.measureSide3)));
    }

    @Override
    public double getPerimeter() {
        return this.base + this.measureSide2 + this.measureSide3;
    }
}
