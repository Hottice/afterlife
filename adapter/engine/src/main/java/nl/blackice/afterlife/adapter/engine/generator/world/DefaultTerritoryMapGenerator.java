package nl.blackice.afterlife.adapter.engine.generator.world;

import nl.blackice.afterlife.domain.model.value.Size;
import nl.blackice.afterlife.domain.model.value.TerritoryMap;
import nl.blackice.afterlife.domain.model.value.TerritoryType;

import java.util.Random;

public class DefaultTerritoryMapGenerator {
    private Random randomGen;
    private Size territoryBoundry;
    private TerritoryType[][] map;

    public DefaultTerritoryMapGenerator(Size territoryBoundry) {
        this.randomGen = new Random();
        this.territoryBoundry = territoryBoundry;
        this.map = new TerritoryType[territoryBoundry.getWidth()][territoryBoundry.getHeight()];
    }

    public DefaultTerritoryMapGenerator generateDefaultMap() {
        for (int x = 0; x < territoryBoundry.getWidth(); x++) {
            for (int y = 0; y < territoryBoundry.getHeight(); y++) {
                map[x][y] = getTerritoryType(x, y);
            }
        }
        return this;
    }

    private TerritoryType getTerritoryType(int x, int y) {
        if (x == (territoryBoundry.getWidth() >> 1) && y == (territoryBoundry.getHeight() >> 1)) {
            return TerritoryType.VILLAGE;
        }

        int randomizedInt = randomGen.nextInt(20);
        if (randomizedInt < 4) {
            return TerritoryType.FOREST;
        }
        if (randomizedInt < 5) {
            return TerritoryType.MOUNTAIN;
        }
        if (randomizedInt < 6) {
            return TerritoryType.WATER;
        }
        return TerritoryType.PLAIN;
    }

    public TerritoryMap generate() {
        return new TerritoryMap(map);
    }
}
