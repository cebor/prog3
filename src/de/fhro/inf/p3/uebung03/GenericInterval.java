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
public class GenericInterval<T extends Comparable<T>> {
	private T lowerBound;
	private T upperBound;

	// Achtung: statische Attribute dürfen keine Typvariablen verwenden
	//private static final Integer ZERO = new Integer(0);
	//public static final GenericInterval<Integer> EMPTY = new GenericInterval<Integer>(ZERO, ZERO);

	
	private static <T extends Comparable<T>> T min(T x, T y) {
	// private static <T extends Comparable<? super T>> T min(T x, T y) {  
	// Variante mit wildcard: geht auch für Typen die nicht Comparable implmentiert haben aber deren Basisklassen
		return x.compareTo(y) <= 0 ? x : y;
	}
	
	private static <C extends Comparable<C>> C max(C x, C y) {
	// private static <C extends Comparable<C>> C max(C x, C y) {  // verbessere Variante		
		return x.compareTo(y) > 0 ? x : y;
	}

	/**
	 * untere Grenze >= obere Grenze bedeutet leeres Intervall
	 *
	 * @param lowerBound    untere Grenze des Intervalls
	 * @param upperBound    obere Grenze des Intervalls
	 */
	public GenericInterval(T lowerBound, T upperBound) {
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
		// der Parameter muss vom Typ Object sein wegen der Spezifikation der Klasse Object	
		// deswegen kann diese Methode nicht generisch genacht werden
        if (this == x)
            return true;
		if (x == null)
			return false;
		
		if (getClass() != x.getClass()) 
			return false;
		GenericInterval<?> iv = (GenericInterval<?>) x;
		return (isEmpty() && iv.isEmpty()) // beide leer 
		|| (lowerBound.equals(iv.lowerBound) && upperBound.equals(iv.upperBound));

	}

	/**
	 * @return true, falls lowerBound <= x < upperBound
	 */
	public boolean contains(T x) {
		return lowerBound.compareTo(x) <= 0 && upperBound.compareTo(x) > 0;
	}

    /**
     * @param v das andere Intervall
     * @return true, wenn this das andere Intervall enthält
     */
    public boolean contains(GenericInterval<T> v) {
        return v.isEmpty()
                || (lowerBound.compareTo(v.lowerBound) <= 0 && upperBound
                        .compareTo(v.upperBound) >= 0);
    }

 	/**
	 * @return Durchschnitt von this und iv.
	 */
	public GenericInterval<T> intersection(GenericInterval<T> iv) {
		return new GenericInterval<T>(
			max(lowerBound, iv.lowerBound),
			min(upperBound, iv.upperBound));
	}
	
    /**
     * @param v das andere Intervall
     * @return Liste von einem oder zwei Intervallen
     *         obere Grenze erstes Intervall < untere Grenze zweites Intervall
     */
    public List<GenericInterval<T>> union(GenericInterval<T> v) {
        List<GenericInterval<T>> result = new ArrayList<GenericInterval<T>>();

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
        	GenericInterval<T> w = new GenericInterval<T>(min(lowerBound, v.lowerBound),
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
