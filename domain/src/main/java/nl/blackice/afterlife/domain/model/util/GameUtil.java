package nl.blackice.afterlife.domain.model.util;

import nl.blackice.afterlife.domain.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameUtil {
    private static final Random randomizer = new Random();

    private GameUtil() {}

    public static List<Player> randomizePlayerOrder(List<Player> values) {
        List<Player> randomizedPlayers = new ArrayList<>();
        for (int idx = 0; idx < values.size(); idx++) {
            randomizedPlayers.add(values.get(randomizer.nextInt(values.size())));
        }
        return randomizedPlayers;
    }
}
