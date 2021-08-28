package nl.blackice.afterlife.domain.model.value;

import nl.blackice.afterlife.domain.model.Territory;

public class Location {
    Territory territory;
    int x;
    int y;

    public Location(Territory territory, int x, int y) {
        this.territory = territory;
        this.x = x;
        this.y = y;
    }

    public Territory getTerritory() {
        return territory;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
