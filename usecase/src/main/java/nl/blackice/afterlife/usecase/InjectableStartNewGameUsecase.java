package nl.blackice.afterlife.usecase;

import nl.blackice.afterlife.domain.port.output.CreateNewWorldPort;
import nl.blackice.afterlife.domain.port.output.SetWorldPort;
import nl.blackice.afterlife.domain.port.usecase.StartNewGameUsecase;
import nl.blackice.common.injection.Injectable;

@Injectable
public class InjectableStartNewGameUsecase extends StartNewGameUsecase {
    public InjectableStartNewGameUsecase(CreateNewWorldPort createNewWorldPort, SetWorldPort setWorldPort) {
        super(createNewWorldPort, setWorldPort);
    }
}
