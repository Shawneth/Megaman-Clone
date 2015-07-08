package game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Monster extends Unit{

	protected Monster(float x, float y, float width, float height, Level level) {
		super(x, y, width, height, level);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float delta) {
		
		
	}

	@Override
	public void dispose() {
		
		
	}

	@Override
	public TextureRegion getAnimationFrame() {
		return null;
	}

	@Override
	public void hitWithProjectile(Projectile type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Thing get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
