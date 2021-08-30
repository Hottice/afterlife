package nl.blackice.afterlife.domain.model.value;

public record GameSettings(
        int worldWidth,
        int worldHeight,
        int territoryWidth,
        int territoryHeight
) {
}
