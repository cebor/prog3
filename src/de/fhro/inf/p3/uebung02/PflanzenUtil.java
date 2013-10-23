package de.fhro.inf.p3.uebung02;

import java.util.*;

/**
 * @author brm
 * @version 2010-10-07
 * changed Hue 2013
 */
public class PflanzenUtil {
	/**
	 * Sortiere ein Array von Pflanzen nach aufsteigender Größe.
	 * 
	 * @param pflanzen      das zu sortierende Array.
	 */
	public static void sortByHeight(Pflanze[] pflanzen) {
		Arrays.sort(pflanzen);
	}

	/**
	 * Sortiere eine Liste von Pflanzen nach ihrer Bodenart.
	 * 
	 * @param pflanzen      die zu sortierende Liste.
	 */
	public static void sortByBoden(List<Pflanze> pflanzen) {
		Collections.sort(pflanzen, new BodenComparator());
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
	 * @param blumen       die Collection von Blumen
	 * @return eine Map, die zu jeder Farbe die entsprechende Menge von Blumen
	 *         enthält.
	 */
	public static Map<Integer, List<Blume>> trenneBlumenNachFarbe(
			Collection<Blume> blumen) {

		Map<Integer, List<Blume>> result = new HashMap<Integer, List<Blume>>();

		for (Blume b : blumen) {
			int farbe = b.getFarbe();
			if (result.containsKey(farbe)) {
				// Farbe ist schon bekannt, aktuelle Blume zu der entsprechenden
				// Menge hinzufügen
				result.get(farbe).add(b);
			} else {
				// Farbe ist noch nicht bekannt, neu anlegen
				List<Blume> farbSet = new ArrayList<Blume>();
				farbSet.add(b);
				result.put(farbe, farbSet); // autoboxing
			}
		}
		return result;
	}
}
