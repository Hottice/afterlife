package nl.blackice.afterlife.domain.port.usecase;

import nl.blackice.afterlife.domain.model.Game;
import nl.blackice.afterlife.domain.model.Player;
import nl.blackice.afterlife.domain.model.exception.*;
import nl.blackice.afterlife.domain.model.value.Direction;
import nl.blackice.afterlife.domain.port.output.GetGamePort;

public class MovePlayerOnMapUsecase {
    private final GetGamePort getGamePort;

    public MovePlayerOnMapUsecase(GetGamePort getGamePort) {
        this.getGamePort = getGamePort;
    }

    public void movePlayer(String playerName, Direction direction) throws NotPlayersTurnException, PlayerNotFoundException, UnableToMoveException, NoActionPointsException, AreaNotFoundException {
        Game game = this.getGamePort.getGame();
        Player player = game.findPlayerByName(playerName);
        if (!game.getCurrentPlayersTurn().equals(player)) {
            throw new NotPlayersTurnException(player, game.getCurrentPlayersTurn());
        }
        player.move(direction, game.getWorld().findWorldArea(player.getWorldLocation()).getMap());
    }
}
