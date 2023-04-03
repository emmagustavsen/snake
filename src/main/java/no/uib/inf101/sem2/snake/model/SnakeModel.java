package no.uib.inf101.sem2.snake.model;

import java.awt.Color;

import no.uib.inf101.sem2.grid.Coordinate;
import no.uib.inf101.sem2.grid.CoordinateItem;
import no.uib.inf101.sem2.snake.controller.SnakeControllable;
import no.uib.inf101.sem2.snake.model.snake.Snake;
import no.uib.inf101.sem2.snake.view.SnakeViewable;

/**
 * Class representing the model of the game.
 * 
 * @author Jasmine Næss
 */
public class SnakeModel implements SnakeViewable, SnakeControllable {

    public enum GameScreen {
        START_GAME,
        ACTIVE_GAME,
        PAUSE,
        GAME_OVER
    }

    public GameScreen gameScreen = GameScreen.START_GAME;

    public int rows = 15;
    public int cols = 15;
    public int score = 0;

    // custom colors
    Color green = new Color(135, 152, 106);
    Color othergreen = new Color(113, 131, 85);

    public final Board board = new Board(rows, cols, new Tile(green, '-')); {
        this.rows = board.rows;
        this.cols = board.cols;
    }
    
     /**
     * Class constructor.
     * 
     */
    public SnakeModel() {
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {

                // custom colors
                Color green = new Color(135, 152, 106);
                Color othergreen = new Color(113, 131, 85);
    
                if ((row + col) % 2 == 0) {
                    this.board.set(new Coordinate(row, col), new Tile(green, '-'));
                }
                else {
                    this.board.set(new Coordinate(row, col), new Tile(othergreen, '-'));
                }
            }
        }

        // add snake to board
        Snake snake = new Snake(Snake.G.getTile(), Snake.G.getShape());

        // initial position of snake
        int snakeStartRow = board.getRows() / 2;
        int snakeStartCol = board.getCols() / 4;
        for (int i = 0; i < snake.getWidth(); i++) {
            board.set(new Coordinate(snakeStartRow, snakeStartCol + i), snake.getTile());
        }
    }

    @Override
    public int getRows() {
        return board.getRows();
    }

    @Override
    public int getCols() {
        return board.getCols();
    }

    @Override
    public Iterable<CoordinateItem<Tile>> iterableBoard() {
        return this.board;
    }

    @Override
    public void set(Coordinate tileCoordinate, Tile color) {
        board.set(tileCoordinate, color);
    }

    @Override
    public Tile get(Coordinate tileCoordinate) {
        return board.get(tileCoordinate);
    }

    @Override
    public GameScreen getGameScreen() {
        return gameScreen;
    }

    @Override
    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    @Override
    public int getScore() {
        return board.score;
    }

    @Override
    public void moveSnake(int deltaRow, int deltaCol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveSnake'");
    }

    @Override
    public void exit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exit'");
    }

}
