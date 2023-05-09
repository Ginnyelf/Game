import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Иван", 10);
    Player player2 = new Player(2, "Василий", 2);
    Player player3 = new Player(3, "Костя", 3);
    Player player4 = new Player(4, "Милан", 4);


    @Test
    public void shouldFillArrayListAndReturnStrength() {
        Game gameTour = new Game();
        gameTour.register(player1);
        gameTour.register(player2);
        gameTour.register(player3);
        gameTour.register(player4);


        int[] actual = new int[4];

        actual[0] = gameTour.strengthByName("Иван");
        actual[1] = gameTour.strengthByName("Василий");
        actual[2] = gameTour.strengthByName("Костя");
        actual[3] = gameTour.strengthByName("Милан");


        int[] expected = {10, 2, 3, 4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisteredExceptionCorrectWork() {
        Game gameTour = new Game();
        gameTour.register(player1);
        gameTour.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            gameTour.strengthByName("Валера");
        });
    }

    @Test
    public void shouldGetWinnerByStrength() {
        Game gameTour = new Game();
        gameTour.register(player1);
        gameTour.register(player2);
        gameTour.register(player3);
        gameTour.register(player4);


        int[] actual = new int[2];

        actual[0] = gameTour.round("Иван", "Василий");
        actual[1] = gameTour.round("Василий", "Костя");

        int[] expected = {1,2};
        Assertions.assertArrayEquals(expected, actual);
    }

}
