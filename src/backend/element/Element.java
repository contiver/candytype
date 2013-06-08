package backend.element;


import backend.move.Direction;

public abstract class Element {
	
	public abstract boolean isMovable();
	
	public abstract String getKey();
	
	public String getFullKey() {
		return getKey();
	}

	public boolean isSolid() {
		return true;
	}
	
	public boolean isCheckable(){
		return false;
	}

    /** Answer whether the Element should take part in special movement
     *  mechanics such as in case of a stripped or WrappedCandy.
     * @return <tt>true</tt> if the Element should be exploded by special
     * candy types, <tt>false</tt> otherwise.
     */

	public abstract boolean isExplodable();

	public Direction[] explode() {
		return null;
	}

	public long getScore() {
		return 0;
	}
	
}
