package nl.blackice.afterlife.domain.port.usecase;

import nl.blackice.afterlife.domain.model.Game;
import nl.blackice.afterlife.domain.model.WorldArea;
import nl.blackice.afterlife.domain.model.WorldEntity;
import nl.blackice.afterlife.domain.model.exception.AreaNotFoundException;
import nl.blackice.afterlife.domain.model.value.WorldLocation;
import nl.blackice.afterlife.domain.port.output.GetGamePort;

import java.util.List;

public class GetWorldEntitiesForAreaUsecase {
    private final GetGamePort getGamePort;

    public GetWorldEntitiesForAreaUsecase(GetGamePort getGamePort) {
        this.getGamePort = getGamePort;
    }

    public List<WorldEntity> getWorldEntitiesForArea(WorldLocation worldLocation) throws AreaNotFoundException {
        Game game = getGamePort.getGame();
        WorldArea worldArea = game.getWorld().findWorldArea(worldLocation);
        return game.getWorld().getWorldEntities().stream()
                .filter(worldEntity -> worldEntity.getWorldLocation().equals(worldArea.getWorldLocation()))
                .toList();
    }
}
