package com.kodilla.testing.shape;

/**
 * Square basic variables and methods.
 */
public class Square implements Shape {
    private final double field;

    public Square(final double length) {
        this.field = length * length;
    }

    @Override
    public String getShapeName() {
        return "square";
    }

    @Override
    public double getField() {
        return field;
    }

    @Override
    public String toString() {
        return "Square{" + "field= " + field + " name= square" + " }";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Square square = (Square) o;

        return Double.compare(square.field, field) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(field);
        return (int) (temp ^ (temp >>> 32));
    }
}
