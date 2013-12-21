/*
 * User: sid
 * Date: May 26, 2002
 * Time: 11:53:05 AM
 */
package de.fhro.inf.p3.uebung09;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * <b><i>Klasse zum einfachen Umgang mit Datumsangaben.</i></b><br />
 * Instanzen dieser Klasse sind unveränderbar.<br />
 * Die Klasse ist spezialisiert auf innerdeutsche Datumsangaben (bzgl. Feiertage
 * und Zeitzone) und bietet diverse Funktionen zur Datumsarithmetik.<br />
 * <br />
 * <p/>
 * <b>Datumsarithmetik ist keine triviale Aufgabe. Es müssen viele Bedingungen
 * beachtet werden:</b>
 * <ul>
 * <li>Eine Minute hat nicht immer 60 Sekunden (z.B. wenn Schaltsekunden
 * eingefügt werden, was bereits mehr als 20 mal seit 1972 passierte).</li>
 * <li>Ein Tag hat nicht immer 24 Stunden (z.B. bei
 * Sommer-/Winterzeitumstellung).</li>
 * <li>Eine Woche hat nicht immer 7 Tage (z.B. die erste Woche im Jahr).</li>
 * <li>Ein Jahr hat nicht immer 365 Tage (z.B. in Schaltjahren und bei
 * Kalenderanpassungen).</li>
 * <li>Die Berechnung, ob ein Jahr ein Schaltjahr ist, ist nicht immer
 * fehlerfrei (alle 4 Jahre, außer alle 100, wenn nicht durch 400 teilbar).</li>
 * <li>Es wurden mehrmals mehrere Tage ausgelassen, um den Kalender an das
 * tatsächliche Sonnenjahr anzupassen (z.B. folgte auf Donnerstag 4. Oktober
 * 1582 als nächster Tag Freitag 15. Oktober 1582).</li>
 * <li>Es gibt nicht das Jahr 0. Nach 1 B.C. (vor Christi) folgte 1 A.D. (nach
 * Christi).</li>
 * <li>Die Zahl der Tage, ab der diese Tage als erste Woche im Jahr gelten, ist
 * unterschiedlich definiert.</li>
 * <li>Der Wochenanfang ist manchmal mit Sonntag und manchmal mit Montag
 * definiert.</li>
 * <li>Es gibt unterschiedliche Behandlungen von zweistelligen Jahreszahlen.
 * Sie können als Jahreszahlen im ersten Jahrhundert A.D. gemeint sein oder es
 * muss 1900 oder bei kleinen Werten vielleicht auch 2000 dazu addiert werden.</li>
 * <li>Die Angabe 01/02/03 kann in Deutschland 2003-02-01, in USA 2003-01-02
 * und in asiatischen Staaten 2001-02-03 bedeuten.</li>
 * <li>Die Uhrzeit kann bis 12 AM/PM oder bis 24 h zählen.</li>
 * <li>Zeitzonen müssen berücksichtigt werden. Die Bestimmung der Zeitzone
 * eines Ortes ist nicht einfach.</li>
 * <li>Es gibt unterschiedliche und sich ändernde lokale Bestimmungen und
 * Anfangs-/Endzeiten zur Sommer-/Winterzeit.</li>
 * <li>In Europa beginnt die Sommerzeit seit 1980 am letzten Sonntag im März,
 * endete bis 1995 am letzten Sonntag im September und endet seit 1996 am
 * letzten Sonntag im Oktober.</li>
 * <li>Der Unterschied von Sommer- zur Winterzeit beträgt nicht immer eine
 * Stunde. Zum Beispiel galt 1947 in Deutschland die Hochsommerzeit (MEHSZ) mit
 * zwei Stunden Unterschied.</li>
 * <li>Es gibt verschiedene Kalendersysteme (z.B. 1-Jan-2000 (Gregorian) =
 * 23-Tevet-576 (Hebrew) = 24-Ramadan-1420 (Islamic)).</li>
 * <li>Der bei Astronomen beliebte 'Julian Day calendar' (Zyklen von 7980
 * astronomischen Jahren beginnend ab 1. Jan. 4713 B.C.) ist nicht das Gleiche
 * wie der von Julius Caesar eingeführte und bei einigen Orthodoxen heute noch
 * benutzte 'Julian Calendar' (in Europa von 1. Jan. 45 B.C. bis 4. Okt. 1582
 * A.D.).</li>
 * <li>Die Länder, die sich auf den (von Papst Gregory XIII eingeführten)
 * gregorianischen Kalender umgestellt haben, haben dies zu sehr verschiedenen
 * Zeiten vollzogen, wodurch historische Berechungen erschwert werden (viele
 * europäische Länder 1582, aber z.B. China erst 1949 und andere Länder gar
 * nicht).</li>
 * <li>Es gibt Beschränkungen im Wertebereich der
 * Programmiersprachen-Funktionen.</li>
 * Z.B. in Java akzeptiert Date 290 Millionen Jahre B.C. (vor Christi) bis 290
 * Millionen Jahre A.D. (nach Christi), aber GregorianCalendar akzeptierte vor
 * JDK 1.2 kein Datum früher als 4713 B.C.</li>
 * Noch gravierender: 2038-01-19 sind 2^31 Sekunden seit 1970-01-01 vergangen
 * und damit endet der Wertebereich des unter Unix und Windows bei
 * 32-Bit-Programmierung in C üblichen time_t.</li>
 * </ul>
 */
