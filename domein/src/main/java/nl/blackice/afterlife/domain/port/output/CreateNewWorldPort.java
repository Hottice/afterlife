package nl.blackice.afterlife.domain.port.output;

import nl.blackice.afterlife.domain.model.World;
import nl.blackice.afterlife.domain.model.value.Size;

public interface CreateNewWorldPort {
    World createNewWorld(CreationOptions options);

    record CreationOptions(String playerName, Size TerritoryBoundry) {
    }
}
