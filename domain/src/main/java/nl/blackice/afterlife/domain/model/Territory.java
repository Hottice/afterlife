package nl.blackice.afterlife.domain.model;

import nl.blackice.afterlife.domain.model.value.Size;
import nl.blackice.afterlife.domain.model.value.TerritoryMap;

public class Territory {
    private String name;
    private Size boundry;
    private TerritoryMap map;

    public Territory(String name, Size boundry, TerritoryMap map) {
        this.name = name;
        this.boundry = boundry;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public Size getBoundry() {
        return boundry;
    }

    public TerritoryMap getMap() {
        return map;
    }
}
