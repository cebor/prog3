package de.fhro.inf.p3.uebung02;

import java.util.*;

/**
 * @author brm
 * @version 2010-10-07
 */
public class BodenComparator implements Comparator<Pflanze> {
	public int compare(Pflanze p1, Pflanze p2) {
		if(p1.getBodenart() < p2.getBodenart())
			return -1;
		if(p1.getBodenart() > p2.getBodenart())
			return 1;
		return 0;
	}
}
