package nl.blackice.afterlife.domain.port.output;

import nl.blackice.afterlife.domain.model.Player;

public interface TakeTurnPort {
    void takeTurn(Player player);
}
