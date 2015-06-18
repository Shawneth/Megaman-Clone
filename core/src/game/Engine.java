package game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Engine extends ApplicationAdapter {

	Level level;

	private boolean DEBUG_LEVEL = true;
	private boolean DEBUG_THINGS = true;

	SpriteBatch batch;
	ShapeRenderer debugger;

	OrthographicCamera camera;

	@Override
	public void create() {
		batch = new SpriteBatch();
		debugger = new ShapeRenderer();
		level = new Level(2.4f);
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.setToOrtho(false);

		Gdx.graphics.setVSync(true);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		debugger.setProjectionMatrix(camera.combined);
		/**
		 * Update everything in the game.
		 */
		for (Thing thing : level.getThings.array()) {
			thing.update(Gdx.graphics.getRawDeltaTime());
		}

		batch.begin();
		for (Thing thing : level.getThings.array()) {
			if(thing instanceof Player){
				float offset = ((Player) thing).getXFrame();
				batch.draw(thing.getAnimationFrame(), thing.getX() + offset, thing.getY(),
						thing.getAnimationFrame().getRegionWidth() * level.SCALE,
						thing.getAnimationFrame().getRegionHeight() * level.SCALE);
			}
			else {
			batch.draw(thing.getAnimationFrame(), thing.getX(), thing.getY(),
					thing.getAnimationFrame().getRegionWidth() * level.SCALE,
					thing.getAnimationFrame().getRegionHeight() * level.SCALE);
			}
		}
		batch.end();
		debugger.setColor(Color.BLACK);
		debugger.begin(ShapeType.Line);
		if (DEBUG_LEVEL) {
			for (Block block : level.getBlocks.array()) {
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
