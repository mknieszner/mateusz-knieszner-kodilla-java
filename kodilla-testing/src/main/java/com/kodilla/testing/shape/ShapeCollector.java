package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains Shape implemented interface figures in ArrayList with basic methods.
 */
public class ShapeCollector {
    private final List<Shape> shapeList = new ArrayList<>();
    private final StringBuilder listToPrint = new StringBuilder();

    public void addShape(final Shape shape) {
        shapeList.add(shape);
    }

    public boolean removeFigure(final Shape shape) {
        boolean result = false;
        if (shapeList.contains(shape)) {
            shapeList.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int i) {
        return shapeList.get(i);
    }

    public void showFigures() {
        for (Shape shape : shapeList) {
            listToPrint.append(shape);
        }
        System.out.println(listToPrint);
    }

    public int listSize() {
        return shapeList.size();
    }

    public String getEvenList() {
        return listToPrint.toString();
    }

}
