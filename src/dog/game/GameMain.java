package dog.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import dog.main.BasicInterface;

public class GameMain extends StateBasedGame implements BasicInterface {

	public GameMain(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gamecon) throws SlickException {
		addState(new DoG());
	}
	
	public static void main(String[] args) {	
		try {
			
			//Initialisieren
			AppGameContainer app = new AppGameContainer(new GameMain("Delusion of Grandeur"));
			
			//Configure
			app.setDisplayMode(1280, 720, false);
			
			//Starten
			app.start();	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
