package com.company;

/**
 * This class shows shapes and is a superclass for geometric shapes
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public abstract class Shape {

    /**
     * This method calculates the perimeter of the shape.
     *
     * @return perimeter of the shape.
     */
    public abstract double calculatePerimeter();

    /**
     * This method calculates the area of the shape.
     *
     * @return Area of the shape.
     */
    public abstract double calculateArea();

    /**
     * This method displays the shape.
     */
    public abstract void draw();

    /**
     * This method detects the same as another shape.
     *
     * @param o The shape in which the input is taken.
     * @return To be the same or not
     */
    public abstract boolean equals(Object o);

    /**
     * This method describes the circle as a string.
     *
     * @return A string of the circle.
     */
    @Override
    public abstract String toString();

}