public class Datum implements Comparable, Serializable {

    static final long serialVersionUID = 0;

    private static final int NBR_OF_FORMATS = 3;
    private static final long MILLISEC_PER_DAY = 1000 * 60 * 60 * 24;

    private static Set feiertage = new HashSet();

    private static final SimpleDateFormat[] formatters =
            new SimpleDateFormat[NBR_OF_FORMATS];

    static {
        formatters[0] = new SimpleDateFormat("dd.MM.yyyy");
        formatters[1] = new SimpleDateFormat("dd.MMM yyyy");
        formatters[2] = new SimpleDateFormat("yyyy-MM-dd");

        // dies ist ein Hack und sollte durch eine
        // richtige Loesung ersetzt werden
        feiertage.add(new Datum(2002, 1, 1));       // Neujahr
        feiertage.add(new Datum(2002, 1, 6));       // Drei König
        feiertage.add(new Datum(2002, 3, 29));      // Karfreitag
        feiertage.add(new Datum(2002, 4, 1));       // Ostermontag
        feiertage.add(new Datum(2002, 5, 1));       // Tag der Arbeit
        feiertage.add(new Datum(2002, 5, 9));       // Himmelfahrt
        feiertage.add(new Datum(2002, 5, 20));      // Pfingstmontag
        feiertage.add(new Datum(2002, 5, 30));      // Fronleichnam
        feiertage.add(new Datum(2002, 8, 15));      // Mariä Himmelfahrt
        feiertage.add(new Datum(2002, 10, 3));      // Tag der dt. Einheit
        feiertage.add(new Datum(2002, 11, 1));      // Allerheiligen
        feiertage.add(new Datum(2002, 12, 25));     // 1. Weihnachtstag
        feiertage.add(new Datum(2002, 12, 26));     // 2. Weihnachtstag
    }

    protected Calendar cal;           // das aktuelle Datum als Calendar

