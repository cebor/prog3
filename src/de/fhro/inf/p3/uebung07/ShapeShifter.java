package de.fhro.inf.p3.uebung07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Verwaltet alle Shapes and schiebt sie auf dem Bildschirm herum. Der
 * Konstruktor erzeugt einen "Timer", der in regelmässigen Abständen die Methode
 * actionPerformed aufruft. Diese macht die eigentliche Arbeit.
 *
 * @author brm
 */
public class ShapeShifter implements ActionListener {
    private JComponent component;
    private JLabel statusLabel;
    private List<MovingShape> shapes;
    private Timer timer;

    /**
     * Erzeugt einen neuen Shape Shifter, der Shapes aus dem Bildschirm
     * herumschieben kann. Startet einen (Swing!) Timer, der die Shapes alle
     * shiftInterval Millisekunden um eine Position verschiebt.
     *
     * @param shiftInterval Zeit in Millisekungen zwischen je zwei Shape-Verschiebungen.
     */
    public ShapeShifter(int shiftInterval) {
        this.component = null;
        this.shapes = new ArrayList<MovingShape>();
        timer = new Timer(shiftInterval, this);
        timer.start();
    }

    public void setComponents(JComponent component, JLabel statusLabel) {
        this.component = component;
        this.statusLabel = statusLabel;
    }

    public boolean add(MovingShape shape) {
        return shapes.add(shape);
    }

    public void clear() {
        shapes.clear();
    }

    /**
     * Zeichnet alle Shapes und den Informationsteil neu. Wird indirekt (von
     * Swing) aufgerufen, dadurch dass actionPerformed ein repaint() ausführt.
     */
    public void paint(Graphics graphics) {
        for (MovingShape mShape : shapes) {
            mShape.getShape().paint(graphics,
                    new Point(mShape.getX(), mShape.getY()));
        }
        statusLabel.setText(
                "  shapes:" + shapes.size() +
                        "  fws:" + KugelFactory.getInstance().getCount()
        );
    }

    /**
     * Wird vom Timer automatisch immer wieder aufgerufen. Verschiebt erst alle
     * Objekte an ihre neuen Positionen, und zeichnet dann den Bildschirm neu
     * (über die repaint Methode, die indirekt dann paint aufruft.
     */
    public void actionPerformed(ActionEvent e) {
        for (MovingShape mShape : shapes) {
            mShape.move(component.getWidth(), component.getHeight());
        }
        component.repaint();
    }
}
