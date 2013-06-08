package backend.move;

import backend.Grid;
import backend.element.*;

import java.util.HashMap;
import java.util.Map;

public class MoveMaker {

	private Map<String, Move> map;
	private Grid grid;
	
	public MoveMaker(Grid grid) {
		this.grid = grid;
		initMap();
	}

	private void initMap(){
		map = new HashMap<String, Move>();
		map.put(new Candy().getKey() + new Candy().getKey(), new CandyMove(grid));
		map.put(new Candy().getKey() + new HorizontalStrippedCandy().getKey(), new CandyMove(grid));
		map.put(new Candy().getKey() + new VerticalStrippedCandy().getKey(), new CandyMove(grid));
		map.put(new Candy().getKey() + new WrappedCandy().getKey(), new CandyMove(grid));
		map.put(new Candy().getKey() + new Bomb().getKey(), new BombMove(grid));
        map.put(new Candy().getKey() + new Food().getKey(), new CandyMove(grid));

		map.put(new HorizontalStrippedCandy().getKey() + new Candy().getKey(), new CandyMove(grid));
		map.put(new HorizontalStrippedCandy().getKey() + new HorizontalStrippedCandy().getKey(), new TwoStripedMove(grid));
		map.put(new HorizontalStrippedCandy().getKey() + new VerticalStrippedCandy().getKey(), new TwoStripedMove(grid));
		map.put(new HorizontalStrippedCandy().getKey() + new WrappedCandy().getKey(), new WrappedStripedMove(grid));
		map.put(new HorizontalStrippedCandy().getKey() + new Bomb().getKey(), new BombStrippedMove(grid));
        map.put(new HorizontalStrippedCandy().getKey()+ new Food().getKey(), new CandyMove(grid));

		map.put(new VerticalStrippedCandy().getKey() + new Candy().getKey(), new CandyMove(grid));
		map.put(new VerticalStrippedCandy().getKey() + new HorizontalStrippedCandy().getKey(), new TwoStripedMove(grid));
		map.put(new VerticalStrippedCandy().getKey() + new VerticalStrippedCandy().getKey(), new TwoStripedMove(grid));
		map.put(new VerticalStrippedCandy().getKey() + new WrappedCandy().getKey(), new WrappedStripedMove(grid));
		map.put(new VerticalStrippedCandy().getKey() + new Bomb().getKey(), new BombStrippedMove(grid));
        map.put(new VerticalStrippedCandy().getKey()+ new Food().getKey(), new CandyMove(grid));

		map.put(new WrappedCandy().getKey() + new Candy().getKey(), new CandyMove(grid));
		map.put(new WrappedCandy().getKey() + new HorizontalStrippedCandy().getKey(), new WrappedStripedMove(grid));
		map.put(new WrappedCandy().getKey() + new VerticalStrippedCandy().getKey(), new WrappedStripedMove(grid));
		map.put(new WrappedCandy().getKey() + new WrappedCandy().getKey(), new TwoWrappedMove(grid));
		map.put(new WrappedCandy().getKey() + new Bomb().getKey(), new BombWrappedMove(grid));
        map.put(new WrappedCandy().getKey()+ new Food().getKey(), new CandyMove(grid));

		map.put(new Bomb().getKey() + new Candy().getKey(), new BombMove(grid));
		map.put(new Bomb().getKey() + new HorizontalStrippedCandy().getKey(), new BombStrippedMove(grid));
		map.put(new Bomb().getKey() + new VerticalStrippedCandy().getKey(), new BombStrippedMove(grid));
		map.put(new Bomb().getKey() + new WrappedCandy().getKey(), new BombWrappedMove(grid));
		map.put(new Bomb().getKey() + new Bomb().getKey(), new TwoBombMove(grid));
        map.put(new Bomb().getKey()+ new Food().getKey(), new CandyMove(grid));

        map.put(new Food().getKey() + new Candy().getKey(), new CandyMove(grid));
        map.put(new Food().getKey() + new HorizontalStrippedCandy().getKey(),new CandyMove(grid));
        map.put(new Food().getKey() + new VerticalStrippedCandy().getKey(),new CandyMove(grid));
        map.put(new Food().getKey() + new WrappedCandy().getKey(), new CandyMove(grid));
        map.put(new Food().getKey() + new Bomb().getKey(), new CandyMove(grid));
        map.put(new Food().getKey() + new Food().getKey(), new CandyMove(grid));

	}
	
	public Move getMove(int i1, int j1, int i2, int j2) {
		Move move = map.get(grid.get(i1, j1).getKey() + grid.get(i2, j2).getKey());
		if(move == null){
			return null;
		}
		move.setCoords(i1, j1, i2, j2);
		return move;
	}
}
