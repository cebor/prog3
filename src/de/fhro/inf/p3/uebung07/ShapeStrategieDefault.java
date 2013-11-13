package de.fhro.inf.p3.uebung07;

import java.util.List;

/**
 * Created by felix on 11/13/13.
 */
public class ShapeStrategieDefault implements ShapeStrategie {
    @Override
    public void doAction(List<MovingShape> shapes, int maxX, int maxY) {
        for (MovingShape mShape : shapes) {
            mShape.move(maxX, maxY);
        }
    }
}
