package de.fhro.inf.p3.uebung07;

import java.awt.*;

/**
 * Abstrakte Basisklasse die das implementiern konkrete Shapes etwas vereinfacht.
 *
 * @author brm
 */
abstract public class AbstractShape implements Shape {
    private Color color;
    private int size;

    public AbstractShape(Color color, int size) {
        this.color = color;
        this.size = size;
    }

    public Color getColor() {
        return this.color;
    }

    public int getSize() {
        return this.size;
    }
}
