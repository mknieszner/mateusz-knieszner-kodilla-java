package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains Shape implemented interface figures in ArrayList with basic methods.
 */
public class ShapeCollector {
    private final List<Shape> shapeList = new ArrayList<>();


    public void addShape(final Shape shape) {
        shapeList.add(shape);
    }

    public boolean removeFigure(final Shape shape) {
        return shapeList.remove(shape);
    }

    public Shape getFigure(int i) {
        return shapeList.get(i);
    }

    public void showFigures() {
        final StringBuilder listToPrint = new StringBuilder();
        for (Shape shape : shapeList) {
            listToPrint.append(shape);
        }
        System.out.println(listToPrint);
    }

    public int size() {
        return shapeList.size();
    }
}
