package nl.blackice.afterlife.usecase;

import nl.blackice.afterlife.domain.port.output.GetGamePort;
import nl.blackice.afterlife.domain.port.usecase.GetWorldMapUsecase;
import nl.blackice.common.injection.Injectable;

@Injectable
public class InjectableGetWorldMapUsecase extends GetWorldMapUsecase {
    public InjectableGetWorldMapUsecase(GetGamePort getGamePort) {
        super(getGamePort);
    }
}
