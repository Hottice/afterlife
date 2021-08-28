package nl.blackice.afterlife.domain.model.exception;

public class TerritoryWithNameDoesNotExistInGameException extends Exception {
    public TerritoryWithNameDoesNotExistInGameException(String territoryName) {
        super(String.format("Territory with name %s does not exist", territoryName));
    }
}
