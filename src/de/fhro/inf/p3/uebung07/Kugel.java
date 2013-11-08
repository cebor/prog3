package de.fhro.inf.p3.uebung07;

import java.awt.*;

/**
 * Ein konkretes Shapes, nämlich eine Kugel.
 *
 * @author brm
 */
public class Kugel extends AbstractShape {
    private static int SIZE_MULTIPLIER = 3;

    public Kugel(Color color, int size) {
        super(color, size);
    }

    public void paint(Graphics graphics, Point location) {
        graphics.setColor(this.getColor());
        graphics.fillOval(location.x - radius(), location.y - radius(), 2 * radius(), 2 * radius());
    }

    public int getXExtend() {
        return radius();
    }

    public int getYExtend() {
        return radius();
    }

    private int radius() {
        return this.getSize() * SIZE_MULTIPLIER;
    }

}
