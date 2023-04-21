package no.uib.inf101.sem2.snake.controller;

import no.uib.inf101.sem2.snake.model.Direction;
import no.uib.inf101.sem2.snake.model.GameState;

public interface SnakeControllable {

    /**
     * Set the game screen.
     * @param gameScreen
     */
    public void setGameScreen(GameState gameScreen);

    public GameState getGameScreen();

    public void setDirection(Direction direction);

    public void clockTick();

    public int getDelay();

    public void restart();
}
