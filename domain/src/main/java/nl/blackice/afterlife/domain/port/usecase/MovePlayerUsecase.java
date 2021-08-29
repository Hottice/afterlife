package nl.blackice.afterlife.domain.port.usecase;

import nl.blackice.afterlife.domain.model.Player;
import nl.blackice.afterlife.domain.model.World;
import nl.blackice.afterlife.domain.model.exception.NoActionPointsException;
import nl.blackice.afterlife.domain.model.exception.NotPlayersTurnException;
import nl.blackice.afterlife.domain.model.exception.PlayerWithNameDoesNotExistInGameException;
import nl.blackice.afterlife.domain.model.exception.UnableToMoveException;
import nl.blackice.afterlife.domain.model.value.Direction;
import nl.blackice.afterlife.domain.port.output.GetWorldPort;

public class MovePlayerUsecase {
    private final GetWorldPort getWorldPort;

    public MovePlayerUsecase(GetWorldPort getWorldPort) {
        this.getWorldPort = getWorldPort;
    }

    public void movePlayer(String playerName, Direction direction) throws NotPlayersTurnException, PlayerWithNameDoesNotExistInGameException, UnableToMoveException, NoActionPointsException {
        World world = this.getWorldPort.getWorld();
        Player player = world.getPlayerForName(playerName);
        if (!world.isPlayersTurn(player)) {
            throw new NotPlayersTurnException(player, world.getCurrentPlayersTurn());
        }
        player.move(direction);
    }
}
