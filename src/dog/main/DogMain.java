package dog.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import dog.charmenu.DogCharmenu;
import dog.login.DogLogin;

public class DogMain extends StateBasedGame implements BasicInterface {

	public DogMain(String name) {
		super(name);
	}
	
	public static void main(String[] args) {	
		try {
			
			//Initialisieren
			AppGameContainer app;
			app = new AppGameContainer(new DogMain("Delusion of Grandeur"));
			
			//Configure
			app.setDisplayMode(1280, 720, false);
			//app.setTargetFrameRate(60);
			app.setShowFPS(false);
			
			//Starten
			app.start();	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new DogLogin());
		addState(new DogCharmenu());
	}
}
