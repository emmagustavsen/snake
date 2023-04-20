package no.uib.inf101.sem2.snake.controller;

import no.uib.inf101.sem2.snake.model.GameStates;

public interface SnakeControllable {

    /**
     * Get the game screen.
     * @return object of type GameScreen
     */
    public GameStates getGameScreen();

    /**
     * Set the game screen.
     * @param gameScreen
     */
    public void setGameScreen(GameStates gameScreen);

    /**
     * Move snake
     * @param deltaRow
     * @param deltaCol
     */
    public void moveSnake(int deltaRow, int deltaCol);

    /**
     * Exit the game.
     */
    public void exit();
    
}
