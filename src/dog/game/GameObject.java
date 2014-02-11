package dog.game;

import org.newdawn.slick.Animation;

import dog.main.BasicInterface;

public class GameObject implements BasicInterface {
	private Animation objectAnim;	//animation of sprite
	
	//0 ... left
	//1 ... left top
	//2 ... top
	//3 ... top right
	//4 ... right
	//5 ... bottom right
	//6 ... bottom
	//7 ... bottom left
	//8 ... no direction
	private int direction;
	
	private int width;				//width of sprite animation
	private int height;				//height of sprite animation
	
	private float posX;				//x position of sprite
	private float posY;				//y position of sprite
	
	private float objectSpeed;		//mobing speed from object
	
	private boolean alive;			//should the object be renderd

	public GameObject(Animation objectAnim, int width, int height, float posX, float posY, float objectSpeed, boolean alive) {
		this.objectAnim = objectAnim;
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
		this.objectSpeed = objectSpeed;
		this.alive = alive;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Animation getObjectAnim() {
		return objectAnim;
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

	public float getPosY() {
		return posY;
	}

	public float getObjectSpeed() {
		return objectSpeed;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void render() {
		objectAnim.draw(this.posX, this.posY);
	}
	
	public void move(int delta) {
		switch(direction) {
			case LEFT:
				posX -= objectSpeed * delta;
				break;
			case LEFT_TOP:
				posY -= objectSpeed * delta;
				posX -= objectSpeed * delta;
				break;
			case TOP:
				posY -= objectSpeed * delta;
				break;
			case TOP_RIGHT:
				posY -= objectSpeed * delta;
				posX += objectSpeed * delta;
				break;
			case RIGHT:
				posX += objectSpeed * delta;
				break;
			case BOTTOM_RIGHT:
				posY += objectSpeed * delta;
				posX += objectSpeed * delta;
				break;
			case BOTTOM:
				posY += objectSpeed * delta;
				break;
			case BOTTOM_LEFT:
				posY += objectSpeed * delta;
				posX -= objectSpeed * delta;
				break;
			case NONE:
		}
	}
}
