package de.fhro.inf.p3.uebung09;

/**
 * Created by felix on 11/27/13.
 */
public class Adresse {
    private String strasse;
    private String plz;
    private String ort;
    private String land;

    public Adresse(String strasse, String plz, String ort, String land) {
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
        this.land = land;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adresse adresse = (Adresse) o;

        if (!land.equals(adresse.land)) return false;
        if (!ort.equals(adresse.ort)) return false;
        if (!plz.equals(adresse.plz)) return false;
        if (!strasse.equals(adresse.strasse)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = strasse.hashCode();
        result = 31 * result + plz.hashCode();
        result = 31 * result + ort.hashCode();
        result = 31 * result + land.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "strasse='" + strasse + '\'' +
                ", plz='" + plz + '\'' +
                ", ort='" + ort + '\'' +
                ", land='" + land + '\'' +
                '}';
    }
}
