package de.fhro.inf.p3.uebung09;

/**
 * Created by felix on 11/27/13.
 */
public class Privatkunde extends Kunde {
    private String vorname;
    private String nachname;
    private Datum geburtsdatum;

    public Privatkunde(String vorname, String nachname, Datum geburtsdatum, Adresse adresse) {
        super(adresse);
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Datum getGeburtsdatum() {
        return geburtsdatum;
    }

    @Override
    public String getName() {
        return vorname + " " + nachname;
    }
}
