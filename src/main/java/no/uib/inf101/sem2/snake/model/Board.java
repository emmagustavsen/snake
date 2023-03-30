package no.uib.inf101.sem2.snake.model;

import no.uib.inf101.sem2.grid.Coordinate;
import no.uib.inf101.sem2.grid.Grid;

/**
 * Class representing a board of tiles.
 * 
 * @author Jasmine Næss - jasmine.ness@student.uib.no
 */
public class Board extends Grid<Tile> {

    public int rows;
    public int cols;
    public Tile tile;
    public int score = 0;

    public Board(int rows, int cols, Tile tile) {
        super(rows, cols);
    }

    public char[][] toCharArray2D() {
        char [][] charBoard = new char[rows][cols];
        for (int row = 0; row < rows; rows++) {
            for (int col = 0; col < cols; cols++) {
                if (this.tile == null) {
                    charBoard[rows][cols] = '-';
                }
                else {
                    charBoard[rows][cols] = this.get(new Coordinate(row, col)).character;
                }
            }
        }
        return charBoard;
    }

    public String charArray2dToString(char[][] charBoard) {
        String stringOutput = "";
        for (int i = 0; i < charBoard.length; i++) {
            for (int j = 0; j < charBoard.length; j++) {
                stringOutput = charBoard.toString();
            }
        }
        return stringOutput;
    }
}
