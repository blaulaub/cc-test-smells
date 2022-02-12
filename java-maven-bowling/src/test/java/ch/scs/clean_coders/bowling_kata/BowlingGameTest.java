package ch.scs.clean_coders.bowling_kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {

    private BowlingGame g;

    @BeforeEach
    void setUp() {
        g = new BowlingGame();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; ++i) {
            g.roll(pins);
        }
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);   // spare
    }

    private void rollStrike() {
        g.roll(10);
    }

    @Test
    void gutterGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, g.score());
    }

    @Test
    void allOnes() throws Exception {
        rollMany(20, 1);
        assertEquals(20, g.score());
    }

    @Test
    void oneSpare() throws Exception {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertEquals(16, g.score());
    }

    @Test
    void oneStrike() throws Exception {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertEquals(24, g.score());
    }

    @Test
    void perfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, g.score());
    }
}
