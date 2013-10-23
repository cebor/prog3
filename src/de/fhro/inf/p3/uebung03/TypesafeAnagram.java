/*
 * Created by IntelliJ IDEA.
 * User: sid
 * Date: Feb 3, 2002
 * Time: 9:38:12 AM
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
public class TypesafeAnagram implements Comparator<String> {
    public int compare(String sx, String sy) {
    	// String in char-Array umwandeln
        char[] cx = sx.toCharArray();
        char[] cy = sy.toCharArray();

        // Char-Array sortieren
        Arrays.sort(cx);
        Arrays.sort(cy);

        //Char-Array wieder in String umwandeln
        String tx = String.valueOf(cx);
        String ty = String.valueOf(cy);

        // in sich sortierte Strings vergleichen
        int result = tx.compareTo(ty);

		// wenn tx und ty ein Anagram sind, dann werden die Ausgangs-Strings zusätzlich verglichen
		// um die Reihenfolge festzustellen
        return 0 == result ? sx.compareTo(sy) : result;
    }
}
