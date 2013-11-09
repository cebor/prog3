package de.fhro.inf.p3.uebung07;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by felix on 11/8/13.
 */
public class KugelFactory {

    private Map<Color, Map<Integer, Kugel>> kugeln;

    private static KugelFactory inst = new KugelFactory();

    private KugelFactory() {
        kugeln = new HashMap<Color, Map<Integer, Kugel>>();
    }

    public static KugelFactory getInstance() {
        return inst;
    }

    public Kugel createKugel(Color color, int size) {
        Map<Integer, Kugel> colorKugeln = kugeln.get(color);
        if (colorKugeln == null) {
            colorKugeln = new HashMap<Integer, Kugel>();
            kugeln.put(color, colorKugeln);
        }

        Kugel kugel = colorKugeln.get(size);
        if (kugel == null) {
            kugel = new Kugel(color, size);
            colorKugeln.put(size, kugel);
        }

        return kugel;
    }

    public int getCount() {
        int result = 0;
        for (Map<Integer, Kugel> colorKugeln : kugeln.values()) {
            result += colorKugeln.size();
        }
        return result;
    }
}
