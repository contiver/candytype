package backend.move;

import backend.Grid;
import backend.element.*;
import backend.element.HorizontalStrippedCandy;

public class BombStrippedMove extends Move{

	public BombStrippedMove(Grid grid) {
		super(grid);
	}
	
	@Override
	public void removeElements() {

		Candy candy = (Candy) (get(i1, j1) instanceof Bomb ? get(i2, j2) : get(i1, j1));
		CandyColor color = candy.getColor();
		
		for(int i = 0; i < Grid.SIZE; i++) {
			for(int j = 0; j < Grid.SIZE; j++) {
				if (candy.equals(get(i, j))) {
					setContent(i, j, createStriped(color));
				}
			}
		}
		
		wasUpdated();
		
		for(int i = 0; i < Grid.SIZE; i++) {
			for(int j = 0; j < Grid.SIZE; j++) {
				if (candy.equals(get(i, j))) {
					clearContent(i, j);
				}
			}
		}
	}
	
	private Candy createStriped(CandyColor color) {
		Candy c;
		if ((int)(Math.random() * 2) == 0) {
			c = new HorizontalStrippedCandy();
		} else {
			c = new VerticalStrippedCandy();
		}
		c.setColor(color);
		return c;
	}
}
