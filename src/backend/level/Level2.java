package backend.level;
import backend.*;
import backend.element.*;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import backend.cell.CandyGeneratorCell;
import backend.cell.Cell;
import backend.cell.JellyCell;
import backend.GameState;

public class Level2 extends Grid {
	
	private static int REQUIRED_SCORE = 1000;
	private static int MAX_MOVES = 10;
	
	private Cell wallCell;
	private Cell candyGenCell;
    private Set<JellyCell> jellies = new HashSet<JellyCell>();

    @Override
	protected GameState newState() {
        MixedCondition conditions = new MixedCondition();
        GameState gameState = new GameState(conditions);
        conditions.addCondition(new BasicCondition(REQUIRED_SCORE, MAX_MOVES, gameState));
        conditions.addCondition(new JellyCondition(jellies));
		return gameState;
	}

	protected void fillGrid(){
		super.fillGrid();
		JellyCell auxCell;
        for (int row = 1; row < 4; row++) {
	            for (int col = 1; col < 4; col++) {
	                auxCell = new JellyCell(this, jellies);
                    jellies.add(auxCell);
                    g()[row][col] = auxCell;
	                getMap().put(g()[row][col], new Point(row,col));
	            }
	        }
		 for (int row = 5; row < 8; row++) {
	            for (int col = 5; col < 8; col++) {
                    auxCell = new JellyCell(this,jellies);
                    jellies.add(auxCell);
	                g()[row][col] = auxCell;
	                getMap().put(g()[row][col], new Point(row,col));
	            }
	        }
	}
	
	@Override
	protected void fillCells() {
		
		wallCell = new Cell(this);
		wallCell.setContent(new Wall());
		candyGenCell = new CandyGeneratorCell(this);
		
		//corners
		g()[0][0].setAround(candyGenCell, g()[1][0], wallCell, g()[0][1]);
		g()[0][SIZE-1].setAround(candyGenCell, g()[1][SIZE-1], g()[0][SIZE-2], wallCell);
		g()[SIZE-1][0].setAround(g()[SIZE-2][0], wallCell, wallCell, g()[SIZE-1][1]);
		g()[SIZE-1][SIZE-1].setAround(g()[SIZE-2][SIZE-1], wallCell, g()[SIZE-1][SIZE-2], wallCell);

		//upper line cells
		for (int j = 1; j < SIZE-1; j++) {
			g()[0][j].setAround(candyGenCell,g()[1][j],g()[0][j-1],g()[0][j+1]);
		}
		//bottom line cells
		for (int j = 1; j < SIZE-1; j++) {
			g()[SIZE-1][j].setAround(g()[SIZE-2][j], wallCell, g()[SIZE-1][j-1],g()[SIZE-1][j+1]);
		}
		//left line cells
		for (int i = 1; i < SIZE-1; i++) {
			g()[i][0].setAround(g()[i-1][0],g()[i+1][0], wallCell ,g()[i][1]);
		}
		//right line cells
		for (int i = 1; i < SIZE-1; i++) {
			g()[i][SIZE-1].setAround(g()[i-1][SIZE-1],g()[i+1][SIZE-1], g()[i][SIZE-2], wallCell);
		}		
		//central cells
		for (int i = 1; i < SIZE-1; i++) {
			for (int j = 1; j < SIZE-1; j++) {
				g()[i][j].setAround(g()[i-1][j],g()[i+1][j],g()[i][j-1],g()[i][j+1]);
			}
		}
	}
	
	@Override
	public boolean tryMove(int i1, int j1, int i2, int j2) {
		boolean ret;
		if (ret = super.tryMove(i1, j1, i2, j2)) {
			state().addMove();
		}
		return ret;
	}
}
