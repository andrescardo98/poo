package com.andres.rectangle.app;

import com.andres.rectangle.domain.Rectangle;

public class RectangleApp {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle("Green","Clay");

        r1.calculatePerimeter(22,24);
        r1.calculateArea(22,24);

        System.out.println(r1.getData());
    }
}
