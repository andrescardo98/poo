package com.andres.geometricShapes.app;

import com.andres.geometricShapes.domain.*;

import java.util.ArrayList;
import java.util.List;

public class GeometricShapeApp {
    public static void main(String[] args) {
        List<GeometricShape> shapes = new ArrayList<>();

        shapes.add(new Circle(5));
        shapes.add(new Square(6));
        shapes.add(new EquilateralTriangle(4));
        shapes.add(new ScaleneTriangle(6, 7, 2));

        shapes.forEach(geometricShape -> {
            System.out.println("\n" + geometricShape);
            System.out.println("Area: " + geometricShape.getArea());
            System.out.println("Perimeter: " + geometricShape.getPerimeter());
        });
    }
}
