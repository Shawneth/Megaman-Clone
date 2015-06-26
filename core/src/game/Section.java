package game;

import com.badlogic.gdx.math.Rectangle;

/**
 * This class acts as a segment for the level. It is used to create 'sections'
 * of the current map for smooth deployment between areas.
 * 
 * It is currently used to invoke an event where the screen can change between areas.
 * 
 * @author Shawn Greene
 * 
 */
public class Section {
	public Section(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	private float x, y, width, height;
	
	public Rectangle get(){
		return new Rectangle(x, y, width, height);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
	

}
