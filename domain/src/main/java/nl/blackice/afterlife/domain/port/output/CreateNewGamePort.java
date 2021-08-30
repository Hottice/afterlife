package nl.blackice.afterlife.domain.port.output;

import nl.blackice.afterlife.domain.model.Game;
import nl.blackice.afterlife.domain.model.World;
import nl.blackice.afterlife.domain.model.value.GameSettings;
import nl.blackice.afterlife.domain.model.value.Size;

public interface CreateNewGamePort {
    Game createNewGame(String playerName, GameSettings settings);
}
