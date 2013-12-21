package de.fhro.inf.p3.uebung12;

/**
 * Created by felix on 12/21/13.
 */
public class Kellner extends Thread {
    private static int idCounter = 0;

    private int id;
    private IDurchreiche durchreiche;

    public Kellner(IDurchreiche durchreiche) {
        this.durchreiche = durchreiche;
        this.id = idCounter++;
    }

    @Override
    public void run() {
        try {
            while (true) {
                durchreiche.get();
                sleep((int) (Math.random() * 5000));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
