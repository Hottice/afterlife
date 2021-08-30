package nl.blackice.afterlife.domain.model;

import nl.blackice.afterlife.domain.model.value.Map;
import nl.blackice.afterlife.domain.model.value.MapLocation;
import nl.blackice.afterlife.domain.model.value.WorldLocation;

import java.util.UUID;

public abstract class WorldArea {
    protected final String identifier;
    protected WorldLocation worldLocation;
    protected MapLocation entryLocation;
    protected Map map;

    public WorldArea(WorldLocation worldLocation, MapLocation entryLocation, Map map) {
        this.identifier = UUID.randomUUID().toString();
        this.worldLocation = worldLocation;
        this.entryLocation = entryLocation;
        this.map = map;
    }

    public WorldArea(String identifier, WorldLocation worldLocation, MapLocation entryLocation, Map map) {
        this.identifier = identifier;
        this.worldLocation = worldLocation;
        this.entryLocation = entryLocation;
        this.map = map;
    }

    public String getIdentifier() {
        return identifier;
    }

    public WorldLocation getWorldLocation() {
        return worldLocation;
    }

    public MapLocation getEntryLocation() {
        return entryLocation;
    }

    public Map getMap() {
        return map;
    }
}
