package game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface Thing {
	
	// Updates constantly relative to the delta.
	public void update(float delta);
	// Removes the current 'thing' from the game.
	public void dispose();
	// For getting the current frame in sequence for our render method.
	public TextureRegion getAnimationFrame();
	// Called when hit with a projectile.
	public void hitWithProjectile(Projectile type);
	// Returns the parent thing.
	public Thing get();
	public float getX();
	public float getY();
	public float getWidth();
	public float getHeight();
}
