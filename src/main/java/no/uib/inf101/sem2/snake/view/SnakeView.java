package no.uib.inf101.sem2.snake.view;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import no.uib.inf101.sem2.grid.CoordinateItem;
import no.uib.inf101.sem2.snake.model.Tile;
import no.uib.inf101.sem2.snake.model.GameStates;

/**
 * 
 * @author Jasmine Næss - jasmine.ness@student.uib.no
 */
public class SnakeView extends JComponent {
    public SnakeViewable view;

    ColorTheme theme = new ColorTheme();

    int padding = 15;

    {
        this.setFocusable(true);
    }

    public SnakeView(SnakeViewable model) {
        this.view = model;
    }

    @Override
    public void paint(Graphics canvas) {
        super.paint(canvas);
        drawBoard(canvas, padding, padding, this.getWidth() - 2 * padding, this.getHeight() -2 * padding, padding/15);

        // Start screen
        if (view.getGameScreen() == GameStates.START_GAME) {
            canvas.setColor(theme.transparentgray);
            canvas.fillRect(padding, padding, this.getWidth() - 2 * padding, this.getHeight() - 2 * padding);

            canvas.setColor(theme.screenFont);
            Font str = new Font("Monospaced", Font.BOLD, 40);
            canvas.setFont(str);
            GraphicHelperMethods.drawCenteredString(
                canvas, "Press ENTER",
                20, 75, this.getWidth() - 40, this.getHeight() - 540);
            GraphicHelperMethods.drawCenteredString(
                canvas, "to begin!",
                20, 125, this.getWidth() - 40, this.getHeight() - 540);
        }

        // Pause screen

        // Game over screen

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
            Color color = theme.darkBoard;
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

    /**
     * Create a new frame with the board and right-hand menu.
     * 
     * @return the frame
     */
    public JFrame getFrame() {
        JFrame frame = new JFrame("SNAKE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // Create a new panel with BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
        // Add the board to the center of the frame
        frame.add(this, BorderLayout.CENTER);
    
        // Add the menu to the right
        frame.add(panel, BorderLayout.EAST);
    
        JLabel keys = new JLabel("<html> Key menu:" + "<br>"
        + "----------------" + "<br>"
        + "move up: ⬆ " + "<br>"
        + "move down: ⬇ " + "<br>"
        + "move left: ⬅ " + "<br>"
        + "move right: ⮕" + "<br>"
        + "pause: [P]" + "<br>"
        + "restart: [R]" + "<br>"
        + "quit: [Q] </html>");
        keys.setFont(new Font("Monospaced", Font.PLAIN, 18));
        keys.setForeground(theme.menuFont);
        keys.setBorder(BorderFactory.createEmptyBorder(80, 0, 40, 15));

        ImageIcon imageIcon = new ImageIcon(GraphicHelperMethods.loadImageFromResources("/snake.png"));
		JLabel imageLabel = new JLabel(imageIcon);

        JLabel score = new JLabel("SCORE: "); // + this.view.getScore());
        score.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 15)); 
        score.setFont(new Font("Monospaced", Font.BOLD, 30));
        score.setForeground(theme.menuFont);

        panel.add(keys);
        panel.add(imageLabel);
        panel.add(score);
    
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }
    
}
