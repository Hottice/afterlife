package nl.blackice.afterlife.adapter.engine.generator.world;

import nl.blackice.afterlife.domain.model.Player;
import nl.blackice.afterlife.domain.model.Territory;
import nl.blackice.afterlife.domain.model.World;
import nl.blackice.afterlife.domain.model.value.Location;
import nl.blackice.afterlife.domain.model.value.Size;
import nl.blackice.afterlife.domain.port.output.CreateNewWorldPort;
import nl.blackice.common.injection.Injectable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Injectable
public class DefaultWorldGenerator implements CreateNewWorldPort {
    @Override
    public World createNewWorld(CreationOptions options) {
        Player newPlayer = createPlayer(options.playerName(), options.territoryBoundry());

        Map<String, Player> players = new HashMap<>();
        players.put(newPlayer.getName(), newPlayer);

        return new World(players, List.of(newPlayer), newPlayer);
    }

    private Player createPlayer(String playerName, Size boundry) {
        Territory territory = createTerritory(playerName, boundry);
        return new Player(playerName, territory, createLocation(boundry, territory));
    }

    private Territory createTerritory(String playerName, Size boundry) {
        return new Territory(
                String.format("%s territory", playerName),
                boundry,
                new DefaultTerritoryMapGenerator(boundry)
                        .generateDefaultMap()
                        .generate());
    }


    private Location createLocation(Size boundry, Territory territory) {
        return new Location(territory, boundry.getWidth() >> 1, boundry.getHeight() >> 1);
    }
}
