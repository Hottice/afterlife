package nl.blackice.afterlife.domain.port.usecase;

import nl.blackice.afterlife.domain.model.Game;
import nl.blackice.afterlife.domain.model.WorldArea;
import nl.blackice.afterlife.domain.model.exception.AreaNotFoundException;
import nl.blackice.afterlife.domain.model.value.Map;
import nl.blackice.afterlife.domain.model.value.Size;
import nl.blackice.afterlife.domain.model.value.WorldLocation;
import nl.blackice.afterlife.domain.model.value.WorldMap;
import nl.blackice.afterlife.domain.port.output.GetGamePort;

import java.util.List;

public class GetWorldMapUsecase {
    private final GetGamePort getGamePort;

    public GetWorldMapUsecase(GetGamePort getGamePort) {
        this.getGamePort = getGamePort;
    }

    public WorldMap getWorldMap(int layer) throws AreaNotFoundException {
        Game game = getGamePort.getGame();
        Size boundry = game.getWorld().getBoundry();
        WorldArea[][] areas = new WorldArea[boundry.width()][boundry.height()];
        for (WorldArea worldArea : game.getWorld().getWorldAreas()) {
            if (worldArea.getWorldLocation().z() == layer) {
                areas[worldArea.getWorldLocation().x()][worldArea.getWorldLocation().y()] = worldArea;
            }
        }
        return new WorldMap(layer, boundry, areas);
    }
}
