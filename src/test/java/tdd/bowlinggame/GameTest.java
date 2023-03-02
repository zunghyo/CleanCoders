package tdd.bowlinggame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void canRoll(){
        Game game = new Game();
        game.roll(0);
    }

    @Test
    public void gutterGame(){
        int pins = 0;
        int frames = 20;
        rollMany(pins, frames);
        assertThat(game.getScore(), is(0));
    }

    @Test
    public void allOnes(){
        int pins = 1;
        int frames = 20;
        rollMany(pins, frames);
        assertThat(game.getScore(), is(20));
    }

    @Ignore
    @Test
    public void oneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.getScore(), is(16));
    }

    @Test
    public void oneStrike() {
        rollStrike();
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertThat(game.getScore(), is(26));
    }
    @Test
    public void perfectGame() {
        rollMany(10, 10);
        game.roll(10);
        game.roll(10);
        assertThat(game.getScore(), is(300));
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5); //spare
    }

    private void rollMany(int pins, int frames) {
        for (int i = 0; i < frames; i++) {
            game.roll(pins);
        }
    }

}
