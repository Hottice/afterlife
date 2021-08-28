package nl.blackice.afterlife.starter.console;

import nl.blackice.afterlife.domain.port.usecase.StartNewGameUsecase;
import nl.blackice.common.injection.InitializeInjectables;
import nl.blackice.common.injection.Injector;

public class ConsoleStarterApp {
    public static void main(String[] args) {
        InitializeInjectables.run("nl.blackice");
        StartNewGameUsecase startNewGameUsecase = Injector.get(StartNewGameUsecase.class);
        startNewGameUsecase.startNewGame("Marco Hak");
    }
}
