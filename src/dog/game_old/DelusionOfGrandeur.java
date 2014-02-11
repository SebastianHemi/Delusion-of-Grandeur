package dog.game_old;

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

import dog.game_old.GameObject;
import dog.game_old.PlayerObject;


public class DelusionOfGrandeur extends BasicGameState implements BasicInterface {
	
	private TiledMap map1;
//	private Camera cam;
	
	private PlayerObject player;
	private Animation playerAnim;
	private float playerSpeed;

//	private EnemyObject enemy;
//	private Animation enemyAnim;
//	private float enemySpeed;
	
	private ArrayList<GameObject> gObject = new ArrayList<GameObject>();
	
//	private boolean first = true;
//	private int i = 100;
	
	public DelusionOfGrandeur(String title) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		
		map1 = new TiledMap("tiles\\map.tmx");
		
//		cam = new Camera(gc, map1);
		
		//mage animation
		SpriteSheet mageSheet = new SpriteSheet("tiles\\MageAnim.png", 18, 26);
		playerAnim = new Animation(mageSheet, 500);
		player = new PlayerObject(this, playerAnim, 18, 26, 50, 58);
		playerSpeed = 0.02f;
		gObject.add(player);
		
		//enemy animation
//		SpriteSheet enemySheet = new SpriteSheet("tiles\\MageAnim.png", 18, 26);
//		enemyAnim = new Animation(enemySheet, 500);
//		enemy = new EnemyObject(this, enemyAnim, 18, 26, 50, 58);
//		enemySpeed = 0.05f;
		
//		sgObject.add(enemy);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {

		int renderX = (int) player.getPosX() + 9  - 640; 
		int renderY = (int) player.getPosY() + 13 - 320;
		
		int startRenderX = (int) player.getPosX() + 9;
		int startRenderY = (int) player.getPosY() + 13;
		
		int endRenderX = ((startRenderX + 1280) / 32) + 25;
		int endRenderY = ((startRenderY + 720) / 32) + 20;
			
		map1.render(renderX, renderY, startRenderX, startRenderY, endRenderX, endRenderY);
		
//		cam.drawMap((int)player.getPosX() - 70, (int)player.getPosY() - 70);
		
		g.drawAnimation(playerAnim, 640, 320);
		
//		if(first){
//			enemy.setPosY(((player.getPosY() - cam.getCameraY()) + 100));
//			enemy.setPosX(((player.getPosX() - cam.getCameraX()) + 100));
//			g.drawAnimation(enemyAnim, enemy.getPosX(), enemy.getPosY());
//			cam.centerOn((int)player.getPosX(),(int)player.getPosY());
//		
//			first = false;
//		}
//		else{
//			enemy.setPosX(enemy.getPosX() + i);
//			enemy.setPosY(enemy.getPosY() + i);
//			g.drawAnimation(enemyAnim, enemy.getPosX(), enemy.getPosY());
//		}
		
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		
		Input in = gc.getInput();

		player.setDeltaX(0.0f);
		player.setDeltaY(0.0f);
		
//		enemy.setDeltaX(0.0f);
//		enemy.setDeltaY(0.0f);
		
//		rand();
		
//		enemy.setDeltaX(enemySpeed);
//		System.out.println(enemy.getPosX() + "    " + enemy.getPosY());

		if (in.isKeyDown(Input.KEY_A) && !in.isKeyDown(Input.KEY_D)) {
			player.setDeltaX(- playerSpeed);
//			enemy.setDeltaX(playerSpeed * delta);
		}
		if (in.isKeyDown(Input.KEY_D) && !in.isKeyDown(Input.KEY_A)) {
			player.setDeltaX( playerSpeed);
//			enemy.setDeltaX(-playerSpeed * delta);
		}
		if (in.isKeyDown(Input.KEY_S) && !in.isKeyDown(Input.KEY_W)) {
			player.setDeltaY( playerSpeed);
//			enemy.setDeltaY(-playerSpeed * delta);
		}
		if (in.isKeyDown(Input.KEY_W) && !in.isKeyDown(Input.KEY_S)) {
			player.setDeltaY(- playerSpeed);
//			enemy.setDeltaY(playerSpeed * delta);
		}
		if (in.isKeyPressed(Input.KEY_ESCAPE)) {
			System.exit(0);
		}
		
		for (GameObject gObj : gObject) {
			gObj.move(delta);
		}
		
	}
	
//	public int rand(){
//		
//		boolean pn;
//		
//		Random r = new Random();
//		
//		pn = r.nextBoolean();
//		i=1;
//		
//		if(pn){
//			return i;
//		}
//		else{
//			return -i;
//		}
//	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return GAME_STATE;
	}
	
}