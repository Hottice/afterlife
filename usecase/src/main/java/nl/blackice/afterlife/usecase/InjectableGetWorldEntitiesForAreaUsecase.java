package nl.blackice.afterlife.usecase;

import nl.blackice.afterlife.domain.port.output.GetGamePort;
import nl.blackice.afterlife.domain.port.usecase.GetWorldEntitiesForAreaUsecase;
import nl.blackice.common.injection.Injectable;

@Injectable
public class InjectableGetWorldEntitiesForAreaUsecase extends GetWorldEntitiesForAreaUsecase {
    public InjectableGetWorldEntitiesForAreaUsecase(GetGamePort getWorldPort) {
        super(getWorldPort);
    }
}
