package dog.charmenu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import dog.main.BasicInterface;

public class DogCharmenu extends BasicGameState implements BasicInterface {

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.drawString("CHAR", 300, 300);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		Input in = gc.getInput();
		
		if(in.isKeyPressed(Input.KEY_ESCAPE))
			System.exit(0);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return CHARMENU_STATE;
	}

}
