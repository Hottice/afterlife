package nl.blackice.afterlife.usecase;

import nl.blackice.afterlife.domain.port.output.GetWorldPort;
import nl.blackice.afterlife.domain.port.usecase.EndPlayerTurnUsecase;
import nl.blackice.common.injection.Injectable;

@Injectable
public class InjectableEndPlayerTurnUsecase extends EndPlayerTurnUsecase {
    public InjectableEndPlayerTurnUsecase(GetWorldPort getWorldPort) {
        super(getWorldPort);
    }
}
