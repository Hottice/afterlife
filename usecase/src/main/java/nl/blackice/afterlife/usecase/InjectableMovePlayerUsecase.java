package nl.blackice.afterlife.usecase;

import nl.blackice.afterlife.domain.port.output.GetWorldPort;
import nl.blackice.afterlife.domain.port.usecase.MovePlayerUsecase;
import nl.blackice.common.injection.Injectable;

@Injectable
public class InjectableMovePlayerUsecase extends MovePlayerUsecase {
    public InjectableMovePlayerUsecase(GetWorldPort getWorldPort) {
        super(getWorldPort);
    }
}
