package backend;

import java.util.Map;

import backend.element.FoodType;

public class FoodCondition implements Condition {
	private Map<FoodType, FoodTypeState> foodMap;
	
	public FoodCondition(Map<FoodType, FoodTypeState> foodMap){
		this.foodMap = foodMap;
	}

    public boolean gameOver() {
        for(FoodTypeState f: foodMap.values()){
            if(!f.allReached()){
                return false;
            }
        }
        return true;
    }

    public boolean playerWon() {
        if(gameOver()){
            return true;
        }
        return false;
    }
}
