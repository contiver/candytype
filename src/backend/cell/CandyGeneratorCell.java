package backend.cell;

import backend.Grid;
import backend.element.Candy;
import backend.element.CandyColor;
import backend.element.Element;

public class CandyGeneratorCell extends Cell {
	
	public CandyGeneratorCell(Grid grid) {
		super(grid);
	}

	public Element getContent() {
		int i = (int)(Math.random() * CandyColor.values().length);
		return new Candy(CandyColor.values()[i]);
	}
	public boolean isMovable(){
		return true;
	}
	
	public boolean isEmpty() {
		return false;
	}


	public Element getAndClearContent() {
		return getContent();
	}


	public boolean fallUpperContent() {
		throw new IllegalStateException();
	}
	

	public void setContent(Element content) {
		throw new IllegalStateException();
	}
	
	
	public boolean equals(Object obj) {
		return false;
	}
}



