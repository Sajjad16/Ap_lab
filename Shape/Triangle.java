package com.company;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class presents the shape of a triangle.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Triangle {
    private ArrayList<Double> sides;

    /**
     * Create a traingle.
     *
     * @param firstSide  The first side of the triangle.
     * @param secondSide The second side of the triangle.
     * @param thirdSide  The third side of the triangle.
     */
    public Triangle(double firstSide, double secondSide, double thirdSide) {
        sides = new ArrayList<>();
        sides.add(firstSide);
        sides.add(secondSide);
        sides.add(thirdSide);
    }

    /**
     * Returns the sides of a triangle.
     *
     * @return The sides of a triangle
     */
    public ArrayList<Double> getSides() {
        return sides;
    }

    /**
     * This method checks whether the triangle is equilateral or not
     *
     * @return Is a triangle equilateral or not.
     */
    public boolean isEquilateral() {
        return (sides.get(0).equals(sides.get(1))) && (sides.get(1).equals(sides.get(2)));
    }

    /**
     * This method calculates the perimeter of the triangle.
     *
     * @return Perimeter of the triangle.
     */
    public double calculatePerimeter() {
        return sides.get(0) + sides.get(1) + sides.get(2);
    }

    /**
     * This method calculates the area of the triangle.
     *
     * @return Area of the triangle.
     */
    public double calculateArea() {
        double semiPerimeter = this.calculatePerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sides.get(0)) *
                (semiPerimeter - sides.get(1)) * (semiPerimeter - sides.get(2)));

    }

    /**
     * This method displays the traingle.
     */
    public void draw() {
        System.out.println("Shape:Triangle\nPerimeter:" + this.calculatePerimeter() +
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
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(getSides(), triangle.getSides());
    }

    /**
     * This method describes the traingle as a string.
     *
     * @return A string of the traingle.
     */
    @Override
    public String toString() {
        return "Triangle{" +
                "sides=" + sides +
                '}';
    }
}
