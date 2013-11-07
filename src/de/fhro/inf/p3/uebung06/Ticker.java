package de.fhro.inf.p3.uebung06;

import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;

/**
 * Created by felix on 11/7/13.
 */
public class Ticker extends Observable {
    private Map<String, Double> kurse;

    // Ein neuer Ticker wird erzeugt.
    public Ticker() {
        kurse = new TreeMap<String, Double>();
    }

    // neuer Kurs hinzugefügt oder ein bestehender Kurs aktualisiert
    public void setKurs(String wkn, Double kurs) {
        kurse.put(wkn, kurs);
        setChanged();
        notifyObservers(wkn);
    }

    // Lese einen Kurs aus der Kursliste aus.
    public Double getKurs(String wkn) {
        return kurse.get(wkn);
    }
}
