package game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class Engine extends ApplicationAdapter {

	Level level;
	BitmapFont font;
	
	private static final String version = "0.9.1a";
	private boolean DEBUG_LEVEL = true;
	private boolean DEBUG_THINGS = true;

	SpriteBatch batch;
	SpriteBatch hud;
	ShapeRenderer debugger;

	OrthographicCamera camera, screen;
	
	

	@Override
	public void create() {
		//Version Display
		font = new BitmapFont();
		font.setUseIntegerPositions(false);
		font.setColor(Color.BLUE);
		
		//Drawing Tools
		hud = new SpriteBatch();
		batch = new SpriteBatch();
		debugger = new ShapeRenderer();
		//Defining Level and Scale
		level = new Level("level/test_level2.tmx", 2.3f);
		camera = new OrthographicCamera(5, 5);
		screen = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.setToOrtho(false);
		screen.setToOrtho(false);

		Gdx.graphics.setTitle("Platformer " + version);
		Gdx.graphics.setVSync(true);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		hud.setProjectionMatrix(screen.combined);
		debugger.setProjectionMatrix(camera.combined);
		/**
		 * Update everything in the game.
		 */
		
		for (Thing thing : level.getThings.array()) {	
			thing.update(Gdx.graphics.getRawDeltaTime());
		}
		
		//Render the map
		level.getRender().setView(camera);
		level.getRender().render();
		
		batch.begin();
		for (Thing thing : level.getThings.array()) {
			if(thing instanceof Player){
				Player player = (Player) thing;
				float offset = player.getXFrame();
				batch.draw(thing.getAnimationFrame(), thing.getX() + offset, thing.getY(),
						thing.getAnimationFrame().getRegionWidth() * level.SCALE,
						thing.getAnimationFrame().getRegionHeight() * level.SCALE);
				camera.position.x = player.getHitBox().x + player.getHitBox().width/2;
				camera.position.y = player.getHitBox().y + player.getHitBox().height/2;
				//camera.position.x = MathUtils.clamp(camera.position.x, 300f, level.getLayer("background").getWidth()*level.SCALE);
			}
			else {
			batch.draw(thing.getAnimationFrame(), thing.getX(), thing.getY(),
					thing.getAnimationFrame().getRegionWidth() * level.SCALE,
					thing.getAnimationFrame().getRegionHeight() * level.SCALE);
			}
		}
		batch.end();
		
		hud.begin();
			font.draw(hud, version, 30, 30);
		hud.end();
		
		debugger.setColor(Color.BLACK);
		debugger.begin(ShapeType.Line);
		if (DEBUG_LEVEL) {
			for (Block block : level.getBlocks.array()){
				debugger.rect(block.get().x, block.get().y, block.get().width,
						block.get().height);
			}
		}
		if (DEBUG_THINGS) {
			for (Thing thing : level.getThings.array()) {
				debugger.rect(thing.getX(), thing.getY(), thing.getWidth(),
						thing.getHeight());
			}
		}
		debugger.end();
		camera.update();
	}
}
