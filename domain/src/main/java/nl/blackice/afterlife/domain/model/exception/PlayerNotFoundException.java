package nl.blackice.afterlife.domain.model.exception;

public class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException(String playerName) {
        super(String.format("Player with name %s does not exist", playerName));
    }
}
