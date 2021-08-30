package nl.blackice.afterlife.domain.model.exception;

import nl.blackice.afterlife.domain.model.value.WorldLocation;

public class AreaNotFoundException extends Exception {
    public AreaNotFoundException(String worldAreaIdentifier) {
        super(String.format("Area with id %s does not exist", worldAreaIdentifier));
    }

    public AreaNotFoundException(WorldLocation location) {
        super(String.format("Area not found on location %d, %d, %d", location.x(), location.y(), location.z()));
    }
}
