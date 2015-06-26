package handlers;

import game.Event;
import com.badlogic.gdx.utils.Array;

public class EventHandler {
	private Array<Event> currentEvents = new Array<Event>();
	
	public void add(Event evt){
		currentEvents.add(evt);
	}
	public Event get(int index){
		return currentEvents.get(index);
	}
	public Array<Event> array(){
		return currentEvents;
	}
	/**
	 * Call only when a force close is called.
	 * 
	 */
	public void dispose(){
		currentEvents.clear();
	}
}
