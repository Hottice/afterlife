package nl.blackice.afterlife.adapter.engine.generator.world;

import nl.blackice.afterlife.domain.model.value.Size;
import nl.blackice.afterlife.domain.model.value.Map;
import nl.blackice.afterlife.domain.model.value.MapLocationType;

import java.util.Random;

public class DefaultMapGenerator {
    private Random randomGen;
    private Size boundry;
    private MapLocationType[][] map;

    public DefaultMapGenerator(Size boundry) {
        this.randomGen = new Random();
        this.boundry = boundry;
        this.map = new MapLocationType[boundry.width()][boundry.height()];
    }

    public DefaultMapGenerator generateDefaultMap() {
        for (int x = 0; x < boundry.width(); x++) {
            for (int y = 0; y < boundry.height(); y++) {
                map[x][y] = getMapLocationTypeForLocation(x, y);
            }
        }
        return this;
    }

    private MapLocationType getMapLocationTypeForLocation(int x, int y) {
        int randomizedInt = randomGen.nextInt(20);
        if (randomizedInt < 4) {
            return MapLocationType.FOREST;
        }
        if (randomizedInt < 5) {
            return MapLocationType.MOUNTAIN;
        }
        if (randomizedInt < 6) {
            return MapLocationType.WATER;
        }
        return MapLocationType.PLAIN;
    }

    public Map generate() {
        return new Map(boundry, map);
    }
}
