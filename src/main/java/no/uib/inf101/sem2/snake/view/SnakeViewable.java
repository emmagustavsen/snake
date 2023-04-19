package no.uib.inf101.sem2.snake.view;

import no.uib.inf101.sem2.grid.Coordinate;
import no.uib.inf101.sem2.grid.CoordinateItem;
import no.uib.inf101.sem2.snake.model.Tile;
import no.uib.inf101.sem2.snake.model.GameStates;

/**
 * SnakeViewable consists of the methods necessary for viewing.
 * These methods are defined in the classes Coordinate, CoordinateItem, Tile, and GameScreen
 * 
 * @author Jasmine Næss - jasmine.ness@student.uib.no
 */
public interface SnakeViewable {
    
     /**
      * @return number of rows in grid
      */
     int getRows();

     /**
      * @return number of columns in grid
      */
     int getCols();

     /**
      * Iterates over the tiles on board.
      *
      * @return coordinates from tiles on board
      */
     Iterable<CoordinateItem<Tile>> iterableBoard();

     /**
      * Set the color of each tile.
      *
      * @param tileCoordinate The position of the tile
      * @param color
      */
     void set(Coordinate tileCoordinate, Tile color);

     /**
      * Get the coordinate for each tile.
      *
      * @param coord
      * @return tile coordinate
      */
     Tile get(Coordinate coord);

     /**
      * @return state of GameScreen (default is ACTIVE)
      */
     public GameStates getGameScreen();

     /**
      * Get score once a full row has been removed.
      
      * @return score
      */
     public int getScore();

}
