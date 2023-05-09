import java.util.ArrayList;


public class Game {
    private ArrayList<Player> playerList = new ArrayList<Player>();

    public void register(Player player) {
        playerList.add(player);
    }

    public int strengthByName(String name) {
        for (Player player : playerList) {
            if (player.getName() == name) {
                return player.getStrength();
            }
        }
        throw new NotRegisteredException("Player with name: " + name + " is not registered!");
    }

    public int round(String playerName1, String playerName2) {
        if (strengthByName(playerName1) > strengthByName(playerName2)) {
            return 1;
        } else if (strengthByName(playerName1) < strengthByName(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }
}
