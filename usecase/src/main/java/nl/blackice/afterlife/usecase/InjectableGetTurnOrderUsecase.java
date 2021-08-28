package nl.blackice.afterlife.usecase;

import nl.blackice.afterlife.domain.port.output.GetWorldPort;
import nl.blackice.afterlife.domain.port.usecase.GetTurnOrderUsecase;
import nl.blackice.common.injection.Injectable;

@Injectable
public class InjectableGetTurnOrderUsecase extends GetTurnOrderUsecase {
    public InjectableGetTurnOrderUsecase(GetWorldPort getWorldPort) {
        super(getWorldPort);
    }
}
