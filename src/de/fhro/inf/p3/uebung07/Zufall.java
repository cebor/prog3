package de.fhro.inf.p3.uebung07;

import java.awt.*;

/**
 * Erzeugt diverse zufällige Werte.
 *
 * @author brm
 */
public class Zufall {
    private static Color[] colors = {
            new Color(255, 40, 40), new Color(255, 80, 40), new Color(255, 120, 40), new Color(255, 160, 40), new Color(255, 200, 40), new Color(255, 240, 40),
            new Color(255, 40, 80), new Color(255, 80, 80), new Color(255, 120, 80), new Color(255, 160, 80), new Color(255, 200, 80), new Color(255, 240, 80),
            new Color(200, 240, 80), new Color(160, 80, 80), new Color(120, 120, 80), new Color(80, 160, 80), new Color(40, 200, 80), new Color(0, 240, 80)};

    /**
     * Zufälligen int Wert zwischen min und max zurückgeben.
     *
     * @param min
     * @param max
     * @return
     */
    public static int randomInt(int min, int max) {
        return ((int) (Math.random() * (max - min) + min));
    }

    /**
     * Zufällige Farbe aus den vorgegebenen Farben zurückgeben.
     *
     * @return
     */
    public static Color color() {
        return colors[randomInt(0, colors.length)];
    }

    /**
     * Zufällige Größe (<=maxSize) zurückgeben.
     *
     * @param maxSize
     * @return
     */
    public static int size(int maxSize) {
        return randomInt(0, maxSize);
    }

    /**
     * Zufällge Orts-Koordinate (location) zurückgeben
     *
     * @param max maximaler Wert.
     * @return
     */
    public static int loc(int max) {
        return randomInt(0, max);
    }

    /**
     * Zufällige Geschwindigkeit zwischen -max und max zurückgeben.
     *
     * @param max
     * @return
     */
    public static int speed(int max) {
        return randomInt(-max, max);
    }
}
