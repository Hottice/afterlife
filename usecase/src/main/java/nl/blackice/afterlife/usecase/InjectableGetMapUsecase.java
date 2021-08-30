package nl.blackice.afterlife.usecase;

import nl.blackice.afterlife.domain.port.output.GetGamePort;
import nl.blackice.afterlife.domain.port.usecase.GetMapUsecase;
import nl.blackice.common.injection.Injectable;

@Injectable
public class InjectableGetMapUsecase extends GetMapUsecase {
    public InjectableGetMapUsecase(GetGamePort getWorldPort) {
        super(getWorldPort);
    }
}
