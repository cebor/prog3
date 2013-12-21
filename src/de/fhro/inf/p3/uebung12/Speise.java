package de.fhro.inf.p3.uebung12;

/**
 * Created by felix on 12/21/13.
 */
public class Speise {
    private String name;
    private int tischId;

    private static final String[] namen = new String[]{"Nudeln mit Tomatensauce", "Sushi", "Pizza Tonno", "Spagetti"};

    public Speise() {
        this.name = namen[((int) (Math.random() * namen.length))];
        this.tischId = (int) (Math.random() * 100);
    }

    public String getName() {
        return name;
    }

    public int getTischId() {
        return tischId;
    }
}
