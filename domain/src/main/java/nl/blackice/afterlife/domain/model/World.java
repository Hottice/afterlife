package nl.blackice.afterlife.domain.model;

import nl.blackice.afterlife.domain.model.exception.PlayerWithNameDoesNotExistInGameException;
import nl.blackice.afterlife.domain.model.exception.TerritoryWithNameDoesNotExistInGameException;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class World {
    private final Map<String, Player> players;
    private final List<Player> playerTurnList;
    private Player currentPlayersTurn;

    public World(Map<String, Player> players, List<Player> playerTurnList, Player currentPlayersTurn) {
        this.players = players;
        this.playerTurnList = playerTurnList;
        this.currentPlayersTurn = currentPlayersTurn;
    }

    public Collection<Player> getPlayers() {
        return players.values();
    }

    public Player getPlayerForName(String playerName) throws PlayerWithNameDoesNotExistInGameException {
        if (!players.containsKey(playerName)) {
            throw new PlayerWithNameDoesNotExistInGameException(playerName);
        }
        return players.get(playerName);
    }

    public boolean isPlayersTurn(Player player) {
        return player.getName().equals(currentPlayersTurn.getName());
    }

    public Player getCurrentPlayersTurn() {
        return currentPlayersTurn;
    }

    public Territory getTerritoryWithName(String territoryName) throws TerritoryWithNameDoesNotExistInGameException {
        for (Player player : players.values()) {
            if (player.getTerritory().getName().equals(territoryName)) {
                return player.getTerritory();
            }
        }
        throw new TerritoryWithNameDoesNotExistInGameException(territoryName);
    }

    public Player nextPlayersTurn() {
        int nextTurnIndex = playerTurnList.indexOf(currentPlayersTurn) + 1;
        if (nextTurnIndex == playerTurnList.size()) {
            nextTurnIndex = 0;
        }
        this.currentPlayersTurn = playerTurnList.get(nextTurnIndex);
        return currentPlayersTurn;
    }

    public List<String> getPlayerTurnOrder() {
        return playerTurnList.stream().map(Player::getName).toList();
    }
}
