package de.fhro.inf.p3.uebung02;

/**
 * Created by felix on 10/10/13.
 *
 * Flower Class
 */
public class Flower extends Plant {

    private int color;

    public Flower(String name, double height, int kind, int color) {
        super(name, height, kind);

        if (color == colors.GREEN.ordinal() && color >= colors.values().length)
            throw new AssertionError();

        this.color = color;
    }

    @Override
    int getColor() {
        return color;
    }
}
