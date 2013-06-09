package backend.cell;

import java.util.Map;

import backend.FoodTypeState;
import backend.Grid;
import backend.element.Element;
import backend.element.Food;
import backend.element.FoodType;

public class FoodGenerator  extends CandyGeneratorCell{
	private Map<FoodType, FoodTypeState> foodMap;

    public FoodGenerator(Grid grid, Map<FoodType, FoodTypeState> foodMap) {
		super(grid);
		this.foodMap = foodMap;
	}

	public Element getContent(){
		if((int)(Math.random()*100) % 22 == 0){
			int j = (int)(Math.random() * FoodType.values().length);
			FoodTypeState quantity = foodMap.get(FoodType.values()[j]);
			if(quantity.remainingFood()>0){
				quantity.draw();
				return new Food(FoodType.values()[j]);
			}
		}
		return super.getContent();
	}
}	

