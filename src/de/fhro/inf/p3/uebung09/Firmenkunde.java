package de.fhro.inf.p3.uebung09;

/**
 * Created by felix on 11/27/13.
 */
public class Firmenkunde extends Kunde {
    String firmenname;
    String gesellschaftsform;

    protected Firmenkunde(String firmenname, String gesellschaftsform, Adresse adresse) {
        super(adresse);
        this.firmenname = firmenname;
        this.gesellschaftsform = gesellschaftsform;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }

    public String getGesellschaftsform() {
        return gesellschaftsform;
    }

    public void setGesellschaftsform(String gesellschaftsform) {
        this.gesellschaftsform = gesellschaftsform;
    }

    @Override
    public String getName() {
        return null;
    }
}
