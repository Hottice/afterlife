package nl.blackice.afterlife.domain.port.usecase;

import nl.blackice.afterlife.domain.model.Game;
import nl.blackice.afterlife.domain.model.WorldArea;
import nl.blackice.afterlife.domain.model.exception.AreaNotFoundException;
import nl.blackice.afterlife.domain.model.value.Map;
import nl.blackice.afterlife.domain.model.value.WorldLocation;
import nl.blackice.afterlife.domain.port.output.GetGamePort;

public class GetMapUsecase {
    private final GetGamePort getGamePort;

    public GetMapUsecase(GetGamePort getGamePort) {
        this.getGamePort = getGamePort;
    }

    public Map getMap(WorldLocation worldLocation) throws AreaNotFoundException {
        Game game = getGamePort.getGame();
        WorldArea worldArea = game.getWorld().findWorldArea(worldLocation);
        return worldArea.getMap();
    }
}
