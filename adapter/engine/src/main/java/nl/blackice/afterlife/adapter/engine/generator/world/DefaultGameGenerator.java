package nl.blackice.afterlife.adapter.engine.generator.world;

import nl.blackice.afterlife.domain.model.*;
import nl.blackice.afterlife.domain.model.value.*;
import nl.blackice.afterlife.domain.port.output.CreateNewGamePort;
import nl.blackice.common.injection.Injectable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Injectable
public class DefaultGameGenerator implements CreateNewGamePort {
    private static final Random randomizer = new Random();

    @Override
    public Game createNewGame(String playerName, GameSettings settings) {
        World world = new World(new Size(settings.worldWidth(), settings.worldHeight()), createWorldAreas(settings));
        List<Player> players = List.of(createNewPlayerWithName(playerName, getRandomStartingArea(world)));
        world.addAllWorldEntities(players);
        return new Game(world, players);
    }

    private List<WorldArea> createWorldAreas(GameSettings settings) {
        List<WorldArea> areas = new ArrayList<>();
        for (int worldX = 0; worldX < settings.worldWidth(); worldX++) {
            for (int worldY = 0; worldY < settings.worldHeight(); worldY++) {
                Size boundry = new Size(settings.territoryWidth(), settings.territoryHeight());
                areas.add(new Territory(
                        boundry,
                        new WorldLocation(worldX, worldY, 0, WorldLocationType.TERRITORY),
                        new MapLocation(settings.territoryWidth() >> 1, settings.territoryHeight() >> 1),
                        new DefaultMapGenerator(boundry).generateDefaultMap().generate()
                ));
            }
        }
        return areas;
    }

    private WorldArea getRandomStartingArea(World world) {
        return world.getWorldAreas().get(randomizer.nextInt(world.getWorldAreas().size()));
    }

    private Player createNewPlayerWithName(String playerName, WorldArea startingArea) {
        return new Player(playerName, startingArea.getWorldLocation(), startingArea.getEntryLocation());
    }
}
