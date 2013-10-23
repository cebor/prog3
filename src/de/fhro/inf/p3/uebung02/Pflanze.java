package de.fhro.inf.p3.uebung02;

/**
 * @author brm
 * changed Hue 2013
 * @version 2010-10-07
 */
public abstract class Pflanze implements Comparable<Pflanze> {
	private String name;
	private int hoehe;
	private int bodenart;

	// öffentliche Konstanten für die Boden Arten
	public static final int SAND = 1;
	public static final int LEHM = 2;
	public static final int HUMUS = 3;

	// öffentliche Konstanten für die Farben
	public static final int ROT = 1;
	public static final int GELB = 2;
	public static final int WEISS = 3;
	public static final int ORANGE = 4;
	public static final int GRUEN = 5;
	
	// Bemerkung: besser wäre eine Lösung mit einem Enumerations-Typ, war aber noch nicht dran.
	// public enum Colors {ROT,GELB,WEISS,ORANGE,GRUEN}

	public Pflanze(String name, int hoehe, int bodenart) {
		this.name = name;
		this.hoehe = hoehe;
		this.bodenart = bodenart;
	}

	public String getName() {
		return name;
	}

	public int getHoehe() {
		return hoehe;
	}

	public int getBodenart() {
		return bodenart;
	}

	public abstract int getFarbe();

	// Teilaufgabe d)
	// compareTo must be consistent with equals 
	// e1.compareTo(e2) == 0 has the same boolean value as e1.equals(e2)
	public int compareTo(Pflanze x) {
		if (getHoehe() < x.getHoehe())
			return -1;
		if (getHoehe() > x.getHoehe())
			return 1;
		//else return 0;
		
		if (name != null && !this.equals(x))
			return name.compareTo(x.name);
		else
			return (bodenart < x.bodenart ? -1 : (bodenart == x.bodenart ? 0
					: 1));
	}

	
	/**
	 * Hilfsmethode um die Farbe ausgeben zu können.
	 * @param farbe eine Farbe
	 * @return Stringdarstellung der Farbe
	 */
	public static String farbeToString(int farbe) {
		switch (farbe) {
		case ROT:
			return "rot";
		case GELB:
			return "gelb";
		case WEISS:
			return "weiss";
		case ORANGE:
			return "orange";
		case GRUEN:
			return "grün";
		default:
			return "unbekannte Farbe";
		}
	}
	
	/**
	 * Hilfsmethode um den Boden ausgeben zu können.
	 * @param bodenart eine Bodenart
	 * @return Stringdarstellung der Bodenart
	 */
	public static String bodenartToString(int bodenart) {
		switch (bodenart) {
		case SAND:
			return "sand";
		case LEHM:
			return "lehm";
		case HUMUS:
			return "humus";
		default:
			return "unbekannte Bodenart";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bodenart;
		result = prime * result + hoehe;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pflanze other = (Pflanze) obj;
		if (bodenart != other.bodenart)
			return false;
		if (hoehe != other.hoehe)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
