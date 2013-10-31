package de.fhro.inf.p3.uebung05;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MergeSortIterator<Y> {
    /**
     * merge erwartet zwei Iteratoren, deren Objekte gemaess cmp aufsteigend
     * sortiert sind.
     *
     * @param i   erster Iterator
     * @param j   zweiter Iterator
     * @param cmp Vergleichsmezhode
     * @return Iterator, der i und j mischt. Duplikate werden nicht eliminiert.
     */
    public Iterator<Y> merge(final Iterator<Y> i, final Iterator<Y> j,
                             final Comparator<Y> cmp) {
        Comparator<Y> mergeCmp = new MergeComparator<Y>(cmp);
        return new MergeIterator<Y>(i, j, mergeCmp);
    }

    /*
     * Comparator der auch Vergleiche zulässt wenn eines der beiden Elemente null ist
     */
    private class MergeComparator<X> implements Comparator<X> {
        private final Comparator<X> cmp;

        public MergeComparator(Comparator<X> cmp) {
            this.cmp = cmp;
        }

        public int compare(X x, X y) {
            if (x == null && y == null)
                throw new NoSuchElementException();
            else if (x == null)
                return 1;
            else if (y == null)
                return -1;
            else
                return cmp.compare(x, y);
        }
    }

    /*
     * Iterator, der aus zwei Iteratoren besteht.
     * liefert bei hasNext() true solange ein Iterator noch ein Objekt liefert
     * liefert bei next() das kleinere Objekt der beiden Iteratoren
     */
    private class MergeIterator<T> implements Iterator<T> {

        private final Iterator<T> i;
        private final Iterator<T> j;
        private final Comparator<T> cmp;

        private T tmpI = null;
        private T tmpJ = null;

        public MergeIterator(Iterator<T> i, Iterator<T> j, Comparator<T> cmp) {
            this.i = i;
            this.j = j;
            this.cmp = cmp;
        }

        @Override
        public boolean hasNext() {
            return i.hasNext() || j.hasNext() || tmpI != null || tmpJ != null;
        }

        @Override
        public T next() {
            if (tmpI == null && i.hasNext())
                tmpI = i.next();
            if (tmpJ == null && j.hasNext())
                tmpJ = j.next();

            T min;
            if (cmp.compare(tmpI, tmpJ) <= 0) {
                min = tmpI;
                tmpI = null;
            } else {
                min = tmpJ;
                tmpJ = null;
            }
            return min;
        }

        @Override
        public void remove() {
            if (tmpI == null)
                i.remove();
            else if (tmpJ == null)
                j.remove();
        }
    }
}
