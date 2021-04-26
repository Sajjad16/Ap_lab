package com.company;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class represents a polygon and is a superclass for polygon shapes.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public abstract class Polygon extends Shape {
    private ArrayList<Double> sides;

    /**
     * Create a polygon.
     *
     * @param args The Set of polygonal sides.
     */
    public Polygon(String... args) {
        sides = new ArrayList<>();
        for (String arg : args)
            sides.add(Double.parseDouble(arg));
    }

    /**
     * Returns the sides of a polygon.
     *
     * @return The sides of a polygon
     */
    public ArrayList<Double> getSides() {
        return sides;
    }


    /**
     * This method calculates the perimeter of the polygon.
     *
     * @return Perimeter of the polygon.
     */
    @Override
    public double calculatePerimeter() {
        double perimeter = 0;
        for (Double side : sides) {
            perimeter += side;
        }
        return perimeter;
    }

    /**
     * This method calculates the area of the polygon.
     *
     * @return Area of the polygon.
     */
    @Override
    public abstract double calculateArea();

    /**
     * This method displays the polygon.
     */
    @Override
    public abstract void draw();


    /**
     * This method detects the same as another shape.
     *
     * @param o The shape in which the input is taken.
     * @return To be the same or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polygon)) return false;
        Polygon polygon = (Polygon) o;
        return Objects.equals(getSides(), polygon.getSides());
    }

    /**
     * This method describes the rectangle as a string.
     *
     * @return A string of the rectangle.
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < sides.size(); i++) {
            str += "side" + (i + 1) + ":" + sides.get(i);
            if (i != sides.size() - 1)
                str += ", ";
        }
        return str;
    }


}
