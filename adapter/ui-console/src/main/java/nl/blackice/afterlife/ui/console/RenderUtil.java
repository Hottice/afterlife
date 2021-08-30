package nl.blackice.afterlife.ui.console;

import nl.blackice.afterlife.domain.model.value.Map;
import nl.blackice.afterlife.domain.model.value.MapLocationType;
import nl.blackice.afterlife.domain.model.value.WorldMap;

public class RenderUtil {
    public static char getCharacterForType(MapLocationType mapLocationTypeForLocation) {
        return switch(mapLocationTypeForLocation) {
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

