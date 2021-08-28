package nl.blackice.afterlife.domain.model.value;

public class TerritoryMap {
    private Size boundry;
    private TerritoryType[][] map;

    public TerritoryMap(TerritoryType[][] map) {
        this.map = map;
        this.boundry = new Size(map.length, map[0].length);
    }

    public TerritoryType getLocation(int x, int y) {
        if (x < 0 || x >= boundry.getWidth() ||
                y < 0 || y >= boundry.getHeight()) {
            return TerritoryType.NONE;
        }
        return map[x][y];
    }
}
