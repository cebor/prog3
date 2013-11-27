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

    public Kunde(Adresse adresse) {
        this.id = count++;
        this.adresse = adresse;
        this.bestellungen = new ArrayList<Bestellung>();
    }
}
