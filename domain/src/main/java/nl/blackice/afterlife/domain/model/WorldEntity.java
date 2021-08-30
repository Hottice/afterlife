package nl.blackice.afterlife.domain.model;

import nl.blackice.afterlife.domain.model.value.MapLocation;
import nl.blackice.afterlife.domain.model.value.WorldLocation;

import java.util.UUID;

public abstract class WorldEntity {
    protected final String identifier;
    protected WorldLocation worldLocation;
    protected MapLocation mapLocation;

    public WorldEntity(WorldLocation worldLocation, MapLocation mapLocation) {
        this.identifier = UUID.randomUUID().toString();
        this.worldLocation = worldLocation;
        this.mapLocation = mapLocation;
    }

    public WorldEntity(String identifier, WorldLocation worldLocation, MapLocation mapLocation) {
        this.identifier = identifier;
        this.worldLocation = worldLocation;
        this.mapLocation = mapLocation;
    }

    public WorldLocation getWorldLocation() {
        return worldLocation;
    }

    public MapLocation getMapLocation() {
        return mapLocation;
    }
}
