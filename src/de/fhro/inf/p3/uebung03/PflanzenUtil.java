package de.fhro.inf.p3.uebung03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.fhro.inf.p3.uebung02.Blume;
import de.fhro.inf.p3.uebung02.BodenComparator;
import de.fhro.inf.p3.uebung02.Pflanze;

/**
 * @author brm
 * @version 2010-10-07
 */
public class PflanzenUtil {
	/**
	 * Sortiere ein Array von Pflanzen nach aufsteigender Größe.
	 * 
	 * @param pa
	 *            das zu sortierende Array.
	 */
	public static void sortByHeight(Pflanze[] pa) {
		Arrays.sort(pa);
	}

	/**
	 * Sortiere eine Liste von Pflanzen nach ihrer Bodenart.
	 * 
	 * @param pl
	 *            die zu sortierende Liste.
	 */
	public static void sortByBoden(List<Pflanze> pl) {
		Collections.sort(pl, new BodenComparator());
	}

	/**
	 * Sortiere eine Collection von Blumen nach Farbe
	 * 
	 * @param blumen
	 *            die Collection von Blumen
	 * @param roteBlumen
	 *            alle roten Blumen
	 * @param gelbeBlumen
	 *            alle gelben Blumen
	 * @param weisseBlumen
	 *            alle weissen Blumen
	 * @param orangeBlumen
	 *            alle orangen Blumen
	 */
	public static void trenneBlumenNachFarbe(Collection<Blume> blumen,
			List<Blume> roteBlumen, List<Blume> gelbeBlumen,
			List<Blume> weisseBlumen, List<Blume> orangeBlumen) {
		for (Blume b : blumen) {
			switch (b.getFarbe()) {
			case Pflanze.GELB:
				gelbeBlumen.add(b);
				break;
			case Pflanze.ROT:
				roteBlumen.add(b);
				break;
			case Pflanze.WEISS:
				weisseBlumen.add(b);
				break;
			case Pflanze.ORANGE:
				orangeBlumen.add(b);
				break;
			default:
				throw new RuntimeException("Illegal Color (code="
						+ b.getFarbe() + ") in Blume b=" + b.toString());
			}
		}
	}

	/**
	 * Sortiere eine Collection von Blumen nach Farbe - bessere, flexiblere
	 * Implementierung, erlaubt das Hinzufügen von neuen Farben ohne Änderung an
	 * dieser Methode.
	 * 
	 * @param blumen
	 *            die Collection von Blumen
	 * @return eine Map, die zu jeder Farbe die entsprechende Menge von Blumen
	 *         enthält.
	 */
	public static Map<Integer, List<Blume>> trenneBlumenNachFarbe(Collection<Blume> blumen) {
		return trenneNachFarbe(blumen);
	}
	
	/**
	 * Sortiere eine Collection von Pflanzen oder Subklassen nach Farbe - bessere, flexiblere
	 * Implementierung, erlaubt das Hinzufügen von neuen Farben ohne Änderung an
	 * dieser Methode.
	 * 
	 * @param pflanzen
	 *            die Collection von Pflanzen
	 * @return eine Map, die zu jeder Farbe die entsprechende Menge von Blumen
	 *         enthält.
	 */
	public static <T extends Pflanze> Map<Integer, List<T>> trenneNachFarbe(Collection<T> pflanzen) {

		Map<Integer, List<T>> result = new HashMap<Integer, List<T>>();

		for (T pflanze : pflanzen) {
			int farbe = pflanze.getFarbe();
			if (result.containsKey(farbe)) {
				// Farbe ist schon bekannt, aktuelle Blume zu der entsprechenden
				// Menge hinzufügen
				result.get(farbe).add(pflanze);
			} else {
				// Farbe ist noch nicht bekannt, neu anlegen
				List<T> farbListe = new ArrayList<T>();
				farbListe.add(pflanze);
				result.put(farbe, farbListe); // autoboxing
			}
		}
		return result;
	}


}
