
/**
 * Created on 	10.04.2004
 * @author  	Hue  nach Vorlagen von Sid
 * Zweck:		Beispiel für Umgang mit Collections
 */
package de.fhro.inf.p3.uebung03;

import java.util.*;

/**
 * abstrakte Klasse mit statischen Methoden zur Erstellung eines Index
 */
public abstract class TypesafeIndex {

	/**
	 * Erstellt für ein Array von Listen von Strings einen Index
	 * @param book  das Buch als Array von Listen; jede Liste enthält die zu indizierenden Begriffe
	 * @return      eine TreeMap. Key = Begriff; Value = Set der Seiten, auf denen dieser Begriff
	 *              vorkommt.
	 */
	public static SortedMap<String, SortedSet<Integer>> makeIndex(List<String>[] book) {

		SortedMap<String,SortedSet<Integer>> idx = new TreeMap<String,SortedSet<Integer>>();
		// SortedMap ist ein Interface, das Map erweitert; TreeMap eine Implementierung

		for (int i = 0; i < book.length; ++i) { // fuer alle Seiten
			Iterator<String> j = book[i].iterator();
			while (j.hasNext()) {
				String word = j.next(); // aktuelles Wort
				SortedSet<Integer> pages = idx.get(word);
				// SortedSet ist ein Interface, das Set erweitert

				if (pages == null) { // Wort kommt zum ersten Mal vor
					pages = new TreeSet<Integer>();
					// TreeSet ist eine Implementierung von SortedSet
					idx.put(word, pages);
				}

				pages.add(new Integer(i));
				// Seiten-Nummer wird an SortedSet für das aktuelle Wort gehängt
			}
		}
		return idx;
	}

	/**
	 * Erstellt für ein Array von Listen von Strings einen Index.
	 * <p>
	 * Der Index wird auf eine vorgegebene Menge von Wörtern eingeschränkt.
	 * @param book  das Buch als Array von Seiten; jede Seite liegt vor als Liste von Worten
	 * @param keywords  Menge aller Begriffe, deren Vorkommen indiziert wird
	 * @return      eine SortedMap. Key = Begriff; Value = Set der Seiten, auf denen dieser Begriff
	 *              vorkommt.
	 */
	public static SortedMap<String, SortedSet<Integer>> makeIndex(List<String>[] book, Set<String> keywords) {
	
		SortedMap<String, SortedSet<Integer>> idx = new TreeMap<String,SortedSet<Integer>>();

		for (int i = 0; i < book.length; ++i) { // fuer alle Seiten

			// Schnittmenge aller Begriffe dieser Seite mit den Keyword-Begriffen
			Set<String> tmp = new HashSet<String>(book[i]);
			tmp.retainAll(keywords); // von Seite i bleiben nur keywords übrig

			// und jetzt geht es exakt wie in der ersten Methode 
			Iterator<String> j = tmp.iterator();
			while (j.hasNext()) {
				String word = (String) j.next(); // aktuelles Wort
				SortedSet<Integer> pages = idx.get(word);
				// SortedSet ist ein Interface, das Set erweitert

				if (pages == null) { // Wort kommt zum ersten Mal vor
					pages = new TreeSet<Integer>();
					// TreeSet ist eine Implementierung von SortedSet
					idx.put(word, pages);
				}

				pages.add(new Integer(i));
				// Seiten-Nummer wird an SortedSet für das aktuelle Wort gehängt
			}
		}
		return idx;
	}

}
