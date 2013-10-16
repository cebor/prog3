package de.fhro.inf.p3.uebung02;

import static de.fhro.inf.p3.uebung02.Plant.colors.RED;

/**
 * Created by felix on 10/10/13.
 *
 * Plant
 */
public abstract class Plant implements Comparable<Plant> {


    public static enum grounds {
        SAND,
        CLAY,
        HUMUS
    }

    public static enum colors {
        RED,
        YELLOW,
        WHITE,
        ORANGE,
        GREEN
    }

    private String name;
    private double height;
    private int kind;


    public Plant(String name, double height, int kind) {
        this.name = name;
        this.height = height;
        this.kind = kind;
    }


    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public int getKind() {
        return kind;
    }


    abstract int getColor();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plant plant = (Plant) o;

        if (Double.compare(plant.height, height) != 0) return false;
        if (kind != plant.kind) return false;
        if (name != null ? !name.equals(plant.name) : plant.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + kind;
        return result;
    }

    @Override
    public int compareTo(Plant plant) {
        if (this == plant)
            return 0;

        if (height > plant.height)
            return 1;
        if (height < plant.height)
            return -1;

        if (height == plant.height)
            return name.compareTo(plant.name);

        return 0;
    }
}
