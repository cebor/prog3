package de.fhro.inf.p3.uebung02;

import java.util.*;

/**
 * Created by felix on 10/10/13.
 *
 * Plant Util
 */
public class PlantUtil {

    /**
     * sort an array of plants by height
     *
     * @param array
     */
    public static void sortByHeight(Plant[] array) {
        Arrays.sort(array);
    }

    /**
     * sort an array of plants by ground
     *
     * @param pflanzen
     */
    public static void sortByGround(List<Plant> pflanzen) {
        Collections.sort(pflanzen, new GroundComperator());
    }

    /**
     * devide flowers by color
     *
     * @param blumen
     * @return
     */
    public static Map<Integer, List<Flower>> devideFlowersByColor(
            Collection<Flower> blumen) {

        Map<Integer, List<Flower>> result = new HashMap<Integer, List<Flower>>();

        for (Flower b : blumen) {
            int color = b.getColor();
            if (result.containsKey(color)) {
                result.get(color).add(b);
            } else {
                List<Flower> farbSet = new ArrayList<Flower>();
                farbSet.add(b);
                result.put(color, farbSet); // autoboxing
            }
        }
        return result;
    }
}
