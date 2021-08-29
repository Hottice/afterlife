package nl.blackice.afterlife.starter.console;

import nl.blackice.afterlife.domain.port.usecase.StartNewGameUsecase;
import nl.blackice.afterlife.ui.console.ConsoleUI;
import nl.blackice.common.injection.InitializeInjectables;
import nl.blackice.common.injection.Injector;

public class ConsoleStarterApp {
    public static void main(String[] args) {
        String playerName = "Marco Hak";

        InitializeInjectables.run("nl.blackice");
        StartNewGameUsecase startNewGameUsecase = Injector.get(StartNewGameUsecase.class);
        startNewGameUsecase.startNewGame(playerName);
        Injector.get(ConsoleUI.class).start(playerName);
    }
}
