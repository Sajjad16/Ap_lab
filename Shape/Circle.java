package com.company;

/**
 * This class presents the shape of a circle.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Circle {
    private double radius;

    /**
     * Create a circle.
     *
     * @param radius The radius of the circle to be made.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Returns the radius of the circle.
     *
     * @return The radius of the circle.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * This method calculates the perimeter of the circle.
     *
     * @return Perimeter of the circle.
     */
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * This method calculates the area of the circle.
     *
     * @return Area of the circle.
     */
    public double calculateArea() {
        return Math.pow(radius, 2) * Math.PI;

    }

    /**
     * This method displays the circle.
     */
    public void draw() {
        System.out.println("Shape:Circle\nPerimeter:" + calculatePerimeter() +
                "\nArea:" + calculateArea());
    }

    /**
     * This method detects the same as another shape.
     *
     * @param o The shape in which the input is taken.
     * @return To be the same or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }

    /**
     * This method describes the circle as a string.
     *
     * @return A string of the circle.
     */
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
