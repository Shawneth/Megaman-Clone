package handlers;

import game.Thing;

import com.badlogic.gdx.utils.Array;
/**
 * 
 * To be used inside a Level object.
 * @author Shawn G.
 *
 */
public class ThingHandler {
	
	private Array<Thing> currentThings = new Array<Thing>();
	
	public void add(Thing thing){
		currentThings.add(thing);
	}
	public Thing get(int index){
		return currentThings.get(index);
	}
	public Array<Thing> array(){
		return currentThings;
	}
	/**
	 * Only call if the current level is completely un-needed.
	 * 
	 */
	public void dispose(){
		currentThings.clear();
	}
	
	
}
