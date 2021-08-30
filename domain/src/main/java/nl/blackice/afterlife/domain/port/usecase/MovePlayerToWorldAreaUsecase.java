package nl.blackice.afterlife.domain.port.usecase;

import nl.blackice.afterlife.domain.model.Game;
import nl.blackice.afterlife.domain.model.Player;
import nl.blackice.afterlife.domain.model.WorldArea;
import nl.blackice.afterlife.domain.model.exception.*;
import nl.blackice.afterlife.domain.port.output.GetGamePort;

public class MovePlayerToWorldAreaUsecase {
    private final GetGamePort getGamePort;

    public MovePlayerToWorldAreaUsecase(GetGamePort getGamePort) {
        this.getGamePort = getGamePort;
    }

    public void movePlayerToWorldArea(String playerName, String worldAreaIdentifier) throws NotPlayersTurnException, PlayerNotFoundException, AreaNotFoundException {
        Game game = this.getGamePort.getGame();
        Player player = game.findPlayerByName(playerName);
        if (!game.getCurrentPlayersTurn().equals(player)) {
            throw new NotPlayersTurnException(player, game.getCurrentPlayersTurn());
        }
        WorldArea worldArea = game.getWorld().findWorldArea(worldAreaIdentifier);
        player.moveTo(worldArea.getWorldLocation(), worldArea.getEntryLocation());
    }
}
