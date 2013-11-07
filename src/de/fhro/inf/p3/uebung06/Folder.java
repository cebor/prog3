package de.fhro.inf.p3.uebung06;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 11/6/13.
 */
public class Folder implements IDirectoryElement {

    private String name;
    private List<IDirectoryElement> list;

    public Folder(String name) {
        this.name = name;
        list = new ArrayList<IDirectoryElement>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer size() {
        Integer size = 0;

        for (IDirectoryElement item : list) {
            size += item.size();
        }

        return size;
    }

    @Override
    public void add(IDirectoryElement x) {
        list.add(x);
    }
}
