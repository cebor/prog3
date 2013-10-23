/**
 * Created on 	15.04.2004
 * @author  	Hue  nach Vorlagen von Sid / Weigend
 * Zweck:		Anagram Beispiele f�r Stringoperationen und Interface Comparable	
 */
package de.fhro.inf.p3.uebung03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Klasse vergleicht zwei Strings nach dem Anagram-Prinzip:
 * wenn die Strings aus den gleichen Buchstaben bestehen
 * sind sie gleich
 * <p>
 * Beispiel: "ttoo" ist ein Anagramm von "otto",
 * der Vergleich würde Identität ergeben
 */
public class Anagram implements Comparator<String> {
	public int compare(String x, String y) {
		String sx = x;
		String sy = y;

		// Strings in Arrays von char umwandeln
		char[] cx = sx.toCharArray();
		char[] cy = sy.toCharArray();

		// Arrays von char sortieren, wobei die Referenz bleibt (final) und 
		// sich die Reihenfolge der Elemente ändert
		Arrays.sort(cx);
		Arrays.sort(cy);

		// Array von char wieder in Strings umwandeln
		String tx = new String(cx);
		String ty = new String(cy);

		// in sich sortierte Strings vergleichen
		int result = tx.compareTo(ty);

		// wenn tx und ty ein Anagram sind, dann werden die Ausgangs-Strings zusätzlich verglichen
		// um die Reihenfolge festzustellen
		return 0 == result ? sx.compareTo(sy) : result;
	}
}
