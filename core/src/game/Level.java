package game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import handlers.BlockHandler;
import handlers.EventHandler;
import handlers.ProjectileHandler;
import handlers.SectionHandler;
import handlers.ThingHandler;
import handlers.UnitHandler;

public class Level {
	
	private static final int BACKGROUND = 0, OBJECTS = 1, FRONT = 3;
	
	public final float SCALE;
	//public final float WIDTH, HEIGHT;
	public final float GRAVITY = 1750f;
	
	final TiledMap loadedLevel;
	final TmxMapLoader loader = new TmxMapLoader();
	private OrthogonalTiledMapRenderer render;
	
	final private Player player;
	private Section currentSection;
	/**
	 * 
	 * 
	 * @param The TiledMap to be loaded. Must be compatible with game engine or will throw game specific parser errors.
	 */
	public Level(String map, float s){
		loadedLevel = loader.load(map);
		SCALE = s;
		render = new OrthogonalTiledMapRenderer(loadedLevel, SCALE);
		TiledMapTileLayer platforms = getLayer("platforms");
		//WIDTH = 16000f;
		//HEIGHT = 1200f;
		player = new Player(100, 200, 50, 80, this);
		getThings.add(player);
		for(int i = 0; i < platforms.getWidth(); i++){
			for(int j = 0; j < platforms.getHeight(); j++){
				if(platforms.getCell(i, j) != null){
					getBlocks.add(new Block(i * platforms.getTileWidth() * SCALE, j * platforms.getTileHeight() * SCALE, platforms.getTileWidth() * SCALE, platforms.getTileHeight() * SCALE));
				}
			}
		}
		TiledMapTileLayer sections = getLayer("sections");
		for(int i = 0; i < sections.getWidth(); i++){
			for(int j = 0; j < sections.getHeight(); j++){
				if(sections.getCell(i, j) != null){
					getSections.add(new Section(i * sections.getTileWidth() * SCALE, j * sections.getTileHeight() * SCALE, sections.getTileWidth() * SCALE, sections.getTileHeight() * SCALE));
				}
			}
		}
	}
	/**
	 * This will result in loading a testing level.
	 */
	public Level(float s){
		SCALE = s;
		//WIDTH = 16000f;
		//HEIGHT = 1200f;
		loadedLevel = null;
		player = new Player(100, 200, 50, 80, this);
		getThings.add(player);
		getBlocks.add(new Block(0,100,1000,50));
		getBlocks.add(new Block(340, 280, 50, 50));
		getBlocks.add(new Block(200, 150, 50, 50));
		getBlocks.add(new Block(400, 150, 50, 50));
		getBlocks.add(new Block(480, 180, 50, 50));
	}
	public TiledMap getMapRenderer(){
		return loadedLevel;
	}
	public OrthogonalTiledMapRenderer getRender(){
		return render;
	}
	public TiledMapTileLayer getLayer(String s){
		return (TiledMapTileLayer) loadedLevel.getLayers().get(s);
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
	/**
	 * We use this to store all of the events that may take place during the game.
	 */
	final EventHandler getEvents = new EventHandler();
	/**
	 * We use this for all the sections in the map.
	 */
	final SectionHandler getSections = new SectionHandler();
	
}
