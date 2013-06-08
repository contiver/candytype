package backend.element;

/**
 * Created with IntelliJ IDEA.
 * User: daniel
 * Date: 01/06/13
 * Time: 12:04
 * To change this template use File | Settings | File Templates.
 */
public class Food extends Element {
    private FoodType foodType;

    public Food(){
    }

    public Food(FoodType foodType){
        this.foodType = foodType;
    }

    public FoodType getFoodType(){
        return foodType;
    }

    @Override
    public String getFullKey() {
        return foodType.toString() + "-FOOD";
    }
    @Override
    public String getKey() {
        return "FOOD";
    }

	@Override
	public boolean isMovable() {
		return true;
	}
	
	public boolean isExplodable(){
		return false;
	}

	@Override
	public boolean isCheckable() {
		return true;
	}
}
