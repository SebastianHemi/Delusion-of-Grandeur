package dog.game_old;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


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
			
			//fps
//			app.setTargetFrameRate(240);
			//Starten
			app.start();	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new DelusionOfGrandeur("title"));
	}
}
