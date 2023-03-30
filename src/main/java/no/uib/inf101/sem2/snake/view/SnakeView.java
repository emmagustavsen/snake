package no.uib.inf101.sem2.snake.view;

import java.awt.Graphics;

import javax.swing.JComponent;

import no.uib.inf101.sem2.grid.CoordinateItem;
import no.uib.inf101.sem2.snake.model.Tile;

import java.awt.Color;
import java.awt.Dimension;

/**
 * 
 * @author Jasmine Næss - jasmine.ness@student.uib.no
 */
public class SnakeView extends JComponent {
    public SnakeViewable view;

    {
        this.setFocusable(true);
    }

    public SnakeView(SnakeViewable model) {
        this.view = model;
    }

    @Override
    public void paint(Graphics canvas) {
        super.paint(canvas);
        int padding = 15;
        drawBoard(canvas, padding, padding, this.getWidth() -2 * padding, this.getHeight() -2 * padding, padding/16);
    }

    /**
     * Construct a tile with padding on the right and bottom side.
     * 
     * @param canvas the canvas to be painted
     * @param xCell x-value
     * @param yCell y-value
     * @param cellWidth
     * @param cellHeight
     * @param padding
     * @param color
     */
    public void drawTileWithRightBottomPadding(Graphics canvas, int xCell, int yCell, int cellWidth, int cellHeight, int padding, Color color) {
        canvas.setColor(color);
        canvas.fillRect(xCell, yCell, cellWidth - padding, cellHeight - padding);
    }

    /**
     * Construct a board with padding on the right and bottom side.
     * 
     * @param canvas the canvas to be painted
     * @param xBoard x-value
     * @param yBoard y-value
     * @param boardWidth
     * @param boardHeight
     * @param padding
     */
    public void drawBoardWithRightBottomPadding(Graphics canvas, int xBoard, int yBoard, int boardWidth, int boardHeight, int padding, Iterable<CoordinateItem<Tile>> tilesToPaint) {

        for (CoordinateItem<Tile> coordinateItem : tilesToPaint) {
            Color color = Color.BLACK;
            int row = coordinateItem.coordinate.row;
            int col = coordinateItem.coordinate.col;
            Tile tile = coordinateItem.item;

            if (tile != null) {
                color = tile.color;
            }

            int cols = this.view.getCols();
            int rows = this.view.getRows();

            // Calculate the coordinates of the tile and paint it
            int tileX = xBoard + col * boardWidth / cols;
            int tileY = yBoard + row * boardHeight / rows;
            int nextX = xBoard + (col + 1) * boardWidth / cols;
            int nextY = yBoard + (row + 1) * boardHeight / rows;
            int tileWidth = nextX - tileX;
            int tileHeight = nextY - tileY;

            drawTileWithRightBottomPadding(canvas, tileX, tileY, tileWidth, tileHeight, padding, color);
        }
    }

    /**
     * Construct the entire board, with padding on all sides.
     * 
     * @param canvas
     * @param x 
     * @param y
     * @param width
     * @param height
     * @param padding
     */
    public void drawBoard(Graphics canvas, int x, int y, int width, int height, int padding) {
            drawBoardWithRightBottomPadding(canvas, x + padding, y + padding, width - padding, height - padding, padding, this.view.iterableBoard());
    }
    
    @Override
    public Dimension getPreferredSize() {
        int width = 700;
        int height = 700;
        return new Dimension(width, height);
    }

}
