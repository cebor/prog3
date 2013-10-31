package de.fhro.inf.p3.uebung05;

import java.util.AbstractList;
import java.util.List;

/**
 * Created by felix on 10/30/13.
 */
public class Util {

    public static List<Integer> range(final int size) {
        if (size >= 0) {
            return new AbstractList<Integer>() {
                @Override
                public Integer get(int i) {
                    if (i >= 0 && i < size())
                        return i;
                    else
                        throw new IndexOutOfBoundsException();
                }

                @Override
                public int size() {
                    return size;
                }
            };
        } else
            throw new IndexOutOfBoundsException();
    }

    public static List slice(final List xs, final int start, final int stop) {
        if (stop < xs.size() && start <= stop && start >= 0 && stop >= 0)
            return new AbstractList() {
                @Override
                public Object get(int i) {
                    if (i >= 0 && i <= size())
                        return xs.get(start + i);
                    else
                        throw new IndexOutOfBoundsException();
                }

                @Override
                public int size() {
                    return stop - start + 1;
                }
            };
        else
            throw new IndexOutOfBoundsException();
    }
}
