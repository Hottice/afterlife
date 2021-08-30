package nl.blackice.afterlife.domain.model.value;

public record Map(Size boundry, MapLocationType[][] map) {

    public MapLocationType getTerritoryTypeForLocation(int x, int y) {
        if (x < 0 || x >= boundry.width() ||
                y < 0 || y >= boundry.height()) {
            return MapLocationType.NONE;
        }
        return map[x][y];
    }
}
