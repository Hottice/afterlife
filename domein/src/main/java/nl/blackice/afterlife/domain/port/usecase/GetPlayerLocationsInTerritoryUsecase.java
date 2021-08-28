package nl.blackice.afterlife.domain.port.usecase;

import nl.blackice.afterlife.domain.model.Player;
import nl.blackice.afterlife.domain.model.World;
import nl.blackice.afterlife.domain.model.value.Location;
import nl.blackice.afterlife.domain.port.output.GetWorldPort;

import java.util.HashMap;
import java.util.Map;

public class GetPlayerLocationsInTerritoryUsecase {
    private final GetWorldPort getWorldPort;

    public GetPlayerLocationsInTerritoryUsecase(GetWorldPort getWorldPort) {
        this.getWorldPort = getWorldPort;
    }

    public Map<String, Location> getPlayerLocation(String territoryName) {
        World world = getWorldPort.getWorld();
        Map<String, Location> playersInTerritory = new HashMap<>();
        for (Player player : world.getPlayers()) {
            if (player.getLocation().getTerritory().getName().equals(territoryName)) {
                playersInTerritory.put(player.getName(), player.getLocation());
            }
        }
        return playersInTerritory;
    }
}
