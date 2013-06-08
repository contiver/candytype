package backend;

public class GameState implements Condition {
	private long score = 0;
	private int moves = 0;
    private Condition condition;

    public GameState(Condition condition){
        this.condition = condition;
    }

	public void addScore(long value) {
		this.score = this.score + value;
	}

	public long getScore(){
		return score;
	}

	public void addMove() {
		moves++;
	}

	public int getMoves() {
		return moves;
	}

	public boolean gameOver(){
        return condition.gameOver();
    }
	
	public boolean playerWon(){
        return condition.playerWon();
    }

}