    /**
     * initialisiert mit heute - Achtung, Performance!!
     */
    protected Datum() {
        Calendar today = Calendar.getInstance();
        cal = new GregorianCalendar(
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH)
        );
    }


    public static Datum today() {
        return new Datum();
    }

    /**
     * initialisiert mit jahr, monat, tag
     *
     * @param jahr  (vierstellig)
     * @param monat (von 1 bis 12)
     * @param tag   (von 1 bis 31 abhaengig vom Monat)
     */
    public Datum(int jahr, int monat, int tag) {
        cal = new GregorianCalendar(jahr, monat - 1, tag);
    }

    /**
     * @param s              enthaelt das Datum in der Darstellung rep
     * @param representation die uebergebene Darstellung (= 0, 1, 2)
     */
    public Datum(String s, int representation) throws ParseException {
        Date date = formatters[representation].parse(s);
        cal = new GregorianCalendar();
        cal.setTime(date);
    }

    /**
     * @param s              falls aus s kein Datum erzeugt werden kann, dann wird null zurückgegeben
     * @param representation die uebergebene Darstellung (= 0, 1, 2)
     * @return Datum
     */
    public static Datum make(String s, int representation) {
        if (s == null)
            return null;
        try {
            return new Datum(s, representation);
        } catch (ParseException e) {
            return null;
        }
    }

    private Datum(Calendar cal) {
        this.cal = cal;
    }


    /**
     * @param representation gewuenschte Repraesentation (0, 1 oder 2)
     * @return this in der gewuenschten String-Darstellung
     */
    public String toString(int representation) {
        return formatters[representation].format(cal.getTime());
    }

    public String toString() {
        return toString(0);
    }


    /**
     * @return Wochentag (1 = Mo, 2 = Di, .. , 7 = So)
     */
    public int wochentag() {
        // in Calendar ist 1 = SO, 2 = MO, ..., 7 = SA)
        int result = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return 0 == result ? 7 : result;
    }

    /**
     * @return Tag im Monat (zwischen 1 und 31)
     */
    public int tag() {
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @return Monat (zwischen 1 und 12)
     */
    public int monat() {
        // in Calendar ist Jan = 0, Feb = 1, ...
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * @return Jahr (vierstellig)
     */
    public int jahr() {
        return cal.get(Calendar.YEAR);
    }

    public boolean istFeiertag() {
        return feiertage.contains(this);
    }

    public boolean istArbeitstag() {
        return wochentag() < 6 && !istFeiertag();
    }

    public boolean istUltimo() {
        int tmp = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return tag() == tmp;
    }

    public Datum naechsterTag() {
        return add(1);
    }

    public Datum naechsterArbeitstag() {
        Datum result = naechsterTag();
        while (!result.istArbeitstag())
            result = result.naechsterTag();
        return result;
    }

    public Datum naechsterFreieTag() {
        Datum result = naechsterTag();
        while (result.istArbeitstag())
            result = result.naechsterTag();
        return result;
    }

    public Datum naechsterUltimo() {
        Datum result = naechsterTag();
        result.cal.set(Calendar.DAY_OF_MONTH,
                result.cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return result;
    }

    public Datum add(int tage) {
        Calendar tmp = (Calendar) cal.clone();
        tmp.add(Calendar.DAY_OF_YEAR, tage);
        return new Datum(tmp);
    }

    public Datum subtract(int tage) {
        return add(-tage);
    }

    public int diff(Datum d) {
        /*
         * Differenz der gegen die UTC (Universal Time Coordonné) normalisierten
		 * Zeitangaben in Millisekunden seit 1.1.1970 Die UTC ist neutral zu
		 * Sommerzeit / Winterzeit und sonstigen Datumsanomalien (siehe oben).
		 * Die Schaltsekunden der UTC beeinflussen die Berechnung nicht, da sie
		 * nur den Nachkommawert des Ergebnisses beeinflussen. (Annahme: die
		 * Anzahl der Schaltsekunden zwischen den beiden Zeitangaben ist kleiner
		 * als die Anzahl der Sekunden eines Tages)
		 */
        long startL = d.cal.getTimeInMillis()
                + d.cal.getTimeZone().getOffset(d.cal.getTimeInMillis());
        long endL = cal.getTimeInMillis()
                + cal.getTimeZone().getOffset(cal.getTimeInMillis());
        return (int) ((endL - startL) / MILLISEC_PER_DAY);
    }

    public boolean equals(Object x) {
        // equals auf die equals-Methode von Calendar zu stützen kann Probleme bereiten
        // da die Klasse mehr Attribute zum Vergleich heranzieht als gewollt, z.B. Zeitzone
        if (this == x)
            return true;
        if (x == null)
            return false;
        if (getClass() != x.getClass())
            return false;
        Datum d = (Datum) x;
        return this.diff(d) == 0;
    }

    public int compareTo(Object x) {
        Datum d = (Datum) x;
        return this.diff(d);
    }

    public int hashCode() {
        // cal.hashCode() nicht geeignet,
        // da es Widersprüche zur equals-Implementierung geebn kann
        // DAY_OF_MONTH gibt eine relativ gute Streuung
        return cal.get(Calendar.DAY_OF_MONTH);
    }
}
