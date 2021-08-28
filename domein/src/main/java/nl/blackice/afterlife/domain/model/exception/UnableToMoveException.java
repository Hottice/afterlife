package nl.blackice.afterlife.domain.model.exception;

import nl.blackice.afterlife.domain.model.value.Direction;

public class UnableToMoveException extends Exception {
    public UnableToMoveException(String playerName, Direction direction) {
        super(String.format("Player %s can not move %s",
                playerName,
                direction));
    }
}
