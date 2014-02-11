package dog.game_old;
import org.newdawn.slick.Animation;

import dog.game_old.GameObject;

public class PlayerObject extends GameObject{

	private Animation player;
	
	public PlayerObject(DelusionOfGrandeur game, Animation anim, int width, int height, float posX, float posY) {
		super(game, width, height, posX, posY);
		
		player= anim;
	}

	public void render(){
		player.draw(posX, posY, player.getWidth(), player.getHeight());
	}
	
	@Override
	public void move(float delta){

		
		super.move(delta);		
		

//		if(game.isBlocked(posX+(deltaX*delta), posY+(deltaY*delta))){
//			
//			posX+=deltaX;
//			posY+=deltaY;
//			super.move(delta);
//		}
//		else{
//
//		}
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub
		
	}
	
	
}
