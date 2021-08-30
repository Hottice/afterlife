package nl.blackice.afterlife.usecase;

import nl.blackice.afterlife.domain.port.output.GetGamePort;
import nl.blackice.afterlife.domain.port.usecase.MovePlayerOnMapUsecase;
import nl.blackice.common.injection.Injectable;

@Injectable
public class InjectableMovePlayerOnMapUsecase extends MovePlayerOnMapUsecase {
    public InjectableMovePlayerOnMapUsecase(GetGamePort getWorldPort) {
        super(getWorldPort);
    }
}
