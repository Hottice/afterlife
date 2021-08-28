package nl.blackice.afterlife.domain.model.exception;

public class PlayerWithNameDoesNotExistInGameException extends Exception {
    public PlayerWithNameDoesNotExistInGameException(String playerName) {
        super(String.format("Player with name %s does not exist", playerName));
    }
}
