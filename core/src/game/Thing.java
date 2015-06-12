package game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface Thing {
	
	public void update(float delta);
	public void dispose();
	// For getting the animated sequence in our render method.
	public TextureRegion getAnimationFrame();
	public void hitWithProjectile(Projectile type);
	public Thing get();
	public float getX();
	public float getY();
	public float getWidth();
	public float getHeight();
}
