package game;

public abstract class Projectile implements Thing{
	private Unit source;
	
	public Unit getSource(){
		return source;
	}
	protected Projectile(Unit unit){
		source = unit;
	}
}
