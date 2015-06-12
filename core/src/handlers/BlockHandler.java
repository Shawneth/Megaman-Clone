package handlers;

import game.Block;
import game.Unit;

import com.badlogic.gdx.utils.Array;

public class BlockHandler {
	private Array<Block> currentBlocks = new Array<Block>();
	
	public void add(Block block){
		currentBlocks.add(block);
	}
	public Block get(int index){
		return currentBlocks.get(index);
	}
	public Array<Block> array(){
		return currentBlocks;
	}
	public Block getTouchingBlock(Unit unit){
		for(Block block : currentBlocks){
			if(unit.getHitBox().overlaps(block.get())){
				return block;
			}
		}
		return null;
	}
	public boolean isTouchingBlock(Unit unit){
		for(Block block : currentBlocks){
			if(unit.getHitBox().overlaps(block.get())){
				return true;
			}
		}
		return false;
	}
	/**
	 * Call only when a force close is called.
	 * 
	 */
	public void dispose(){
		currentBlocks.clear();
	}
}
