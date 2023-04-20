package no.uib.inf101.sem2.snake.view;

import java.awt.Color;

/**
 * Class representing the colors used in the game.
 * 
 * @author Jasmine Næss
 */
public class ColorTheme {

    // Color for the overlapping screen (when the game is not started yet, paused, or over)
    Color transparentgray = new Color(0, 0, 0, 128);

    // Font colors
    Color menuFont = new Color(58, 90, 64);
    Color screenFont = new Color(227, 213, 202);

    // Colors for the board (tiled background with alternating colors, like a chess board)
    Color lightBoard = new Color(61, 61, 61);
    Color darkBoard = new Color(49, 49, 49);

    // Default color for the snake and apple
    Color snakeColor = new Color(113, 131, 85);
    Color appleColor = new Color(188, 71, 73);

    // Custom colors for the snake
    Color pinkSnake = new Color(240, 128, 128);
    Color purpleSnake = new Color(94, 84, 142);
    Color blueSnake = new Color(127, 200, 248);

    // Custom colors for the fruit
    Color banana = new Color(255, 228, 94);
    Color orange = new Color(255, 214, 112);
    Color strawberry = new Color(201, 24, 74);

    // Usikker på om vi skal ha getters eller setters (eller bare setters) for fargene på brettet,
    // ettersom de ikke skal endres...

    /**
     * Getter for the light board color.
     * @return the light board color
     */
    public Color getLightBoardColor() {
        return lightBoard;
    }

    /**
     * Getter for the dark board color.
     * @return the dark board color
     */
    public Color getDarkBoardColor() {
        return darkBoard;
    }

    /**
     * Getter for the color of the snake.
     * @return the color of the snake
     */
    public Color getSnakeColor() {
        return snakeColor;
    }

    /**
     * Sets the color of the snake.
     * Based on user input from the Options-menu.
     */
    public void setSnakeColor() {
        if (snakeColor == pinkSnake) {
            snakeColor = purpleSnake;
        }
        else if (snakeColor == purpleSnake) {
            snakeColor = blueSnake;
        }
        else if (snakeColor == blueSnake) {
            snakeColor = pinkSnake;
        }
    }

    /**
     * Getter for the fruit color.
     * @return the color of the fruit
     */
    public Color getFruitColor() {
        return appleColor;
    }

    /**
     * Sets the color of the fruit.
     * Based on user input from the Options-menu.
     */
    public void setFruitColor() {
        if (appleColor == banana) {
            appleColor = orange;
        }
        else if (appleColor == orange) {
            appleColor = strawberry;
        }
        else if (appleColor == strawberry) {
            appleColor = banana;
        }
    }
}
