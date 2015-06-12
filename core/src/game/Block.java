package game;

import com.badlogic.gdx.math.Rectangle;

public class Block {
	
	private Rectangle block;
	
	public Rectangle get(){
		return block;
	}
	public float getTop(){
		return block.y + block.height;
	}
	public float getRight(){
		return block.x + block.width;
	}
	public float getLeft(){
		return block.x;
	}
	public float getBottom(){
		return block.y;
	}
	public float getMiddleX(){
		return block.x + (block.width/2);
	}
	public float getMiddleY(){
		return block.y + (block.width/2);
	}
	
	public Block(float x, float y, float w, float h){
		block = new Rectangle(x, y, w, h);
	}
	
	public void dispose(){
		block = new Rectangle();
	}
	
}
