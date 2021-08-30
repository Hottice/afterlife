package nl.blackice.afterlife.domain.model.value;

import nl.blackice.afterlife.domain.model.WorldArea;

public record WorldMap(int layer, Size boundry, WorldArea[][] worldAreas) {
}
