package com.company;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class presents the shape of a rectangle.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Rectangle {
    private ArrayList<Double> sides;

    /**
     * Create a rectangle.
     *
     * @param firstSide  The first side of the rectangle.
     * @param secondSide The second side of the rectangle.
     * @param thirdSide  The third side of the rectangle.
     * @param fourthSide The fourth side of the rectangle.
     */
    public Rectangle(double firstSide, double secondSide, double thirdSide, double fourthSide) {
        sides = new ArrayList<>();
        sides.add(firstSide);
        sides.add(secondSide);
        sides.add(thirdSide);
        sides.add(fourthSide);
    }

    /**
     * Returns the sides of a rectangle.
     *
     * @return The sides of a rectangle
     */
    public ArrayList<Double> getSides() {
        return sides;
    }

    /**
     * This method checks that the shape is square.
     *
     * @return Is it square in shape or not.
     */
    public boolean isSquare() {
        return (sides.get(0).equals(sides.get(1))) &&
                (sides.get(2).equals(sides.get(3))) && (sides.get(1).equals(sides.get(2)));
    }

    /**
     * This method calculates the perimeter of the rectangle.
     *
     * @return Perimeter of the rectangle.
     */
    public double calculatePerimeter() {
        return sides.get(0) + sides.get(1) + sides.get(2) + sides.get(3);
    }

    /**
     * This method calculates the area of the rectangle.
     *
     * @return Area of the rectangle.
     */
    public double calculateArea() {
        return sides.get(0) * sides.get(1);
    }

    /**
     * This method displays the rectangle.
     */
    public void draw() {
        System.out.println("Shape:Rectangle\nPerimeter:" + this.calculatePerimeter() +
                "\nArea:" + this.calculateArea());
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
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(getSides(), rectangle.getSides());
    }

    /**
     * This method describes the rectangle as a string.
     *
     * @return A string of the rectangle.
     */
    @Override
    public String toString() {
        return "Rectangle{" +
                "sides=" + sides +
                '}';
    }
}
