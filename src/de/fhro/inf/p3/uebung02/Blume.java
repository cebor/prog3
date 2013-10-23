package de.fhro.inf.p3.uebung02;

/**
 * @author brm
 * @version 2010-10-07
 */
public class Blume extends Pflanze {
	private int farbe;

	/**
	 * Erzeugt eine neue Blume
	 * 
	 * @param name
	 *            Name der neuen Blume
	 * @param hoehe
	 *            Höhe der neuen Blume
	 * @param bodenart
	 *            Bodenart auf der diese Blume gut wächst
	 * @param farbe
	 *            Farbe der neuen Blume. Darf nicht "GRÜN" sein, sonst wird eine
	 *            IllegalArgumentException geworfen.
	 */
	public Blume(String name, int hoehe, int bodenart, int farbe) {
		super(name, hoehe, bodenart);
		if (farbe == Pflanze.GRUEN)
			throw new IllegalArgumentException();
		this.farbe = farbe;
	}

	public int getFarbe() {
		return this.farbe;
	}
	
	public String toString() {
		return "Blume ("+getName()+", "+getHoehe()+", "+bodenartToString(getBodenart())+", "+farbeToString(getFarbe())+")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + farbe;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blume other = (Blume) obj;
		if (farbe != other.farbe)
			return false;
		return true;
	}
}
