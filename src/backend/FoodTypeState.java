package backend;

public class FoodTypeState {
	private int remaining;
	private int reachedCheckCell;
	private final int startingAmount;
	
	
	public FoodTypeState(int amount)
	{
        this.startingAmount = amount;
		this.remaining = amount;
		this.reachedCheckCell = 0;
	}
	
	public void reachedCheckCell(){
	this.reachedCheckCell += 1;
	}
	
	public boolean allReached(){
		return startingAmount - reachedCheckCell == 0;
	}
	
	public int remainingFood(){
		return this.remaining;
	}
	public void draw(){
		this.remaining -= 1;
	}

}
