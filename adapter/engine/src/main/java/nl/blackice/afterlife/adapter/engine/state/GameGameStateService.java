package nl.blackice.afterlife.adapter.engine.state;

import nl.blackice.afterlife.domain.model.Game;
import nl.blackice.afterlife.domain.port.output.GetGamePort;
import nl.blackice.afterlife.domain.port.output.SetGamePort;
import nl.blackice.common.injection.Injectable;

@Injectable
public class GameGameStateService implements GetGamePort, SetGamePort {
    private Game game;

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void setGame(Game game) {
        this.game = game;
    }
}
