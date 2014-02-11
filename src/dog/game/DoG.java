package dog.game;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import dog.main.BasicInterface;

public class DoG extends BasicGameState implements BasicInterface  {

	//Map attributes
	private TiledMap map;
	
	private int mapRenderX; 
	private int mapRenderY;
	
	private int mapStartRenderX;
	private int mapStartRenderY; 
	
	private int mapEndRenderX;
	private int mapEndRenderY;
	
	//GameObjects
	private GameObject player;
	
	private ArrayList<GameObject> gObject = new ArrayList<GameObject>();
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		//Loading Tile Map
		this.map = new TiledMap("tiles/map.tmx");
		
		//Loading Game Objects
		SpriteSheet playerSheet = new SpriteSheet("tiles/MageAnim.png", 26, 18);
		Animation playerAnimation = new Animation(playerSheet, 500);
		player = new GameObject(playerAnimation, 26, 18, 0, 0, 0.01f, true);
		gObject.add(player);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		map.render(mapRenderX, mapRenderY, mapStartRenderX,  mapStartRenderY, mapEndRenderX, mapEndRenderY);
		
		for (GameObject obj : gObject) {
			obj.render();
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		//Input
		Input input = gc.getInput();
		
		//map render calculation
		this.mapRenderX = (int) player.getPosX() + 9  - 640; 
		this.mapRenderY = (int) player.getPosY() + 13 - 320;
		
		this.mapStartRenderX = (int) player.getPosX() + 9;
		this.mapStartRenderY = (int) player.getPosY() + 13;
		
		this.mapEndRenderX = ((this.mapStartRenderX + 1280) / 32) + 25;
		this.mapEndRenderY = ((this.mapStartRenderY + 720) / 32) + 20;
		
		//Input evaluation
		if		(input.isKeyDown(Input.KEY_W) && !input.isKeyDown(Input.KEY_A) && !input.isKeyDown(Input.KEY_S) && !input.isKeyDown(Input.KEY_D)) {
			player.setDirection(TOP);	
		}
		else if	(!input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_A) && !input.isKeyDown(Input.KEY_S) && !input.isKeyDown(Input.KEY_D)) {
			player.setDirection(LEFT);
		}
		else if	(!input.isKeyDown(Input.KEY_W) && !input.isKeyDown(Input.KEY_A) && input.isKeyDown(Input.KEY_S) && !input.isKeyDown(Input.KEY_D)) {
			player.setDirection(BOTTOM);
		}
		else if	(!input.isKeyDown(Input.KEY_W) && !input.isKeyDown(Input.KEY_A) && !input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_D)) {
			player.setDirection(RIGHT);
		}
		else if(input.isKeyDown(Input.KEY_ESCAPE))
			System.exit(0);
		else
			player.setDirection(8);
		
		for (GameObject obj : gObject) {
			obj.move(delta);
		}
		
	}

	@Override
	public int getID() {
		return DELUSION_OF_GRANDEUR_STATE;
	}

}
