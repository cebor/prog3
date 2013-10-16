package de.fhro.inf.p3.uebung02;

/**
 * Created by felix on 10/10/13.
 *
 * Bush
 */
public class Bush extends Plant {

    public Bush(String name, double height, int kind) {
        super(name, height, kind);
    }

    @Override
    int getColor() {
        return colors.GREEN.ordinal();
    }
}
