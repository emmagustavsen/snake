package no.uib.inf101.sem2.snake.view;

import java.awt.geom.Rectangle2D;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.GridDimension;

/**
 * 
 * Class CellPositionToPixelConverter with parameter Rectangle2D, GridDimension
 * and double.
 * 
 * @param box
 * @param gd
 * @param margin
 */
public class CellPositionToPixelConverter {

    private Rectangle2D box;
    private GridDimension gd;
    private double margin;

    /*
     * box = the area of where grid is drawn (Rectangle2D)
     * gd = describes the size of the grid that the cells are a part of
     * (GridDimension)
     * margin = the distance between cells (double)
     */
    public CellPositionToPixelConverter(Rectangle2D box, GridDimension gd, double margin) {
        this.box = box;
        this.gd = gd;
        this.margin = margin;
    }

    /**
     * 
     * Method getBoundsForCell with parameter CellPosition.
     * Return value is a Rectangle2D object.
     * 
     * @param cp
     * @return
     */
    public Rectangle2D getBoundsForCell(CellPosition cp) { // Rectangle2D skal returneres, derfor etter public
        double cellWidth = (box.getWidth() - ((gd.cols() + 1) * margin)) / gd.cols();
        double cellHeight = (box.getHeight() - ((gd.rows() + 1) * margin)) / gd.rows();
        double cellX = box.getX() + ((cp.col() + 1) * margin) + (cp.col() * cellWidth);
        double cellY = box.getY() + ((cp.row() + 1) * margin) + (cp.row() * cellHeight);
        Rectangle2D cell = new Rectangle2D.Double(cellX, cellY, cellWidth, cellHeight);
        return cell;
    }

}
