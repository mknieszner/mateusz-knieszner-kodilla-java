package com.kodilla.testing.shape;

/**
 * Circle basic variables and methods.
 */
public class Circle implements Shape {
    private final double field;

    public Circle(final double radious) {
        this.field = radious * radious * Math.PI;
    }

    @Override
    public String getShapeName() {
        return "circle";
    }

    @Override
    public double getField() {
        return field;
    }

    @Override
    public String toString() {
        return "Circle{" + "field= " + field + " name= circle" + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Circle circle = (Circle) o;

        return Double.compare(circle.field, field) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(field);
        return (int) (temp ^ (temp >>> 32));
    }
}
