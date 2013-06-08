package backend.element;

public class Bomb extends Element{
	
	@Override
	public boolean isMovable() {
		return true;
	}
	
	@Override
	public String getKey() {
		return "BOMB";
	}
	
	@Override
	public long getScore() {
		return 200;
	}

	@Override
	public boolean isExplodable() {
		return true;
	}
}
