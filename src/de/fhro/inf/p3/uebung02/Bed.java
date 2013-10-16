package de.fhro.inf.p3.uebung02;

import java.util.*;

/**
 * @author brm
 * @version 2010-10-07
 */

public class Bed {
	private int bodenart;
	private List<Plant> pflanzen;
	
	/**
	 * Erzeugt ein neues Bed.
	 * @param bodenart Die Art des Bodens im Bed.
	 */
	public Bed(int bodenart) {
		this.bodenart = bodenart;
		this.pflanzen = new ArrayList<Plant>();
	}
	
	/**
	 * Welcher Boden existiert in diesem Bed?
	 * @return der Boden in diesem Bed.
	 */
	public int getBodenart() {
		return this.bodenart;
	}
	
	/**
	 * Wieviele Pflanzen sind in diesem Bed?
	 * @return Anzahl der Pflanzen im Bed.
	 */
	public int getAnzahlPflanzen() {
		return pflanzen.size();
	}
	
	/**
	 * Füge die pflanze an die hinterste Stelle im Bed ein.
	 * @param pflanze die einzufügende Pflanze
	 * @return false wenn die Bodenart der Pflanze nicht mit dem Bed übereinstimmt, true sonst.
	 */
	public boolean addPflanze(Plant pflanze) {
		if(pflanze.getKind() != this.bodenart)
			return false;
		pflanzen.add(pflanze);
		return true;
	}

	/**
	 * Füge die pflanze an die Stelle index im Bed ein.
	 * @param index Stelle, an der die Pflanze eingefügt werden soll.
	 * @param pflanze die einzufügende Pflanze
	 * @return false wenn die Bodenart der Pflanze nicht mit dem Bed übereinstimmt oder index falsch, true sonst.
	 */
	public boolean addPflanze(int index, Plant pflanze) {
		if(pflanze.getKind() != this.bodenart)
			return false;
		if (index > pflanzen.size())
			return false;
		pflanzen.add(index, pflanze);
		return true;
	}
	
	/**
	 * Entfernt eine Pflanze aus dem Bed.
	 * @param index Position der zu entfernenden Pflanze.
	 * @return die entfernte Pflanze
	 */
	public Plant removePflanze(int index) {
		return pflanzen.remove(index);
	}
	
	/**
	 * Gibt die Pflanze an einer bestimmten Position im Bed zurück.
	 * @param index Position im Bed.
	 * @return die Pflanze an dieser Position.
	 */
	public Plant getPflanze(int index) {
		return pflanzen.get(index);
	}
	
	/**
	 * Wieviele verschiedene Farben sind im Bed vorhanden?
	 * @return Anzahl Farben im Bed.
	 */
	public int getAnzahlFarben() {
		// viele verschiedene Lösungen möglich.
		Set<Integer> colors = new HashSet<Integer>();
		
		for(Plant p : pflanzen) {
			colors.add(p.getColor()); // autoboxing!
		}
		return colors.size();
	}
	
	/**
	 * Sortiere die Pflanzen im Bed nach Größe.
	 */
	public void sortByHeight() {
		// zum Glück ist die natüliche Ordnung auf Pflanzen genau passend!
		Collections.sort(pflanzen);
	}
}
