package de.fhro.inf.p3.uebung02;

/**
 * @author brm
 * @version 2010-10-07
 */
public class Strauch extends Pflanze {
	public Strauch(String name, int hoehe, int bodenart) {
		super(name, hoehe, bodenart);
	}

	public int getFarbe() {
		return Pflanze.GRUEN;
	}
	
	public String toString() {
		return "Strauch ("+getName()+", "+getHoehe()+", "+bodenartToString(getBodenart())+", "+farbeToString(getFarbe())+")";
	}
}
