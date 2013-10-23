package de.fhro.inf.p3.uebung02;

import java.util.*;

/**
 * @author brm
 * @version 2010-10-07
 */

public class Beet {
	private int bodenart;
	private List<Pflanze> pflanzen;
	
	/**
	 * Erzeugt ein neues Beet.
	 * @param bodenart Die Art des Bodens im Beet.
	 */
	public Beet(int bodenart) {
		this.bodenart = bodenart;
		this.pflanzen = new ArrayList<Pflanze>();
	}
	
	/**
	 * Welcher Boden existiert in diesem Beet?
	 * @return der Boden in diesem Beet.
	 */
	public int getBodenart() {
		return this.bodenart;
	}
	
	/**
	 * Wieviele Pflanzen sind in diesem Beet?
	 * @return Anzahl der Pflanzen im Beet.
	 */
	public int getAnzahlPflanzen() {
		return pflanzen.size();
	}
	
	/**
	 * Füge die pflanze an die hinterste Stelle im Beet ein.
	 * @param pflanze die einzufügende Pflanze
	 * @return false wenn die Bodenart der Pflanze nicht mit dem Beet übereinstimmt, true sonst.
	 */
	public boolean addPflanze(Pflanze pflanze) {
		if(pflanze.getBodenart() != this.bodenart)
			return false;
		pflanzen.add(pflanze);
		return true;
	}

	/**
	 * Füge die pflanze an die Stelle index im Beet ein.
	 * @param index Stelle, an der die Pflanze eingefügt werden soll.
	 * @param pflanze die einzufügende Pflanze
	 * @return false wenn die Bodenart der Pflanze nicht mit dem Beet übereinstimmt oder index falsch, true sonst.
	 */
	public boolean addPflanze(int index, Pflanze pflanze) {
		if(pflanze.getBodenart() != this.bodenart)
			return false;
		if (index > pflanzen.size())
			return false;
		pflanzen.add(index, pflanze);
		return true;
	}
	
	/**
	 * Entfernt eine Pflanze aus dem Beet.
	 * @param index Position der zu entfernenden Pflanze.
	 * @return die entfernte Pflanze
	 */
	public Pflanze removePflanze(int index) {
		return pflanzen.remove(index);
	}
	
	/**
	 * Gibt die Pflanze an einer bestimmten Position im Beet zurück.
	 * @param index Position im Beet.
	 * @return die Pflanze an dieser Position.
	 */
	public Pflanze getPflanze(int index) {
		return pflanzen.get(index);
	}
	
	/**
	 * Wieviele verschiedene Farben sind im Beet vorhanden?
	 * @return Anzahl Farben im Beet.
	 */
	public int getAnzahlFarben() {
		// viele verschiedene Lösungen möglich.
		Set<Integer> colors = new HashSet<Integer>();
		
		for(Pflanze p : pflanzen) {
			colors.add(p.getFarbe()); // autoboxing!
		}
		return colors.size();
	}
	
	/**
	 * Sortiere die Pflanzen im Beet nach Größe.
	 */
	public void sortByHeight() {
		// zum Glück ist die natürliche Ordnung auf Pflanzen genau passend!
		Collections.sort(pflanzen);
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		
		buf.append("Beet("+Pflanze.bodenartToString(bodenart)+"):\n");
		for(Pflanze p: pflanzen) {
			buf.append("  "+p.toString()+"\n");
		}
		return buf.toString();
	}
}
