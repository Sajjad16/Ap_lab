package com.company;

import java.util.ArrayList;

/**
 * This class holds shapes.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Paint {
    private ArrayList<Shape> shapes;

    /**
     * Creates empty sets of shapes.
     */
    public Paint() {
        shapes = new ArrayList<>();
    }

    /**
     * Adds a shape to the list of shapes.
     *
     * @param shape A shape to be added.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Displays all available shapes
     */
    public void drawAll() {
        for (Shape shape : shapes)
            shape.draw();
    }

    /**
     * Describes all shapes.
     */
    public void printAll() {
        for (Shape shape : shapes)
            System.out.println(shape);
    }

    /**
     * This method finds and prints squares and equilateral triangles in the list of shapes.
     */
    public void describeEqualSides() {
        for (Shape shape : shapes) {
            if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                if (rectangle.isSquare())
                    System.out.println(rectangle);
            }
            if (shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                if (triangle.isEquilateral())
                    System.out.println(triangle);
            }
        }
    }
}
