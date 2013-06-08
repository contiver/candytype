package backend;

import java.util.ArrayList;
import java.util.List;

public class MixedCondition implements Condition {
	private List<Condition> conditionList = new ArrayList<Condition>();
	
    public void addCondition(Condition condition){
        conditionList.add(condition);
    }

	@Override
	public boolean gameOver() {
        if(conditionList.isEmpty()){
            throw new IllegalStateException();
        }
        for(Condition c: conditionList){
            if(c.gameOver()){
                return true;
            }
        }
        return false;
	}

	@Override
	public boolean playerWon() {
        if(conditionList.isEmpty()){
            throw new IllegalStateException();
        }
        for(Condition c: conditionList){
            if(!(c.playerWon())){
                return false;
            }
        }
        return true;
	}
	
	
}
