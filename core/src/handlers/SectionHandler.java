package handlers;

import game.Section;
import game.Unit;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class SectionHandler {
	private Array<Section> currentSections = new Array<Section>();
	
	public void add(Section section){
		currentSections.add(section);
	}
	public Section get(int index){
		return currentSections.get(index);
	}
	public Array<Section> array(){
		return currentSections;
	}
	public Section getTouchingSection(Unit unit){
		for(Section section : currentSections){
			if(unit.getHitBox().overlaps(section.get())){
				return section;
			}
		}
		return null;
	}
	/**
	 * Call only when a force close is called.
	 * 
	 */
	public void dispose(){
		currentSections.clear();
	}
}
