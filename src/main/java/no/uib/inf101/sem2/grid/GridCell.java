package no.uib.inf101.sem2.grid;

/**
 * Taken from Tetris v23
 * @param cellPosition the position of the cell
 * @param E            generics
 */
public record GridCell<E>(CellPosition pos, E value) {

    public GridCell(int i1, int i2, E s) {
        this(new CellPosition(i1, i1), s);
    }

}

