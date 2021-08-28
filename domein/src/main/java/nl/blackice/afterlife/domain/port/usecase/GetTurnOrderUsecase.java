package nl.blackice.afterlife.domain.port.usecase;

import nl.blackice.afterlife.domain.model.World;
import nl.blackice.afterlife.domain.port.output.GetWorldPort;

import java.util.List;

public class GetTurnOrderUsecase {
    private final GetWorldPort getWorldPort;

    public GetTurnOrderUsecase(GetWorldPort getWorldPort) {
        this.getWorldPort = getWorldPort;
    }

    public List<String> getTurnOrder() {
        World world = this.getWorldPort.getWorld();
        return world.getPlayerTurnOrder();
    }
}
