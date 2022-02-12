package ch.scs.clean_coders.bowling_kata;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int firstInFrame = 0;
        for (int frame=0; frame <10; frame++) {
            if (isSpare(firstInFrame)) {
                score += 10 + rolls[firstInFrame+2];
                firstInFrame += 2;
            } else {
                score += rolls[firstInFrame] + rolls[firstInFrame+1];
                firstInFrame += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1] == 10;
    }
}
