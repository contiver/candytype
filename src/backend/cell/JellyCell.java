package backend.cell;
import backend.Grid;


import java.awt.Point;
import java.util.Set;

import backend.element.Nothing;
import backend.move.Direction;

public class JellyCell  extends Cell{
    private Set<JellyCell> jellies;

	public JellyCell(Grid grid, Set<JellyCell> jellies){
        super(grid);
        this.jellies = jellies;
    }

    public JellyCell(){
    }

    public String getKey(){
        return "JellyCell";
    }

    public void clearContent() {
        super.clearContent();

        Grid grid = this.getGrid();
        Point location = grid.getMap().get(this);
        Cell newCell = new Cell(grid);
        jellies.remove(this);
        grid.setCell(location.x, location.y, newCell);
        newCell.setAround(this.getAround());
        updateNeighbors(this.getAround(), newCell);
    }

    private void updateNeighbors(Cell[] around, Cell cell){
        around[Direction.UP.ordinal()].getAround()[Direction.DOWN.ordinal()] = cell;
        around[Direction.DOWN.ordinal()].getAround()[Direction.UP.ordinal()] = cell;
        around[Direction.LEFT.ordinal()].getAround()[Direction.RIGHT.ordinal()] = cell;
        around[Direction.RIGHT.ordinal()].getAround()[Direction.LEFT.ordinal()] = cell;

    }
}
