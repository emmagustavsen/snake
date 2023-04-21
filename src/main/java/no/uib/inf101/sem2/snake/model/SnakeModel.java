package no.uib.inf101.sem2.snake.model;

import java.util.LinkedList;
import java.util.Random;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.grid.GridDimension;
import no.uib.inf101.sem2.snake.controller.SnakeControllable;
import no.uib.inf101.sem2.snake.model.apple.Apple;
import no.uib.inf101.sem2.snake.model.snake.Snake;
import no.uib.inf101.sem2.snake.view.ColorTheme;
import no.uib.inf101.sem2.snake.view.SnakeViewable;

/**
 * Class representing the model of the game.
 * 
 * @author Jasmine Næss
 */
public class SnakeModel implements SnakeViewable, SnakeControllable {

    public GameState state = GameState.START_GAME;
    public Random random = new Random();
    public ColorTheme theme = new ColorTheme();
    public boolean canChangeDirection;

    // public int rows = 15;
    // public int cols = 15;
    public int snakeLength = 3;
    public int score;
    public Board board;
    public Snake snake;

    // public final Apple apple;
    private GridCell<Character> apple;

    // If the head goes in one direction, the added tile should go in the opposite direction
    private Direction direction;
    private Direction opposite;

    private LinkedList<CellPosition> snakePosition = new LinkedList<>();
    
     /**
     * Class constructor.
     * 
     */
    public SnakeModel(Board board, Snake snake) {
        this.board = board;
        this.snake = snake;
        this.score = 0;
        this.direction = Direction.LEFT;
        this.opposite = Direction.RIGHT;
        this.canChangeDirection = true;
        this.snakePosition.add(snake.getSnake().pos());
        spawnApple();
    }

    private boolean legalPosition(Snake snake) {
        for (GridCell<Character> snakeHead : snake) {

            if (!board.positionIsOnGrid(snakeHead.pos())) {
                state = GameState.GAME_OVER;
                return false;
            }
            if (board.get(snakeHead.pos()) == 'H') {
                state = GameState.GAME_OVER;
                return false;
            }
        }
        return true;
    }

    /**
     * Move the snake in a given direction.
     * 
     * @param direction
     */
    private void moveSnake(Direction direction) {
        CellPosition headPosition = snake.getSnake().pos();
        if (state == GameState.ACTIVE_GAME) {
            Snake snake = switch (direction) {
                case UP -> this.snake.moveSnake(-1, 0);
                case DOWN -> this.snake.moveSnake(1, 0);
                case LEFT -> this.snake.moveSnake(0, -1);
                case RIGHT -> this.snake.moveSnake(0, 1);
            };

            if (legalPosition(snake)) {
                this.snake = snake;
                checkIfAppleEaten();
            }
            else {
                state = GameState.GAME_OVER;
            }
            
            board.set(headPosition, 'H');
            snakePosition.add(headPosition);
            updateSnake();
        }
    }

    private void spawnApple() {
        Random random = new Random();
        int x = random.nextInt(board.cols());
        int y = random.nextInt(board.rows());
        CellPosition applePosition = new CellPosition(x, y);
        while (!board.get(applePosition).equals('-')) {
            x = random.nextInt(board.cols());
            y = random.nextInt(board.rows());
            applePosition = new CellPosition(x, y);
        }
        apple = new GridCell<>(applePosition, 'A');
        board.set(applePosition, 'A');
    }

    private void checkIfAppleEaten() {
        if (snake.getSnake().pos().equals(apple.pos())) {
            snakeLength++;
            score+= 10;
            spawnApple();
        }
    }
    
    /**
     * Update the snake by removing the tail.
     */
    private void updateSnake() {
        while (snakeLength <= snakePosition.size()) {
            board.set(snakePosition.get(0), '-');
            snakePosition.remove(0);
        }
    }
    
    @Override
    public void setDirection(Direction direction) {
        if (canChangeDirection == false)
        return;

        if (direction != opposite) {
            this.direction = direction;
            switch (direction) {
                case UP:
                    opposite = Direction.DOWN;
                    break;
                case DOWN:
                    opposite = Direction.UP;
                    break;
                case LEFT:
                    opposite = Direction.RIGHT;
                    break;
                case RIGHT:
                    opposite = Direction.LEFT;
                    break;
                default:
                    break;
                }
            }
            canChangeDirection = false;
    }

    @Override
    public void clockTick() {
        if (state == GameState.ACTIVE_GAME) {
            moveSnake(direction);
        }
        canChangeDirection = true;
    }

    @Override
    public int getDelay() {
        return 150;
    }

    @Override
    public void restart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'restart'");
    }

    @Override
    public GridDimension getDimension() {
        return board;
    }

    @Override
    public Iterable<GridCell<Character>> getTilesOnBoard() {
        return board;
    }

    @Override
    public Iterable<GridCell<Character>> movingSnakeTiles() {
        return snake;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setGameScreen(GameState gameScreen) {
        this.state = gameScreen;
    }

    @Override
    public GameState getGameScreen() {
        return state;
    }
}
