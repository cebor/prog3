/**
 * Created on 	10.04.2004
 * @author Hue/FdR  nach Vorlagen von Sid
 * Zweck:		Beispiel für rekursive Methode und Interface Comparator
 * letzte Änderung:  2.6.05 / FdR
 */
package de.fhro.inf.p3.uebung05;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * MergeSort ist eine Sammlung von Funktionen zum Sortieren von Listen mit MergeSort
 */
public class MergeSort<T> {

    /**
     * Das ist der MergeSort
     *
     * @param list zu sortierende Liste
     * @param cmp  Vergleichsfunktion
     * @return sortierte Liste
     */
    public List<T> mergeSort(List<T> list, Comparator<T> cmp) {
        if (list == null)
            return new ArrayList<T>();
        if (list.size() <= 1)
            return list;

        List<T> l1;
        List<T> l2;

        l1 = left(list);                // linke Hälfte
        l1 = mergeSort(l1, cmp);
        l2 = right(list);                 // rechte Hälfte
        l2 = mergeSort(l2, cmp);

        return merge(l1, l2, cmp);
    }

    /**
     * merge erwartet zwei nach cmp sortierte Listen. Das Ergebnis
     * von merge ist die Mischung von liste1 und liste2 als ArrayList.
     *
     * @param liste1 sortierte Liste
     * @param liste2 sortierte Liste
     * @param cmp    Vergleichsfunktion
     * @return sortierte Liste durch merge von liste1 und liste2
     */
    public List<T> merge(List<T> liste1, List<T> liste2, Comparator<T> cmp) {

        int i1 = 0;
        int i2 = 0;

        List<T> result = new ArrayList<T>();

        while (i1 < liste1.size() && i2 < liste2.size()) {  // kleineren anfügen
            if (cmp.compare(liste1.get(i1), liste2.get(i2)) <= 0)
                result.add(liste1.get(i1++));
            else
                result.add(liste2.get(i2++));
        }
        // Rest anfügen
        while (i1 < liste1.size())
            result.add(liste1.get(i1++));

        while (i2 < liste2.size())
            result.add(liste2.get(i2++));

        return result;
    }

    /**
     * left liefert die linke Hälfte einer Liste bis auschließlich
     * list.size()/2. Bei ungerader Länge ist die linke Hälfte also kürzer.
     *
     * @param list zu teilende Liste
     * @return linke Hälfte der Liste
     */
    public List<T> left(final List<T> list) {
        if (list == null || list.size() == 0)
            return list;
        // return list.subList(0, list.size() / 2);
        final int offset = list.size() / 2;
        return new AbstractList<T>() {
            @Override
            public T get(int i) {
                if (i >= 0 && i < size())
                    return list.get(i);
                else
                    throw new IndexOutOfBoundsException();
            }

            @Override
            public int size() {
                return offset;
            }
        };
    }

    /**
     * right liefert die rechte Hälfte einer Liste ab einschließlich
     * list.size()/2. Bei ungerader Länge ist die rechte Hälfte also länger.
     *
     * @param list zu teilende Liste
     * @return rechte Hälfte der Liste
     */
    public List<T> right(final List<T> list) {
        if (list == null || list.size() == 0)
            return list;
        // return list.subList(list.size() / 2, list.size());
        final int offset = list.size() / 2;
        return new AbstractList<T>() {
            @Override
            public T get(int i) {
                if (i >= 0 && i < size())
                    return list.get(offset + i);
                else
                    throw new IndexOutOfBoundsException();
            }

            @Override
            public int size() {
                return list.size() - offset;
            }
        };
    }
}
