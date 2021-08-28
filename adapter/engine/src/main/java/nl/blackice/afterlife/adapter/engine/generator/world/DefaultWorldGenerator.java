package nl.blackice.afterlife.adapter.engine.generator.world;

import nl.blackice.afterlife.domain.model.World;
import nl.blackice.afterlife.domain.port.output.CreateNewWorldPort;
import nl.blackice.common.injection.Injectable;

@Injectable
public class DefaultWorldGenerator implements CreateNewWorldPort {
    @Override
    public World createNewWorld(CreationOptions options) {
        return null;
    }
}
