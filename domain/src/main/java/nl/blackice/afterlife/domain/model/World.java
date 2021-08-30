package nl.blackice.afterlife.domain.model;

import nl.blackice.afterlife.domain.model.exception.AreaNotFoundException;
import nl.blackice.afterlife.domain.model.value.Size;
import nl.blackice.afterlife.domain.model.value.WorldLocation;

import java.util.ArrayList;
import java.util.List;

public class World {
    private final Size boundry;
    private final List<WorldArea> worldAreas;
    private final List<WorldEntity> worldEntities = new ArrayList<>();

    public World(Size boundry, List<WorldArea> worldAreas) {
        this.boundry = boundry;
        this.worldAreas = worldAreas;
    }

    public void addWorldEntity(WorldEntity worldEntity) {
        this.worldEntities.add(worldEntity);
    }

    public void addAllWorldEntities(List<? extends WorldEntity> entities) {
        this.worldEntities.addAll(entities);
    }

    public List<WorldEntity> getWorldEntities() {
        return worldEntities;
    }

    public List<WorldArea> getWorldAreas() {
        return worldAreas;
    }

    public Size getBoundry() {
        return boundry;
    }

    public WorldArea findWorldArea(String worldAreaIdentifier) throws AreaNotFoundException {
        for (WorldArea area : worldAreas) {
            if (area.getIdentifier().equals(worldAreaIdentifier)) {
                return area;
            }
        }
        throw new AreaNotFoundException(worldAreaIdentifier);
    }

    public WorldArea findWorldArea(WorldLocation location) throws AreaNotFoundException {
        for (WorldArea area : worldAreas) {
            if (area.getWorldLocation().equals(location)) {
                return area;
            }
        }
        throw new AreaNotFoundException(location);
    }
}
