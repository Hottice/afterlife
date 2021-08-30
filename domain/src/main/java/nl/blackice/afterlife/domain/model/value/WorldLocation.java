package nl.blackice.afterlife.domain.model.value;

import java.util.Objects;

public record WorldLocation(int x, int y, int z, WorldLocationType locationType) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorldLocation that = (WorldLocation) o;
        return x == that.x && y == that.y && z == that.z && locationType == that.locationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, locationType);
    }
}
