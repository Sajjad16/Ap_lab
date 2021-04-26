package com.company;

import java.util.ArrayList;

/**
 * This class holds square, triangular, and circular objects.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Paint {
    private ArrayList<Triangle> triangles;
    private ArrayList<Circle> circles;
    private ArrayList<Rectangle> rectangles;

    /**
     * Creates empty sets of objects.
     */
    public Paint() {
        triangles = new ArrayList<>();
        circles = new ArrayList<>();
        rectangles = new ArrayList<>();
    }

    /**
     * Adds a triangle to the list of triangles.
     *
     * @param triangle A triangle to be added.
     */
    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
    }

    /**
     * Adds a circle to the list of circles.
     *
     * @param circle A circle to be added.
     */
    public void addCircle(Circle circle) {
        circles.add(circle);
    }

    /**
     * Adds a rectangle to the list of rectangles.
     *
     * @param rectangle A rectangle to be added.
     */
    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    /**
     * Displays all available shapes
     */
    public void drawAll() {
        for (Rectangle rectangle : rectangles)
            rectangle.draw();
        for (Triangle triangle : triangles)
            triangle.draw();
        for (Circle circle : circles)
            circle.draw();

    }

    /**
     * Describes all shapes.
     */
    public void printAll() {
        for (Rectangle rectangle : rectangles)
            System.out.println(rectangle);
        for (Triangle triangle : triangles)
            System.out.println(triangle);
        for (Circle circle : circles)
            System.out.println(circle);
    }
}
