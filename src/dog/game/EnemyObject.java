package dog.game;

import org.newdawn.slick.Animation;

public class EnemyObject extends GameObject{
	
	private Animation enemy;

	public EnemyObject(DelusionOfGrandeur game, Animation anim, int width, int height,
			float posX, float posY) {
		super(game, width, height, posX, posY);
		
		enemy=anim;
	}

	public void render() {
		enemy.draw(posX, posY, enemy.getWidth(), enemy.getHeight());
	}
	
	@Override
	public void move(float delta){
		
//		posX += delta;
//		posY += delta;
		
		super.move(delta);	
	}
	
//	@Override
//	public void setPosX(float posX){
//		this.posX += posX;
//	}
//
//	@Override
//	public void setPosY(float posY){
//		this.posY += posY;
//	}

	@Override
	public void doLogic() {

	}

}
