package nl.blackice.afterlife.domain.port.usecase;

import nl.blackice.afterlife.domain.model.Territory;
import nl.blackice.afterlife.domain.model.World;
import nl.blackice.afterlife.domain.model.exception.TerritoryWithNameDoesNotExistInGameException;
import nl.blackice.afterlife.domain.model.value.TerritoryMap;
import nl.blackice.afterlife.domain.port.output.GetWorldPort;

public class GetTerritoryMapUsecase {
    private final GetWorldPort getWorldPort;

    public GetTerritoryMapUsecase(GetWorldPort getWorldPort) {
        this.getWorldPort = getWorldPort;
    }

    public TerritoryMap getTerritoryMap(String territoryName) throws TerritoryWithNameDoesNotExistInGameException {
        World world = getWorldPort.getWorld();
        Territory territory = world.getTerritoryWithName(territoryName);
        return territory.getMap();
    }
}
