package backend.cell;

import backend.FoodTypeState;
import backend.Grid;
import backend.element.Food;
import backend.element.FoodType;
import backend.element.Nothing;
import backend.move.Direction;

import java.util.Map;

public class CheckCell extends Cell {
    private Map<FoodType, FoodTypeState> foodMap;

    public CheckCell(Grid grid, Map<FoodType, FoodTypeState> foodMap){
        super(grid);
        this.foodMap = foodMap;
    }

    public boolean fallUpperContent(){
        if (this.getContent().isCheckable()){
            foodMap.get(((Food)(this.getContent())).getFoodType()).reachedCheckCell();
            this.setContent(new Nothing());
        }
        return super.fallUpperContent();
    }
}
