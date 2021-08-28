package nl.blackice.afterlife.usecase;

import nl.blackice.afterlife.domain.port.output.GetWorldPort;
import nl.blackice.afterlife.domain.port.usecase.GetPlayerLocationsInTerritoryUsecase;
import nl.blackice.common.injection.Injectable;

@Injectable
public class InjectableGetPlayerLocationsInTerritoryUsecase extends GetPlayerLocationsInTerritoryUsecase {
    public InjectableGetPlayerLocationsInTerritoryUsecase(GetWorldPort getWorldPort) {
        super(getWorldPort);
    }
}
