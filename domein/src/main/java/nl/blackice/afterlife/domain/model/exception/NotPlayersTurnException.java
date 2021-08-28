package nl.blackice.afterlife.domain.model.exception;

import nl.blackice.afterlife.domain.model.Player;

public class NotPlayersTurnException extends Exception {
    public NotPlayersTurnException(Player playerPerformingAction, Player currentPlayersTurn) {
        super(String.format("Its not player %s turn! Its now player %s turn",
                playerPerformingAction.getName(),
                currentPlayersTurn.getName()));
    }
}
