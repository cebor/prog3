package de.fhro.inf.p3.uebung07;

import java.awt.*;

/**
 * Schnittstelle für alle Formen (Shapes) die auf dem Bildschirm herumwuseln können.
 *
 * @author brm
 */
public interface Shape {
    public void paint(Graphics graphics, Point location);

    public Color getColor(); // Farbe des Shapes

    public int getSize();     // Größe des Shapes

    public int getXExtend(); // wie weit erstreckt sich das Element vom Mittelpunkt in jede Richtung?

    public int getYExtend(); // wie weit erstreckt sich das Element vom Mittelpunkt in jede Richtung?
}
