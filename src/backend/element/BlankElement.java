package backend.element;

public class BlankElement  extends Element
{

	@Override
	public boolean isMovable() {
		return false;
	}

	@Override
	public String getKey() {
		
		return "BlankElement";
	}

	@Override
	public boolean isExplodable() {
		return false;
	}

}
