package nl.blackice.afterlife.domain.port.usecase;

import nl.blackice.afterlife.domain.model.World;
import nl.blackice.afterlife.domain.model.value.Size;
import nl.blackice.afterlife.domain.port.output.CreateNewWorldPort;
import nl.blackice.afterlife.domain.port.output.SetWorldPort;

public class StartNewGameUsecase {
    private final CreateNewWorldPort createNewWorldPort;
    private final SetWorldPort setWorldPort;

    public StartNewGameUsecase(CreateNewWorldPort createNewWorldPort, SetWorldPort setWorldPort) {
        this.createNewWorldPort = createNewWorldPort;
        this.setWorldPort = setWorldPort;
    }

    public void startNewGame(String playerName) {
        Size territoryBoundry = new Size(10, 10);
        World newWorld = createNewWorldPort.createNewWorld(new CreateNewWorldPort.CreationOptions(playerName, territoryBoundry));
        setWorldPort.setWorld(newWorld);
    }
}
