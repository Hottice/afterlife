package nl.blackice.afterlife.domain.port.usecase;

import nl.blackice.afterlife.domain.model.Game;
import nl.blackice.afterlife.domain.model.value.GameSettings;
import nl.blackice.afterlife.domain.port.output.CreateNewGamePort;
import nl.blackice.afterlife.domain.port.output.SetGamePort;
import nl.blackice.afterlife.domain.port.output.TakeTurnPort;

public class StartNewGameUsecase {
    private final CreateNewGamePort createNewGamePort;
    private final SetGamePort setGamePort;
    private final TakeTurnPort takeTurnPort;

    public StartNewGameUsecase(CreateNewGamePort createNewGamePort, SetGamePort setGamePort, TakeTurnPort takeTurnPort) {
        this.createNewGamePort = createNewGamePort;
        this.setGamePort = setGamePort;
        this.takeTurnPort = takeTurnPort;
    }

    public void startNewGame(String playerName, GameSettings settings) {
        Game game = createNewGamePort.createNewGame(playerName, settings);
        setGamePort.setGame(game);

        while (!game.isFinished()) {
            takeTurnPort.takeTurn(game.getCurrentPlayersTurn());
            game.endCurrentTurn();
        }
    }
}
