package de.fhro.inf.p3.uebung02;

import java.util.Comparator;

/**
 * Created by felix on 10/16/13.
 *
 */
public class GroundComperator implements Comparator<Plant> {

        public int compare(Plant p1, Plant p2) {
            if(p1.getKind() < p2.getKind())
                return -1;
            if(p1.getKind() > p2.getKind())
                return 1;
            return 0;
        }
}
