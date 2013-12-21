package de.fhro.inf.p3.uebung09;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 11/27/13.
 */
public abstract class Kunde implements IKunde, Serializable {
    private static int count = 0;

    private int id;
    private Adresse adresse;
    private List<Bestellung> bestellungen;

    protected Kunde(Adresse adresse) {
        this.id = count++;
        this.adresse = adresse;
        this.bestellungen = new ArrayList<Bestellung>();
    }

    @Override
    public void addBestellung(Bestellung bestellung) {
        bestellungen.add(bestellung);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public Adresse getAdresse() {
        return adresse;
    }

    @Override
    public List<Bestellung> getBestellungen() {
        return bestellungen;
    }

    @Override
    public List<Bestellung> getBezahlteBestellungen() {
        List<Bestellung> bezahlteBestellungen = new ArrayList<Bestellung>();

        for (Bestellung bestellung : bestellungen) {
            if (bestellung.istBezahlt()) {
                bezahlteBestellungen.add(bestellung);
            }
        }

        return bezahlteBestellungen;
    }

    @Override
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kunde kunde = (Kunde) o;

        if (id != kunde.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "id=" + id +
                ", adresse=" + adresse +
                ", bestellungen=" + bestellungen +
                '}';
    }
}
