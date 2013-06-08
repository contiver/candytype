package backend.cell;

import backend.Grid;
import backend.element.Element;
import backend.move.Direction;

public class Blank extends Cell {

	public Blank(){

	}

    public Blank(Grid grid, Element element){
        super(grid);
        this.setContent(element);
    }

	public boolean fallUpperContent() {
		Cell up = getAround()[Direction.UP.ordinal()];
        if(up.isSkippable()){
            return false;
        }
		Cell down = searchNextAvailableCell();
        if (!up.isEmpty() && up.isMovable()) {
            Element upperContent = up.getAndClearContent();
            down.setContent(upperContent);
            getGrid().wasUpdated();
            if (!down.isEmpty()) {
                getGrid().tryRemove(this);
                return true;
            } else {
                return down.fallUpperContent();
            }
        }
        return false;
	}

    public String getKey(){
        return "Blank";
    }

    /* Return true since Blank cells should be skipped when making
     * moves or moving contents.
     */
    public boolean isSkippable(){
        return true;
    }

    public boolean isEmpty(){
        return searchNextAvailableCell().isEmpty();
    }

    private Cell searchNextAvailableCell(){
        Cell lowerCell = getAround()[Direction.DOWN.ordinal()];
        while(lowerCell.isSkippable()){
            lowerCell = lowerCell.getAround()[Direction.DOWN.ordinal()];
        }
        return lowerCell;
    }

}
