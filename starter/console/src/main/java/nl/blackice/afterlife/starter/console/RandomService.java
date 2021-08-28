package nl.blackice.afterlife.starter.console;

import nl.blackice.afterlife.domain.model.World;
import nl.blackice.afterlife.domain.port.output.CreateNewWorldPort;
import nl.blackice.afterlife.domain.port.output.GetWorldPort;
import nl.blackice.afterlife.domain.port.output.SetWorldPort;
import nl.blackice.common.injection.Injectable;

@Injectable
public class RandomService implements CreateNewWorldPort, GetWorldPort, SetWorldPort {
    @Override
    public World createNewWorld(CreationOptions options) {
        return null;
    }

    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public void setWorld(World world) {

    }
}
