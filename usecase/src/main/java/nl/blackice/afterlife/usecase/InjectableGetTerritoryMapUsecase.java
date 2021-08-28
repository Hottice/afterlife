package nl.blackice.afterlife.usecase;

import nl.blackice.afterlife.domain.port.output.GetWorldPort;
import nl.blackice.afterlife.domain.port.usecase.GetTerritoryMapUsecase;
import nl.blackice.common.injection.Injectable;

@Injectable
public class InjectableGetTerritoryMapUsecase extends GetTerritoryMapUsecase {
    public InjectableGetTerritoryMapUsecase(GetWorldPort getWorldPort) {
        super(getWorldPort);
    }
}
