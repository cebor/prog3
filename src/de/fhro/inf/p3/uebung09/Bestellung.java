package de.fhro.inf.p3.uebung09;

import de.fhro.inf.p3.dt.Datum;

/**
 * Created by felix on 11/27/13.
 */
public class Bestellung {
    private static int count = 0;

    private int id;
    private Datum datumBestellung;
    private Datum datumLieferung = null;
    private Datum datumZahlung = null;
    private Datum datumStorno = null;
    private int artikel;
    private int anzahl;

    public Bestellung(Datum datumBestellung, int artikel, int anzahl) {
        this.id = count++;
        this.datumBestellung = datumBestellung;
        this.artikel = artikel;
        this.anzahl = anzahl;
    }

    public void lieferung(Datum datumLieferung) {
        this.datumLieferung = datumLieferung;
    }

    public void zahlung(Datum datumZahlung) {
        this.datumZahlung = datumZahlung;
    }

    public void storno(Datum datumStorno) {
        this.datumStorno = datumStorno;
    }

    public boolean istGeliefert() {
        return this.datumLieferung != null;
    }

    public boolean istBezahlt() {
        return this.datumZahlung != null;
    }

    public boolean istStorniert() {
        return this.datumStorno != null;
    }

    public int getId() {
        return id;
    }

    public Datum getDatumBestellung() {
        return datumBestellung;
    }

    public Datum getDatumLieferung() {
        return datumLieferung;
    }

    public Datum getDatumZahlung() {
        return datumZahlung;
    }

    public Datum getDatumStorno() {
        return datumStorno;
    }

    public int getArtikel() {
        return artikel;
    }

    public int getAnzahl() {
        return anzahl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bestellung that = (Bestellung) o;

        if (anzahl != that.anzahl) return false;
        if (artikel != that.artikel) return false;
        if (id != that.id) return false;
        if (!datumBestellung.equals(that.datumBestellung)) return false;
        if (datumLieferung != null ? !datumLieferung.equals(that.datumLieferung) : that.datumLieferung != null)
            return false;
        if (datumStorno != null ? !datumStorno.equals(that.datumStorno) : that.datumStorno != null) return false;
        if (datumZahlung != null ? !datumZahlung.equals(that.datumZahlung) : that.datumZahlung != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + datumBestellung.hashCode();
        result = 31 * result + (datumLieferung != null ? datumLieferung.hashCode() : 0);
        result = 31 * result + (datumZahlung != null ? datumZahlung.hashCode() : 0);
        result = 31 * result + (datumStorno != null ? datumStorno.hashCode() : 0);
        result = 31 * result + artikel;
        result = 31 * result + anzahl;
        return result;
    }

    @Override
    public String toString() {
        return "Bestellung{" +
                "id=" + id +
                ", datumBestellung=" + datumBestellung +
                ", datumLieferung=" + datumLieferung +
                ", datumZahlung=" + datumZahlung +
                ", datumStorno=" + datumStorno +
                ", artikel=" + artikel +
                ", anzahl=" + anzahl +
                '}';
    }
}
