package dog.game_old;
import org.newdawn.slick.geom.Rectangle;


public abstract class GameObject {

	protected DelusionOfGrandeur game;
	protected int width;		//höhe und breite
	protected int height;		//des sprites
	protected float posX;		//x und y position
	protected float posY;		//des sprites
	protected float deltaX;	//wie weit sich das sprite
	protected float deltaY;	//bewegt, in x-y richtung
	protected boolean alive;	//ob das sprite gezeichnet wird
	
	
	public GameObject(DelusionOfGrandeur game, int width, int height, float posX, float posY){
		
		this.game = game;
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
		this.deltaX = 0;
		this.deltaY = 0;
		this.alive = true;
	}
	

	public void move(float delta){
		//delta ist vergangene zeit
		posX += deltaX*delta;
		posY += deltaY*delta;
//		if(delta<0){
//			delta=delta-2*delta;
//		}
		
	}
	
	public abstract void render();
	
	public abstract void doLogic();
	
	public boolean collidesWith(GameObject other){
		
		Rectangle r = new Rectangle(posX, posY, width, height);
		System.out.println(posX + posY + width + height);
		Rectangle o = new Rectangle(other.getPosX(), other.getPosY(), other.getWidth(), other.getHeight());
		System.out.println(other.getPosX() + other.getPosY() + other.getWidth() + other.getHeight());
		
		return (r.intersects(o));
	}
	
	
	public float getDeltaX() {
		return deltaX;
	}

	public void setDeltaX(float deltaX) {
		this.deltaX = deltaX;
	}

	public float getDeltaY() {
		return deltaY;
	}

	public void setDeltaY(float deltaY) {
		this.deltaY = deltaY;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public float getPosX() {
		return posX;
	}
	
	public void setPosX(float posX){
		this.posX = posX;
	}

	public void setPosY(float posY){
		this.posY = posY;
	}

	public float getPosY() {
		return posY;
	}


	
	
}
