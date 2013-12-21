package de.fhro.inf.p3.uebung12;

/**
 * Created by felix on 12/21/13.
 */
public class Restaurant {

    public static final int ANZAHL_KOECHE = 10;
    public static final int ANZAHL_KELLNER = 4;
    public static final int KAPAZITAET_DURCHREICHE = 15;

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        IDurchreiche durchreiche = new Durchreiche(KAPAZITAET_DURCHREICHE);

        System.out.println("Starte Restaurant ------------------------");
        System.out.println("Köche: " + ANZAHL_KOECHE);
        System.out.println("Kellner: " + ANZAHL_KELLNER);
        System.out.println("Kapazität Durchreiche: " + KAPAZITAET_DURCHREICHE);

        for (int i = 0; i < ANZAHL_KOECHE; i++) {
            (new Koch(durchreiche)).start();
        }

        for (int j = 0; j < ANZAHL_KELLNER; j++) {
            (new Kellner(durchreiche)).start();
        }
    }
}
