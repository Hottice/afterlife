package nl.blackice.afterlife.domain.port.usecase;

import nl.blackice.afterlife.domain.model.Player;
import nl.blackice.afterlife.domain.model.World;
import nl.blackice.afterlife.domain.model.exception.NotPlayersTurnException;
import nl.blackice.afterlife.domain.model.exception.PlayerWithNameDoesNotExistInGameException;
import nl.blackice.afterlife.domain.port.output.GetWorldPort;

public class EndPlayerTurnUsecase {
    private final GetWorldPort getWorldPort;

    public EndPlayerTurnUsecase(GetWorldPort getWorldPort) {
        this.getWorldPort = getWorldPort;
    }

    public void endPlayerTurn(String playerName) throws PlayerWithNameDoesNotExistInGameException, NotPlayersTurnException {
        World world = this.getWorldPort.getWorld();
        Player player = world.getPlayerForName(playerName);
        if (!world.isPlayersTurn(player)) {
            throw new NotPlayersTurnException(player, world.getCurrentPlayersTurn());
        }
        Player nextPlayersTurn = world.nextPlayersTurn();
        nextPlayersTurn.resetActionPoints();
    }
}
