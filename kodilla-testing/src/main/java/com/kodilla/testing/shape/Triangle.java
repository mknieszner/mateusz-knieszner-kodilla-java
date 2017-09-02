package com.kodilla.testing.shape;

/**
 * Triangle basic variables and methods.
 */
public class Triangle implements Shape {
    private final double field;

    public Triangle(final double length, final double height) {
        this.field = length * height / 2;
    }

    @Override
    public String getShapeName() {
        return "triangle";
    }

    @Override
    public double getField() {
        return field;
    }

    @Override
    public String toString() {
        return "Triangle {" + "field= " + field + " name= triangle" + " }";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Triangle triangle = (Triangle) o;

        return Double.compare(triangle.field, field) == 0;
    }

    @Override
    public int hashCode() {
        final long temp = Double.doubleToLongBits(field);
        return (int) (temp ^ (temp >>> 32));
    }
}
