package nl.blackice.afterlife.ui.console;

import nl.blackice.afterlife.domain.model.Player;
import nl.blackice.afterlife.domain.model.WorldArea;
import nl.blackice.afterlife.domain.model.WorldEntity;
import nl.blackice.afterlife.domain.model.exception.*;
import nl.blackice.afterlife.domain.model.value.Direction;
import nl.blackice.afterlife.domain.model.value.Map;
import nl.blackice.afterlife.domain.model.value.WorldMap;
import nl.blackice.afterlife.domain.port.output.TakeTurnPort;
import nl.blackice.afterlife.domain.port.usecase.GetWorldEntitiesForAreaUsecase;
import nl.blackice.afterlife.domain.port.usecase.GetMapUsecase;
import nl.blackice.afterlife.domain.port.usecase.GetWorldMapUsecase;
import nl.blackice.afterlife.domain.port.usecase.MovePlayerOnMapUsecase;
import nl.blackice.common.injection.Injectable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Injectable
public class ConsoleUI implements TakeTurnPort {
    private final GetMapUsecase getMapUsecase;
    private final GetWorldMapUsecase getWorldMapUsecase;
    private final GetWorldEntitiesForAreaUsecase getWorldEntitiesForAreaUsecase;
    private final MovePlayerOnMapUsecase movePlayerUsecase;
    private boolean takingTurn = false;

    public ConsoleUI(GetMapUsecase getMapUsecase,
                     GetWorldMapUsecase getWorldMapUsecase, GetWorldEntitiesForAreaUsecase getWorldEntitiesForAreaUsecase,
                     MovePlayerOnMapUsecase movePlayerUsecase) {
        this.getMapUsecase = getMapUsecase;
        this.getWorldMapUsecase = getWorldMapUsecase;
        this.getWorldEntitiesForAreaUsecase = getWorldEntitiesForAreaUsecase;
        this.movePlayerUsecase = movePlayerUsecase;
    }

    @Override
    public void takeTurn(Player player) {
        takingTurn = true;
        while (takingTurn) {
            try {
                clearConsole();
                showMap(player);
                handleCommand(player);
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

    private void showMap(Player player) throws AreaNotFoundException {
        Map map = this.getMapUsecase.getMap(player.getWorldLocation());
        List<WorldEntity> worldEntitiesForArea = getWorldEntitiesForAreaUsecase.getWorldEntitiesForArea(player.getWorldLocation());
        List<String> lines = renderMap(map, worldEntitiesForArea);
        renderLines(lines);
    }

    private List<String> renderWorldMap(WorldMap worldMap) throws AreaNotFoundException {
        List<String> resultLines = new ArrayList<>();
        for (int y = 0; y < worldMap.boundry().height(); y++) {
            List<String> lines = new ArrayList<>();
            for (int x = 0; x < worldMap.boundry().width(); x++) {
                WorldArea area = worldMap.worldAreas()[x][y];
                List<WorldEntity> worldEntitiesForArea = getWorldEntitiesForAreaUsecase.getWorldEntitiesForArea(area.getWorldLocation());
                List<String> mapLines = renderMap(area.getMap(), worldEntitiesForArea);
                for (int indexToAdjust = 0; indexToAdjust < mapLines.size(); indexToAdjust++) {
                    if (lines.size() <= indexToAdjust) {
                        lines.add("");
                    }
                    lines.set(indexToAdjust, lines.get(indexToAdjust) + " " + mapLines.get(indexToAdjust));
                }
            }
            resultLines.add("");
            resultLines.addAll(lines);
        }
        return resultLines;
    }

    private List<String> renderMap(Map map, List<WorldEntity> worldEntitiesForArea) {
        List<String> lines = new ArrayList<>();
        for (int y = 0; y < map.boundry().height(); y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < map.boundry().width(); x++) {
                if (hasPlayerOnLocation(x, y, worldEntitiesForArea)) {
                    line.append('P');
                    continue;
                }
                line.append(RenderUtil.getCharacterForType(map.getTerritoryTypeForLocation(x, y)));
            }
            lines.add(line.toString());
        }
        return lines;
    }

    private void renderLines(List<String> linesToRender) {
        for (String s : linesToRender) {
            System.out.println(s);
        }
        System.out.println();
    }

    private boolean hasPlayerOnLocation(int x, int y, List<WorldEntity> entityLocations) {
        if (entityLocations.size() == 0) {
            return false;
        }
        for (WorldEntity entity : entityLocations) {
            if (entity instanceof Player && entity.getMapLocation().x() == x && entity.getMapLocation().y() == y) {
                return true;
            }
        }
        return false;
    }

    private void handleCommand(Player player) throws IOException, UnableToMoveException, NotPlayersTurnException, PlayerNotFoundException, NoActionPointsException, AreaNotFoundException {
        System.out.println("Enter command: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().toLowerCase().trim();
        if (input.equalsIgnoreCase("left")) {
            this.movePlayerUsecase.movePlayer(player.getName(), Direction.WEST);
        }
        if (input.equalsIgnoreCase("right")) {
            this.movePlayerUsecase.movePlayer(player.getName(), Direction.EAST);
        }
        if (input.equalsIgnoreCase("up")) {
            this.movePlayerUsecase.movePlayer(player.getName(), Direction.NORTH);
        }
        if (input.equalsIgnoreCase("down")) {
            this.movePlayerUsecase.movePlayer(player.getName(), Direction.SOUTH);
        }
        if (input.equalsIgnoreCase("map")) {
            WorldMap worldMap = this.getWorldMapUsecase.getWorldMap(0);
            List<String> lines = renderWorldMap(worldMap);
            renderLines(lines);
        }
        if (input.equalsIgnoreCase("end")) {
            this.takingTurn = false;
        }
    }
}
