package nl.blackice.afterlife.domain.model.util;

import nl.blackice.afterlife.domain.model.value.Direction;
import nl.blackice.afterlife.domain.model.value.TerritoryType;

public class MoveUtil {
    public static int getXAdjustmentForDirection(Direction direction) {
        return switch (direction) {
            case NORTH, SOUTH -> 0;
            case EAST -> 1;
            case WEST -> -1;
        };
    }

    public static int getYAdjustmentForDirection(Direction direction) {
        return switch (direction) {
            case EAST, WEST -> 0;
            case NORTH -> 1;
            case SOUTH -> -1;
        };
    }

    public static boolean ableToMoveOnTerritoryType(TerritoryType territoryType) {
        return switch (territoryType) {
            case NONE -> false;
            case WATER -> false;
            default -> true;
        };
    }
}
