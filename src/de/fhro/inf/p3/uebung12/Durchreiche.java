package de.fhro.inf.p3.uebung12;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 12/21/13.
 */
public class Durchreiche implements IDurchreiche {

    private final int CAP;
    List<Speise> speisen;

    public Durchreiche(int cap) {
        this.CAP = cap;
        this.speisen = new ArrayList<Speise>();
    }

    @Override
    public synchronized Speise get() {
        Speise speise;
        try {
            while (speisen.size() == 0) {
                wait();
            }
            speise = speisen.remove(0);
            System.out.println(speise.getName() + " für Tisch: " + speise.getTischId() +
                    " aus Durchreiche entfernt! Anzahl: " + speisen.size());
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        return speise;
    }

    @Override
    public synchronized void put(Speise speise) {
        try {
            while (speisen.size() >= CAP) {
                wait();
            }
            speisen.add(speise);
            System.out.println(speise.getName() + " für Tisch: " + speise.getTischId() +
                    " in Durchreiche gestellt! Anzahl: " + speisen.size());
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
