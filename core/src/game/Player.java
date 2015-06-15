package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Unit{

	private float movementSpeed = 200f;
	private float yVel = 0f;
	
	private float stateTime = 0;
	
	private Texture t_walking;
	private Animation walking;
	private TextureRegion[][] walkingFrames;
	
	private Texture t_idle;
	private Animation idle;
	private TextureRegion[][] idleFrames;
	
	private TextureRegion currentFrame;
	
	
	public Player(float x, float y, float width, float height, Level level) {
		super(x, y, width, height, level);
		loadAnimation();
	}
	
	private void loadAnimation(){
		t_idle = new Texture(Gdx.files.internal("idle2-strip.png"));
		idleFrames = TextureRegion.split(t_idle, 24, 24);
		idle = new Animation(1, idleFrames[0]);
		
		t_walking = new Texture(Gdx.files.internal("moving-strip.png"));
		walkingFrames = TextureRegion.split(t_walking, 24, 24);
		walking = new Animation(0.25f, walkingFrames[0]);
	}
	
	private Rectangle collisionChecker;

	@Override
	public void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.D)) moveRight(movementSpeed * delta);
		else if(Gdx.input.isKeyPressed(Keys.A)) moveLeft(movementSpeed * delta);
		
		if(Gdx.input.isKeyPressed(Keys.SPACE) && !isInAir){
			isInAir = true;
			yVel = 600f;
		}
		
		if(isInAir){
			free(delta);
		}
		else{
			if(!level.getBlocks.isTouchingBlock(this)){
				isInAir = true;
				yVel = -250;
			}
		}
		
		stateTime += delta;
		
		if(!isMoving){
			currentFrame = idle.getKeyFrame(stateTime, true);
		}
		else{
			currentFrame = walking.getKeyFrame(stateTime, true);
		}	
		isMoving = false;
		
		super.updateHitBox(posx, posy);
	}
	
	private boolean isRight = true;
	private boolean isMoving = false;
	private boolean isInAir = true;
	
	private void free(float speed){
		float relativeSpeed = yVel * speed;
		Rectangle collisionChecker = new Rectangle(this.getHitBox().x,this.getHitBox().y + relativeSpeed,this.getHitBox().width,this.getHitBox().height);
		posy += relativeSpeed;
		yVel -= level.GRAVITY * speed;
		for(Block block : level.getBlocks.array()){
			if(collisionChecker.overlaps(block.get())){
				if(block.getTop() > collisionChecker.y && yVel <= 0){
					posy = block.getTop();
					yVel = 0f;
					isInAir = false;
					break;
				}
				else if(block.getTop() > collisionChecker.y && yVel > 0){
					posy = block.getBottom() - getHitBox().height;
					yVel = 0;
				}
			}
		}
		updateHitBox(posy, posx);
	}
	
	private void moveRight(float distance){
		if(!isRight){
			for(TextureRegion r : idleFrames[0]){
				r.flip(true, false);
			}
			for(TextureRegion r : walkingFrames[0]){
				r.flip(true, false);
			}
			isRight = !isRight;
		}
		collisionChecker = new Rectangle(this.getHitBox().x + distance,this.getHitBox().y,this.getHitBox().width,this.getHitBox().height);
		for(Block block : getLevel().getBlocks.array()){
			if(Intersector.overlaps(collisionChecker, block.get())){
				posx = block.getLeft() - getHitBox().getWidth();
				return;
			}
		}
		isMoving = true;
		posx += distance;
	}
	private void moveLeft(float distance){
		if(isRight){
			isRight = !isRight;
			for(TextureRegion r : idleFrames[0]){
				r.flip(true, false);
			}
			for(TextureRegion r : walkingFrames[0]){
				r.flip(true, false);
			}
		}
		collisionChecker = new Rectangle(this.getHitBox().x - distance,this.getHitBox().y,this.getHitBox().width,this.getHitBox().height);
		for(Block block : getLevel().getBlocks.array()){
			if(Intersector.overlaps(collisionChecker, block.get())){
				posx = block.getRight();
				return;
			}
		}
		isMoving = true;
		posx -= distance;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TextureRegion getAnimationFrame() {
		// TODO Auto-generated method stub
		return currentFrame;
	}

	@Override
	public void hitWithProjectile(Projectile type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Thing get() {
		return this;
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return posx;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return posy;
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return getHitBox().width;
	}

	@Override
	public float getHeight() {
		return getHitBox().height;
	}
}
