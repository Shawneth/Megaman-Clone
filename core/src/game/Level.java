package game;

import com.badlogic.gdx.maps.tiled.TiledMap;

import handlers.BlockHandler;
import handlers.ProjectileHandler;
import handlers.ThingHandler;
import handlers.UnitHandler;

public class Level {
	
	public final float SCALE;
	public final float WIDTH, HEIGHT;
	public final float GRAVITY = 1750f;
	
	final TiledMap loadedLevel;
	
	private Player player;
	/**
	 * 
	 * 
	 * @param The TiledMap to be loaded. Must be compatible with game engine or will throw game specific parser errors.
	 */
	public Level(TiledMap map, float s){
		loadedLevel = map;
		SCALE = s;
		player = null;
		HEIGHT = 0;
		WIDTH = 0;
	}
	/**
	 * This will result in loading a testing level.
	 * 
	 */
	public Level(float s){
		SCALE = s;
		WIDTH = 16000f;
		HEIGHT = 1200f;
		loadedLevel = null;
		player = new Player(100, 200, 50, 80, this);
		getThings.add(player);
		getBlocks.add(new Block(0,100,1000,50));
		getBlocks.add(new Block(340, 280, 50, 50));
		getBlocks.add(new Block(200, 150, 50, 50));
		getBlocks.add(new Block(400, 150, 50, 50));
		getBlocks.add(new Block(480, 180, 50, 50));
	}
	
	private void load(){
		//Load everything that can be parsed from the TiledMap object.
	}
	/**
	 * The current player in the level.
	 * @return The level's player.
	 */
	public Player getPlayer(){
		return player;
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
