package backend;

import backend.cell.JellyCell;

import java.util.HashSet;
import java.util.Set;

public class JellyCondition implements Condition {
    private Set<JellyCell> jellies = new HashSet<JellyCell>();
	
	public JellyCondition(Set<JellyCell> jellies) {
		this.jellies = jellies;
	}

    public void addJelly(JellyCell jellyCell){
        jellies.add(jellyCell);
    }

    public void remove(JellyCell jellyCell){
        jellies.remove(jellyCell);
    }

	public boolean gameOver() {
		return false;
    }

	public boolean playerWon() {
		return jellies.size() == 0;
	}
}
