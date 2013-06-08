package backend;

public class BasicCondition implements Condition {
	private long requiredScore;
	private long maxMoves;
    private GameState gameState;
	
	public BasicCondition(long requiredScore, int maxMoves, GameState gameState) {
		this.requiredScore = requiredScore;
		this.maxMoves = maxMoves;
        this.gameState = gameState;
	}

	public boolean gameOver() {
		return gameState.getMoves() >= maxMoves;
	}
	
	public boolean playerWon() {
		return gameState.getScore() > requiredScore;
	}
}

