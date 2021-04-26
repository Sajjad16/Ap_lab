package com.company;

import java.util.ArrayList;

/**
 * This class presents the shape of a triangle.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Triangle extends Polygon {

    /**
     * Create a triangle.
     *
     * @param firstSide  The first side of the triangle.
     * @param secondSide The second side of the triangle.
     * @param thirdSide  The third side of the triangle.
     */
    public Triangle(double firstSide, double secondSide, double thirdSide) {
        super(String.valueOf(firstSide), String.valueOf(secondSide), String.valueOf(thirdSide));
    }

    /**
     * This method examines the isosceles of a triangle.
     *
     * @return Is a triangle equilateral or not.
     */
    public boolean isEquilateral() {
        ArrayList<Double> sides = super.getSides();
        return (sides.get(0).equals(sides.get(1))) && (sides.get(1).equals(sides.get(2)));
    }

    /**
     * This method calculates the area of the triangle.
     *
     * @return Area of the triangle.
     */
    @Override
    public double calculateArea() {
        ArrayList<Double> sides = super.getSides();
        double semiPerimeter = this.calculatePerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sides.get(0)) *
                (semiPerimeter - sides.get(1)) * (semiPerimeter - sides.get(2)));

    }

    /**
     * This method displays the traingle.
     */
    @Override
    public void draw() {
        System.out.println("Shape:Triangle\nPerimeter:" + super.calculatePerimeter() +
                "\nArea:" + calculateArea());
    }

    /**
     * This method describes the triangle as a string.
     *
     * @return A string of the triangle.
     */
    @Override
    public String toString() {
        return "\"Triangle:: " + super.toString() + '\"';
    }
}
