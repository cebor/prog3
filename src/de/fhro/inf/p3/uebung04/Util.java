package de.fhro.inf.p3.uebung04;

import java.util.*;

/**
 * User: sid
 * Date: 08.06.2004
 * Time: 08:08:07
 */
public abstract class Util {


    /**
     *
     * @param xs die umzudrehende Liste
     * @return die umgedrehte Liste als Kopie
     *         xs ist unveraendert
     */
    public static <T> List<T> reverse(List<T> xs) {
        List<T> ys = new ArrayList<T>();
        for (int j = xs.size() - 1; j >= 0; j--) {
            ys.add(xs.get(j));
        }
        return ys;
    }

    /**
     * @param xs die umzudrehende Liste
     *           xs wird auf der Stelle umgedreht
     */
    public static <T> void reverse1(final List<T> xs) {
        for (int i = 0; i < xs.size() / 2; i++) {
            int j = xs.size() - i - 1;
            T x = xs.get(i);
            xs.set(i, xs.get(j));
            xs.set(j, x);
        }
    }
}
