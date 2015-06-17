package game;

import com.badlogic.gdx.math.Rectangle;

public abstract class Unit implements Thing{
	
	//Unit position on the map.
	public float posx, posy;
	protected Level level;
	
	protected Unit(float x, float y, float width, float height, Level level){
		posx = x;
		posy = y;
		hitBox = new Rectangle(x, y, width, height);
		this.level = level;
	}
	
	protected Level getLevel(){
		return level;
	}
	
	/**
	 * MUST BE CALLED FROM UPDATE METHOD.
	 */
	protected void updateHitBox(float x, float y){
		hitBox.x = x;
		hitBox.y = y;
	}
	protected void updateHitBox(float x, float y, float width, float height){
		hitBox.x = x;
		hitBox.y = y;
		hitBox.width = width;
		hitBox.height = height;
	}
	
	
	private Rectangle hitBox;
	
	public Rectangle getHitBox(){
		return hitBox;
	}
	
	

}
