package frontend;

import java.util.ArrayList;
import java.util.List;

import backend.GameListener;
import backend.Grid;

public class FrontGrid {
	private Grid grid;
	private List<GameListener> listeners = new ArrayList<GameListener>();
	public static final int DELAY_MS = 50;
	
	public FrontGrid(Grid grid){
		this.grid = grid;
	}
	
	public void addListener(GameListener listener) {
		listeners.add(listener);
	}
	
	public Grid getGrid(){
		return grid;
	}
	
	public void wasUpdated(){
		if (listeners.size() > 0) {
			for (GameListener gl: listeners) {
				gl.gridUpdated();
			}
			delay(DELAY_MS);
		}
	}
	
	public void delay(int ms){
		try {
			  Thread.sleep(ms);
		} catch (InterruptedException ie) {
		}
	}
}
