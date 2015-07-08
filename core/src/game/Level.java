package game;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
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
		System.out.println(platforms.getWidth());
		for(int i = 0; i < platforms.getWidth(); i++){
			for(int j = 0; j < platforms.getHeight(); j++){
				if(platforms.getCell(i, j) != null){
					getBlocks.add(new Block(i * platforms.getTileWidth() * SCALE, j * platforms.getTileHeight() * SCALE, platforms.getTileWidth() * SCALE, platforms.getTileHeight() * SCALE));
				}
			}
		}
		MapObjects things = loadedLevel.getLayers().get("things").getObjects();
		MapObject parsedPlayer = things.get("player");
		RectangleMapObject r = (RectangleMapObject) parsedPlayer;
		player = new Player(r.getRectangle().x * SCALE, r.getRectangle().y * SCALE, 50, 80, this);
		getThings.add(player);
	}

	/**
	 * This will result in loading a testing level.
	 */
	public Level(float s){
		SCALE = s;
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
