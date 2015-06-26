package game;

public abstract class Event {
	
	public enum EventState {
		HITWALL
	}
	
	private EventState type;

	protected EventState getState(){
		return type;
	}
	
	public abstract void run(float delta);
	
	

}
