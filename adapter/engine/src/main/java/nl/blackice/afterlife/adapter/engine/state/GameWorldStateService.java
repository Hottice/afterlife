package nl.blackice.afterlife.adapter.engine.state;

import nl.blackice.afterlife.domain.model.World;
import nl.blackice.afterlife.domain.port.output.GetWorldPort;
import nl.blackice.afterlife.domain.port.output.SetWorldPort;
import nl.blackice.common.injection.Injectable;

@Injectable
public class GameWorldStateService implements GetWorldPort, SetWorldPort {
    private World world;

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public void setWorld(World world) {
        this.world = world;
    }
}
