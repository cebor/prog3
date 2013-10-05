package de.fhro.inf.p3.uebung01;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 10/4/13
 * Time: 10:53 AM
 * Übung 01
 */
public class RoList {

    private Object[] elements;
    private int size;

    public RoList() {
        elements = new Object[0];
        size = 0;
    }

    public RoList(RoList xs) {
        elements = new Object[xs.elements.length];
        System.arraycopy(xs.elements, 0, elements, 0, xs.elements.length);
        size = xs.size;
    }


    /**
     * removes all elements from this
     */
    public void clear() {
        elements = new Object[0];
        size = 0;
    }

    /**
     * adds x to this
     *
     * @param x element
     */
    public void add(Object x) {
        Object[] array = new Object[elements.length + 1];
        System.arraycopy(elements, 0, array, 0, elements.length);
        elements = array;
        elements[size++] = x;
    }

    /**
     * adds all elements in xs to this
     *
     * @param xs collection of elements
     */
    public void addAll(Collection xs) {
        for (Object e : xs) {
            add(e);
        }
    }

    /**
     * removes element at position i
     *
     * @param i position
     */
    public void remove(int i) {
        if (i < size) {
            Object[] array = new Object[elements.length - 1];
            size = 0;
            for (int j = 0; j < elements.length; j++) {
                if (j != i) {
                    array[size++] = elements[j];
                }
            }
            elements = array;
        } else
            throw new NoSuchElementException();
    }

    /**
     * removes element x from this
     *
     * @param x element
     * @return true when element x exists
     */
    public boolean remove(Object x) {
        if (contains(x)) {
            remove(indexOf(x));
            return true;
        }
        return false;
    }

    /**
     * removes all elements in xs from this
     *
     * @param xs collection of elements
     */
    public void removeAll(Collection xs) {
        for (Object e : xs) {
            remove(e);
        }
    }

    /**
     * indexOf method
     *
     * @param x element
     * @return index or -1 when not found
     */
    public int indexOf(Object x) {
        for (int i = 0; i < elements.length; i++) {
            if (x.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * contains method
     *
     * @param x element
     * @return true or false
     */
    public boolean contains(Object x) {
        return indexOf(x) != -1;
    }

    /**
     * returns element at position i
     *
     * @param i index
     * @return element @ [i]
     */
    public Object get(int i) {
        return elements[i];
    }


    /**
     * replaces element y at position i with x
     *
     * @param i position
     * @param x element
     * @return element y
     */
    public Object set(int i, Object x) {
        Object e = elements[i];
        elements[i] = x;
        return e;
    }

    /**
     * size()
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Iterator Method
     *
     * @return Iterator
     */
    public Iterator iterator() {
        return new RoIterator(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoList roList = (RoList) o;

        return size == roList.size && Arrays.equals(elements, roList.elements);
    }

    @Override
    public int hashCode() {
        int result = elements != null ? Arrays.hashCode(elements) : 0;
        result = 31 * result + size;
        return result;
    }

    @Override
    public RoList clone() {
        return new RoList(this);
    }

    /**
     * Iterator Helper for RoList
     */
    private class RoIterator implements Iterator {
        private Object array[];
        private int pos = 0;

        public RoIterator(Object array[]) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return pos < array.length;
        }

        @Override
        public Object next() throws NoSuchElementException {
            if (hasNext())
                return array[pos++];
            else
                throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
