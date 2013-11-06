package de.fhro.inf.p3.uebung06;

/**
 * Created by felix on 11/6/13.
 */
public class File implements IDirectoryElement {

    private String name;
    private Integer size;

    public File(String name, Integer size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public void add(IDirectoryElement x) {
        throw new UnsupportedOperationException();
    }
}
