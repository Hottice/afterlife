package nl.blackice.afterlife.usecase;

import nl.blackice.afterlife.domain.port.output.GetGamePort;
import nl.blackice.afterlife.domain.port.usecase.MovePlayerToWorldAreaUsecase;
import nl.blackice.common.injection.Injectable;

@Injectable
public class InjectableMovePlayerToWorldAreaUsecase extends MovePlayerToWorldAreaUsecase {
    public InjectableMovePlayerToWorldAreaUsecase(GetGamePort getGamePort) {
        super(getGamePort);
    }
}
