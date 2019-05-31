package com.example.designmode.factory;

public class ShapeTest {
    public static void main(String[] args){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("circle");
        circle.onDraw();

        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.onDraw();
    }
}
