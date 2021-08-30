package nl.blackice.afterlife.usecase;

import nl.blackice.afterlife.domain.port.output.CreateNewGamePort;
import nl.blackice.afterlife.domain.port.output.SetGamePort;
import nl.blackice.afterlife.domain.port.output.TakeTurnPort;
import nl.blackice.afterlife.domain.port.usecase.StartNewGameUsecase;
import nl.blackice.common.injection.Injectable;

@Injectable
public class InjectableStartNewGameUsecase extends StartNewGameUsecase {
    public InjectableStartNewGameUsecase(CreateNewGamePort createNewGamePort, SetGamePort setGamePort, TakeTurnPort takeTurnPort) {
        super(createNewGamePort, setGamePort, takeTurnPort);
    }
}
