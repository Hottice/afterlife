package nl.blackice.afterlife.starter.console;

import nl.blackice.afterlife.domain.model.value.GameSettings;
import nl.blackice.afterlife.domain.port.usecase.StartNewGameUsecase;
import nl.blackice.common.injection.InitializeInjectables;
import nl.blackice.common.injection.Injector;

public class ConsoleStarterApp {
    private static final GameSettings DEFAULT_GAME_SETTINGS = new GameSettings(
            3,
            3,
            10,
            10
    );

    public static void main(String[] args) {
        String playerName = "Marco Hak";

        InitializeInjectables.run("nl.blackice");
        StartNewGameUsecase startNewGameUsecase = Injector.get(StartNewGameUsecase.class);
        startNewGameUsecase.startNewGame(playerName, DEFAULT_GAME_SETTINGS);
    }
}
