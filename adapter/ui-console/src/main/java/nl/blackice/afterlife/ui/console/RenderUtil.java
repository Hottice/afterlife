package nl.blackice.afterlife.ui.console;

import nl.blackice.afterlife.domain.model.value.TerritoryType;

public class RenderUtil {
    public static char getCharacterForType(TerritoryType territoryTypeForLocation) {
        return switch(territoryTypeForLocation) {
            case NONE -> ' ';
            case FOREST -> '%';
            case MOUNTAIN -> '^';
            case WATER -> '~';
            case ACRE -> '=';
            case CASTLE -> 'C';
            case VILLAGE -> 'V';
            case MINE -> 'M';
            case PLAIN -> '_';
        };
    }
}

