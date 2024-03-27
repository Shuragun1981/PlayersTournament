import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void shouldWhenSecondPlayerWin() {
        Player boris = new Player(3, "Борис", 101);
        Player aleks = new Player(4, "Алекс", 100);
        Game game = new Game();

        game.register(boris);
        game.register(aleks);
        int actual = game.round("Алекс", "Борис"); // первый игрок это чье имя передается первым
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWhenFirstPlayerWin() {
        Player boris = new Player(3, "Борис", 100);
        Player aleks = new Player(4, "Алекс", 101);
        Game game = new Game();

        game.register(boris);
        game.register(aleks);
        int actual = game.round("Алекс", "Борис");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWhenStrengthEqual() {
        Player boris = new Player(3, "Борис", 100);
        Player aleks = new Player(4, "Алекс", 100);
        Game game = new Game();

        game.register(boris);
        game.register(aleks);
        int actual = game.round("Алекс", "Борис");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWhenFirstPlayerNotExist() {
        Player boris = new Player(3, "Борис", 100);
        Game game = new Game();

        game.register(boris);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Алекс", "Борис"));
    }

    @Test
    public void shouldWhenSecondPlayerNotExist() {
        Player boris = new Player(3, "Борис", 100);
        Game game = new Game();

        game.register(boris);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Борис", "Алекс"));
    }

}
