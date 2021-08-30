package nl.blackice.afterlife.domain.model.value;

import java.util.Objects;

/**
 * Top left is 0,0
 */
public record MapLocation(int x, int y) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapLocation that = (MapLocation) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
