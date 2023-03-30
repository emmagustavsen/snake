package no.uib.inf101.sem2.snake.model;

import java.awt.Color;

import no.uib.inf101.sem2.grid.Coordinate;
import no.uib.inf101.sem2.grid.CoordinateItem;
import no.uib.inf101.sem2.snake.view.SnakeViewable;

public class SnakeModel implements SnakeViewable {

    public enum GameScreen {
        // PAUSE,
        ACTIVE_GAME,
        GAME_OVER
    }

    public GameScreen gameScreen = GameScreen.ACTIVE_GAME;

    public int rows = 15;
    public int cols = 15;
    
    // Custom color for the background tiles
    public static final Color lightgreen = new Color(233, 237, 201);
    // public static final Color othergreen = new Color(204, 213, 174);

    public final Board board = new Board(rows, cols, new Tile(lightgreen, '-')); {
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
    public int getScore() {
        return board.score;
    }

}
