package nl.blackice.afterlife.domain.model.exception;

public class NoActionPointsException extends Exception {
    public NoActionPointsException(String playerName, int neededActionPoints, int currentActionPoints) {
        super(String.format("Player %s has %d action points but needs %d action points",
                playerName, currentActionPoints, neededActionPoints));
    }
}
