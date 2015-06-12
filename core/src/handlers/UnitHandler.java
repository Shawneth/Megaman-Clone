package handlers;

import game.Unit;

import com.badlogic.gdx.utils.Array;

public class UnitHandler {
	private Array<Unit> currentUnits = new Array<Unit>();
	
	public void add(Unit unit){
		currentUnits.add(unit);
	}
	public Unit get(int index){
		return currentUnits.get(index);
	}
	public Array<Unit> array(){
		return currentUnits;
	}
	/**
	 * Call only when a force close is called.
	 * 
	 */
	public void dispose(){
		currentUnits.clear();
	}
}
