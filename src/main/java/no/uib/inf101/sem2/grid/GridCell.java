package no.uib.inf101.sem2.grid;

/**
 * Taken from Tetris v23
 * @param cellPosition the position of the cell
 * @param E            generics
 */
public record GridCell<E>(CellPosition pos, E value) {
    public GridCell(int row, int col, E value) {
        this(new CellPosition(row, col), value);
    }

}

