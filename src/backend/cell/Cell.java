package backend.cell;

import backend.Grid;
import backend.element.Element;
import backend.element.Food;
import backend.element.Nothing;
import backend.move.Direction;

public class Cell {
	
	private Grid grid;
	private Cell[] around = new Cell[Direction.values().length];
	private Element content;

    public Cell(){

    }

	public Cell(Grid grid) {
		this.grid = grid;
		this.content = new Nothing();
	}
	
	public void setAround(Cell up, Cell down, Cell left, Cell right) {
		this.around[Direction.UP.ordinal()] = up;
		this.around[Direction.DOWN.ordinal()] = down;
		this.around[Direction.LEFT.ordinal()] = left;
		this.around[Direction.RIGHT.ordinal()] = right;
	}

	public boolean hasFloor() {
		return !around[Direction.DOWN.ordinal()].isEmpty();
	}
	
	public boolean isMovable(){
		return content.isMovable();
	}
	
	public boolean isEmpty() {
		return !content.isSolid();
	}

	public Element getContent() {
		return content;
	}

    /** Answers whether a cell should or not be skipped by
     *  a method (e.g. Blank's fallUpperContent()).
     *  Returns <tt>false</tt> by default, those who inherit and need a
     *  different behavior should overwrite.
     */

    public boolean isSkippable(){
        return false;
    }
	
	public void clearContent() {
		if(!content.isExplodable()){
			return;
		}
		if (content.isMovable()) {
			Direction[] explosionCascade = content.explode();
			grid.cellExplosion(content);
			this.content = new Nothing();
			if (explosionCascade != null) {
				expandExplosion(explosionCascade); 
			}
			this.content = new Nothing();
		}
	}
	
	private void expandExplosion(Direction[] explosion) {
		for(Direction d: explosion) {
			this.around[d.ordinal()].explode(d);
		}
	}
	
	private void explode(Direction d) {
		clearContent();
		if (this.around[d.ordinal()] != null)
			this.around[d.ordinal()].explode(d);
	}
	
	public Element getAndClearContent() {
		if (content.isMovable()) {
			Element ret = content;
			this.content = new Nothing();
			return ret;
		}
		return null;
	}

	public boolean fallUpperContent() {
		Cell up = around[Direction.UP.ordinal()];
		if (this.isEmpty() && !up.isEmpty() && up.isMovable()) {
			this.content = up.getAndClearContent();
			grid.wasUpdated();
			if (this.hasFloor()) {
				grid.tryRemove(this);
				return true;
			} else {
				Cell down = around[Direction.DOWN.ordinal()];
				return down.fallUpperContent();
			}
		} 
		return false;
	}
	
	public Grid getGrid(){
		return this.grid;
	}

    public String getKey(){
        return "Cell";    }

	public void setContent(Element content) {
		this.content = content;
	}

    public Cell[] getAround(){
        return around;
    }

    public void setAround(Cell[] around){
        this.around = around;
    }

	public void refreshPostitions() { // setea todas las celdas vecinas avisando el cambio.
		this.around[0].setPosition(1,this);
		this.around[1].setPosition(0,this);
		this.around[2].setPosition(1,this);
		this.around[3].setPosition(2,this);
		
	}

	private void setPosition(int i, Cell cell) { // le avisa a la celda vecina que yo cambie;
	this.around[i]=cell;
		
	}
}
