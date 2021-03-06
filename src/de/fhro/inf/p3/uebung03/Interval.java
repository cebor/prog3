/**
 * Created on 	10.04.2004
 * @author  	Hue  nach Vorlagen von Sid
 * Zweck:		Beispiel für Nutzung des Interfaces Comparable	
 */
package de.fhro.inf.p3.uebung03;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse für Intervalle definiert durch eine untere und obere Grenze.
 * <p>
 * Die Grenzen müssen das Interface Comparable implementieren.
 * Eine Überprüfung ob die untere Grenze kleiner als die obere
 * Grenze ist findet nicht statt
 */
public class Interval {
	private Comparable lowerBound;
	private Comparable upperBound;

	private static final Integer ZERO = new Integer(0);
	public static final Interval EMPTY = new Interval(ZERO, ZERO);

	private static Comparable min(Comparable x, Comparable y) {
		return x.compareTo(y) <= 0 ? x : y;
	}

	private static Comparable max(Comparable x, Comparable y) {
		return x.compareTo(y) > 0 ? x : y;
	}

	/**
	 * untere Grenze >= obere Grenze bedeutet leeres Intervall
	 *
	 * @param lowerBound    untere Grenze des Intervalls
	 * @param upperBound    obere Grenze des Intervalls
	 */
	public Interval(Comparable lowerBound, Comparable upperBound) {
		if (lowerBound == null || upperBound == null)
			throw new IllegalArgumentException();
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	/**
	 *
	 * @param x  zu vergleichendes Intervall
	 * @return   true falls Intervallgrenzen identisch sind
	 */
	public boolean equals(Object x) {
        if (this == x)
            return true;

		if (getClass() != x.getClass())
			return false;
		Interval iv = (Interval) x;
		return (isEmpty() && iv.isEmpty()) // beide leer 
		|| (lowerBound.equals(iv.lowerBound) && upperBound.equals(iv.upperBound));

	}

	/**
	 * @return true, falls lowerBound <= x < upperBound
	 */
	public boolean contains(Comparable x) {
		return lowerBound.compareTo(x) <= 0 && upperBound.compareTo(x) > 0;
	}

    /**
     * @param v das andere Intervall
     * @return true, wenn this das andere Intervall enthält
     */
    public boolean contains(Interval v) {
        return v.isEmpty()
                || (lowerBound.compareTo(v.lowerBound) <= 0 && upperBound
                        .compareTo(v.upperBound) >= 0);
    }

 	/**
	 * @return Durchschnitt von this und iv.
	 */
	public Interval intersection(Interval iv) {
		return new Interval(
			max(lowerBound, iv.lowerBound),
			min(upperBound, iv.upperBound));
	}
	
    /**
     * @param v das andere Intervall
     * @return Liste von einem oder zwei Intervallen
     *         obere Grenze erstes Intervall < untere Grenze zweites Intervall
     */
    public List union(Interval v) {
        List result = new ArrayList();

        if (isEmpty())
            result.add(v);      // v unveraendert
        else if (v.isEmpty())
            result.add(this);   // this unveraendert
        else if (upperBound.compareTo(v.lowerBound) < 0) { // this links von v
            result.add(this);
            result.add(v);
        } else if (v.upperBound.compareTo(lowerBound) < 0) { // v links von this
            result.add(v);
            result.add(this);
        } else {
            Interval w = new Interval(min(lowerBound, v.lowerBound),
                                                  max(upperBound, v.upperBound));
            result.add(w);
        }
        return result;
    }


	/**
	 * @return true, falls lowerbound >= upperbound
	 */
	public boolean isEmpty() {
		return lowerBound.compareTo(upperBound) >= 0;
	}

	/**
	 *
	 * @return eindeutiger Hash-Wert vom Intervall
	 */
	public int hashCode() {
        return isEmpty() ? 0 : lowerBound.hashCode() + upperBound.hashCode();
	}
	
    public String toString() {
        return '[' + lowerBound.toString() + ", " + upperBound.toString() + '[';
    }
}
