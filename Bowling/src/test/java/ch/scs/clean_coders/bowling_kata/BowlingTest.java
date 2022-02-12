package ch.scs.clean_coders.bowling_kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void canRole() throws Exception {
        game.roll(0);
    }

    @Test
    void gutterGame() throws Exception {
        for (int i = 0; i<20; ++i) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }
}
