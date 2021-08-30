package nl.blackice.afterlife.domain.model;

import nl.blackice.afterlife.domain.model.value.MapLocation;
import nl.blackice.afterlife.domain.model.value.Size;
import nl.blackice.afterlife.domain.model.value.Map;
import nl.blackice.afterlife.domain.model.value.WorldLocation;

public class Territory extends WorldArea {
    private final Size boundry;

    public Territory(Size boundry, WorldLocation location, MapLocation entryLocation, Map map) {
        super(location, entryLocation, map);
        this.boundry = boundry;
    }

    public Size getBoundry() {
        return boundry;
    }
}
