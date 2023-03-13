package com.andres.rectangle.domain;

public class Rectangle {
    public double large;
    public double width;
    public double perimeter;
    public double area;
    public String color;
    public String material;

    public Rectangle(String color, String material) {
        this.color = color;
        this.material = material;
    }

    public double calculatePerimeter(double large, double width){
        perimeter = (2*large) + (2*width);
        return perimeter;
    }

    public double calculateArea(int large, int width){
        area = (large * width);
        return area;
    }

    public String getData(){
        return "The perimeter of the rectangle is: " + this.perimeter + "\nand the area is: " + this.area;
    }
}
