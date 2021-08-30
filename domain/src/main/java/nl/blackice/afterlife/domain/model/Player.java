package nl.blackice.afterlife.domain.model;

import nl.blackice.afterlife.domain.model.exception.NoActionPointsException;
import nl.blackice.afterlife.domain.model.exception.UnableToMoveException;
import nl.blackice.afterlife.domain.model.util.MoveUtil;
import nl.blackice.afterlife.domain.model.value.*;

import java.util.ArrayList;
import java.util.List;

public class Player extends WorldEntity {
    private final String name;
    private final List<WorldLocation> ownedLocations;
    private final PlayerStats stats;
    private int actionPoints;

    public Player(String name, WorldLocation worldLocation, MapLocation mapLocation) {
        super(name, worldLocation, mapLocation);
        this.name = name;
        this.ownedLocations = new ArrayList<>();
        this.actionPoints = 3;
        this.stats = new PlayerStats(1);
    }

    public void move(Direction direction, Map map) throws UnableToMoveException, NoActionPointsException {
        int moveToX = mapLocation.x() + MoveUtil.getXAdjustmentForDirection(direction);
        int moveToY = mapLocation.y() + MoveUtil.getYAdjustmentForDirection(direction);
        MapLocationType mapLocationType = map.getTerritoryTypeForLocation(moveToX, moveToY);
        if (!MoveUtil.ableToMoveOnTerritoryType(mapLocationType)) {
            throw new UnableToMoveException(name, direction);
        }
        if (actionPoints < 1) {
            throw new NoActionPointsException(name, 1, actionPoints);
        }
        actionPoints -= 1;
        mapLocation = new MapLocation(moveToX, moveToY);
    }

    public void moveTo(WorldLocation worldLocation, MapLocation mapLocation) {
        this.worldLocation = worldLocation;
        this.mapLocation = mapLocation;
    }

    public void addOwnedLocation(WorldLocation worldLocation) {
        this.ownedLocations.add(worldLocation);
    }

    public void resetActionPoints() {
        actionPoints = 3;
    }

    public String getName() {
        return name;
    }

    public PlayerStats getStats() {
        return stats;
    }
}
