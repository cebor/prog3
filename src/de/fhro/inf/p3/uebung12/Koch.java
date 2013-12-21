package de.fhro.inf.p3.uebung12;

/**
 * Created by felix on 12/21/13.
 */
public class Koch extends Thread {
    private static int idCounter = 0;

    private int id;
    private IDurchreiche durchreiche;

    public Koch(IDurchreiche durchreiche) {
        this.durchreiche = durchreiche;
        this.id = idCounter++;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Speise speise = new Speise();
                durchreiche.put(speise);
                sleep((int) (Math.random() * 10000));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
