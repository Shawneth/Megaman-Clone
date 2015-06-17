package game;

import com.badlogic.gdx.maps.tiled.TiledMap;

import handlers.BlockHandler;
import handlers.ProjectileHandler;
import handlers.ThingHandler;
import handlers.UnitHandler;

public class Level {
	
	public final float GRAVITY = 1000f;
	final TiledMap loadedLevel;
	/**
	 * 
	 * 
	 * @param The TiledMap to be loaded. Must be compatible with game engine or will throw game specific parser errors.
	 */
	public Level(TiledMap map){
		loadedLevel = map;
	}
	/**
	 * This will result in loading a testing level.
	 * 
	 */
	public Level(){
		loadedLevel = null;
		Player player = new Player(40, 400, 50, 80, this);
		getBlocks.add(new Block(0,100,1000,50));
		getBlocks.add(new Block(340, 280, 50, 50));
		getThings.add(player);
		getUnits.add(player);
	}
	
	private void load(){
		//Load everything that can be parsed from the TiledMap object.
	}
	/**
	 * We use this to store all 'things' in the game.
	 */ 
	final ThingHandler getThings = new ThingHandler();
	/**
	 * We use this to store all the projectiles in the game.
	 */
	final ProjectileHandler getProjectiles = new ProjectileHandler();
	/**
	 * We use this to store all Units in the game.
	 */
	final UnitHandler getUnits = new UnitHandler();
	/**
	 * We use this to store all static obstacles. These are NOT considered to be 'things'.
	 */
	final BlockHandler getBlocks = new BlockHandler();
	
}
