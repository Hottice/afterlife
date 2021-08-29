package nl.blackice.afterlife.ui.console;

import nl.blackice.afterlife.domain.model.exception.*;
import nl.blackice.afterlife.domain.model.value.Direction;
import nl.blackice.afterlife.domain.model.value.Location;
import nl.blackice.afterlife.domain.model.value.TerritoryMap;
import nl.blackice.afterlife.domain.port.usecase.EndPlayerTurnUsecase;
import nl.blackice.afterlife.domain.port.usecase.GetPlayerLocationsInTerritoryUsecase;
import nl.blackice.afterlife.domain.port.usecase.GetTerritoryMapUsecase;
import nl.blackice.afterlife.domain.port.usecase.MovePlayerUsecase;
import nl.blackice.common.injection.Injectable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@Injectable
public class ConsoleUI {
    private boolean running = true;
    private String playerName;
    private String territoryName;

    private final GetTerritoryMapUsecase getTerritoryMapUsecase;
    private final GetPlayerLocationsInTerritoryUsecase getPlayerLocationsInTerritoryUsecase;
    private final MovePlayerUsecase movePlayerUsecase;
    private final EndPlayerTurnUsecase endPlayerTurnUsecase;

    public ConsoleUI(GetTerritoryMapUsecase getTerritoryMapUsecase,
                     GetPlayerLocationsInTerritoryUsecase getPlayerLocationsInTerritoryUsecase,
                     MovePlayerUsecase movePlayerUsecase,
                     EndPlayerTurnUsecase endPlayerTurnUsecase) {
        this.getTerritoryMapUsecase = getTerritoryMapUsecase;
        this.getPlayerLocationsInTerritoryUsecase = getPlayerLocationsInTerritoryUsecase;
        this.movePlayerUsecase = movePlayerUsecase;
        this.endPlayerTurnUsecase = endPlayerTurnUsecase;
    }

    public void start(String playerName) {
        this.playerName = playerName;
        this.territoryName = playerName + " territory";
        while (running) {
            try {
                clearConsole();
                showMap();
                handleCommand();
            } catch (NoActionPointsException noActionPointsException) {
                System.err.println(noActionPointsException.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                Runtime.getRuntime().exec("cls");
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException ignored) {
        }
    }

    private void showMap() throws TerritoryWithNameDoesNotExistInGameException {
        TerritoryMap territoryMap = this.getTerritoryMapUsecase.getTerritoryMap(territoryName);
        Map<String, Location> playerLocations = getPlayerLocationsInTerritoryUsecase.getPlayerLocation(territoryName);
        for (int y = 0; y < territoryMap.getBoundry().getHeight(); y++) {
            for (int x = 0; x < territoryMap.getBoundry().getWidth(); x++) {
                if (hasPlayerOnLocation(x, y, playerLocations)) {
                    System.out.print('P');
                    continue;
                }
                System.out.print(RenderUtil.getCharacterForType(territoryMap.getTerritoryTypeForLocation(x, y)));
            }
            System.out.println();
        }
    }

    private boolean hasPlayerOnLocation(int x, int y, Map<String, Location> playerLocations) {
        if (playerLocations.size() == 0) {
            return false;
        }
        for (String playerName : playerLocations.keySet()) {
            if (playerLocations.get(playerName).getX() == x && playerLocations.get(playerName).getY() == y) {
                return true;
            }
        }
        return false;
    }

    private void handleCommand() throws IOException, UnableToMoveException, NotPlayersTurnException, PlayerWithNameDoesNotExistInGameException, NoActionPointsException {
        System.out.println("Enter command: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().toLowerCase().trim();
        if (input.equalsIgnoreCase("left")) {
            this.movePlayerUsecase.movePlayer(playerName, Direction.WEST);
        }
        if (input.equalsIgnoreCase("right")) {
            this.movePlayerUsecase.movePlayer(playerName, Direction.EAST);
        }
        if (input.equalsIgnoreCase("up")) {
            this.movePlayerUsecase.movePlayer(playerName, Direction.NORTH);
        }
        if (input.equalsIgnoreCase("down")) {
            this.movePlayerUsecase.movePlayer(playerName, Direction.SOUTH);
        }
        if (input.equalsIgnoreCase("end")) {
            this.endPlayerTurnUsecase.endPlayerTurn(playerName);
        }

        if (input.equalsIgnoreCase("exit")) {
            running = false;
        }
    }
}
