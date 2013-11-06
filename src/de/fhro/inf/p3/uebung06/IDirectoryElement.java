package de.fhro.inf.p3.uebung06;

/**
 * Created by felix on 11/6/13.
 */
public interface IDirectoryElement {
    /**
     * Liefert die Groesse eines IDirectoryElements
     * bei File die Dateigroesse in KB
     * bei Folder die Summe der Groessen der Element im Folder
     */
    public Integer size();
    /**
     * Fügt ein File oder ein Folder in einen Folder ein
     */
    public void add(IDirectoryElement x);
}
