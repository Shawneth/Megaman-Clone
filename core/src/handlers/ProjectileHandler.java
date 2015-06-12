package handlers;

import game.Projectile;

import com.badlogic.gdx.utils.Array;

public class ProjectileHandler {
	private Array<Projectile> currentProjectiles = new Array<Projectile>();
	
	public void add(Projectile projectile){
		currentProjectiles.add(projectile);
	}
	public Projectile get(int index){
		return currentProjectiles.get(index);
	}
	public Array<Projectile> array(){
		return currentProjectiles;
	}
	/**
	 * Call only when a force close is called.
	 * 
	 */
	public void dispose(){
		currentProjectiles.clear();
	}
}
