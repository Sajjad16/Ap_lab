package com.company;

import java.util.ArrayList;

/**
 * This class presents the shape of a rectangle.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Rectangle extends Polygon {

    /**
     * Create a rectangle.
     *
     * @param firstSide  The first side of the rectangle.
     * @param secondSide The second side of the rectangle.
     * @param thirdSide  The third side of the rectangle.
     * @param fourthSide The fourth side of the rectangle.
     */
    public Rectangle(double firstSide, double secondSide, double thirdSide, double fourthSide) {
        super(String.valueOf(firstSide), String.valueOf(secondSide), String.valueOf(thirdSide), String.valueOf(fourthSide));
    }

    /**
     * This method checks that the shape is square.
     *
     * @return Is it square in shape or not.
     */
    public boolean isSquare() {
        ArrayList<Double> sides = super.getSides();
        return (sides.get(0).equals(sides.get(1))) &&
                (sides.get(2).equals(sides.get(3))) && (sides.get(1).equals(sides.get(2)));
    }

    /**
     * This method calculates the area of the rectangle.
     *
     * @return Area of the rectangle.
     */
    public double calculateArea() {
        ArrayList<Double> sides = super.getSides();
        return sides.get(0) * sides.get(1);
    }

    /**
     * This method displays the rectangle.
     */
    @Override
    public void draw() {
        System.out.println("Shape:Rectangle\nPerimeter:" + super.calculatePerimeter() +
                "\nArea:" + this.calculateArea());
    }

    /**
     * This method describes the rectangle as a string.
     *
     * @return A string of the rectangle.
     */
    @Override
    public String toString() {
        return "\"Rectangle:: " + super.toString() + '\"';
    }
}
