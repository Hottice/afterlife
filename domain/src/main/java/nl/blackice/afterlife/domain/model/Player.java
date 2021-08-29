package nl.blackice.afterlife.domain.model;

import nl.blackice.afterlife.domain.model.exception.NoActionPointsException;
import nl.blackice.afterlife.domain.model.exception.UnableToMoveException;
import nl.blackice.afterlife.domain.model.util.MoveUtil;
import nl.blackice.afterlife.domain.model.value.Direction;
import nl.blackice.afterlife.domain.model.value.Location;
import nl.blackice.afterlife.domain.model.value.TerritoryMap;
import nl.blackice.afterlife.domain.model.value.TerritoryType;

public class Player {
    private final String name;
    private Territory territory;
    private Location location;
    private int actionPoints;

    public Player(String name, Territory territory, Location location) {
        this.name = name;
        this.territory = territory;
        this.location = location;
        this.actionPoints = 3;
    }

    public void move(Direction direction) throws UnableToMoveException, NoActionPointsException {
        TerritoryMap map = location.getTerritory().getMap();
        int moveToX = location.getX() + MoveUtil.getXAdjustmentForDirection(direction);
        int moveToY = location.getY() + MoveUtil.getYAdjustmentForDirection(direction);
        TerritoryType territoryType = map.getTerritoryTypeForLocation(moveToX, moveToY);
        if (!MoveUtil.ableToMoveOnTerritoryType(territoryType)) {
            throw new UnableToMoveException(name, direction);
        }
        if (actionPoints < 1) {
            throw new NoActionPointsException(name, 1, actionPoints);
        }
        actionPoints -= 1;
        location = new Location(location.getTerritory(), moveToX, moveToY);
    }

    public String getName() {
        return name;
    }

    public Territory getTerritory() {
        return territory;
    }

    public Location getLocation() {
        return location;
    }

    public void resetActionPoints() {
        actionPoints = 3;
    }
}
