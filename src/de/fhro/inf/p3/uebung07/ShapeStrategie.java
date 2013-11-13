package de.fhro.inf.p3.uebung07;

import java.util.List;

/**
 * Created by felix on 11/13/13.
 */
public interface ShapeStrategie {
    public void doAction(List<MovingShape> shapes, int maxX, int maxY);
}
