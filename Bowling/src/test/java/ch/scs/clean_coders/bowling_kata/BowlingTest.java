package ch.scs.clean_coders.bowling_kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; ++i) {
            game.roll(pins);
        }
    }

    @Test
    void gutterGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    void allOnes() throws Exception {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    void oneSpare() throws Exception {
        game.roll(5);
        game.roll(5);   // spare
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

}
