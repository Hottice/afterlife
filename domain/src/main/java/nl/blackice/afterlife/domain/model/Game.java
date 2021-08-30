package nl.blackice.afterlife.domain.model;

import nl.blackice.afterlife.domain.model.exception.PlayerNotFoundException;
import nl.blackice.afterlife.domain.model.util.GameUtil;

import java.util.List;

public class Game {
    private final World world;
    private final List<Player> players;
    private final List<Player> playerTurnList;
    private Player currentPlayersTurn;

    public Game(World world, List<Player> players) {
        this.world = world;
        this.players = players;
        this.playerTurnList = GameUtil.randomizePlayerOrder(List.copyOf(players));
        this.currentPlayersTurn = this.playerTurnList.get(0);
    }

    public Player findPlayerByName(String playerName) throws PlayerNotFoundException {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        throw new PlayerNotFoundException(playerName);
    }

    public void endCurrentTurn() {
        int indexOfNextPlayer = playerTurnList.indexOf(currentPlayersTurn) + 1;
        if (indexOfNextPlayer >= playerTurnList.size()) {
            indexOfNextPlayer = 0;
        }
        currentPlayersTurn = playerTurnList.get(indexOfNextPlayer);
        currentPlayersTurn.resetActionPoints();
    }

    public World getWorld() {
        return world;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayersTurn() {
        return currentPlayersTurn;
    }

    public boolean isFinished() {
        return false;
    }
}
