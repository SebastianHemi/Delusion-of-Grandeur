package dog.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.TextField;

import dog.main.BasicInterface;
import dog.rmi.DoGInterface;

public class DogLogin extends BasicGameState implements BasicInterface {
	
	//RMI CONNECTION
	private Registry reg;
	
	//BACKGROUND STUFF
	private Image bgImage;
	private Image loginBgImage;
	private Image loginHeader;
	private Image loginHeadline;
	private Image loginButton;
	private Image leftAnim;
	
	private String userLabel;
	private String pwdLabel;
	
	private float rotation;
	
	//FONT 
	private UnicodeFont uFont = null;
	private String fontPath = "data/fonts/a.ttf";
	
	private UnicodeFont pwdFont = null;
	private String pwdPath = "data/fonts/b.ttf";
	
	//TEXTFIELDS
	private TextField userTextField;
    private TextField pwdTextField;
    
    //USER CHECK
    private String errorOutput;

	@SuppressWarnings("unchecked")
	@Override
	public void init(GameContainer gamecon, StateBasedGame game) throws SlickException {
		
		//RMI SERVER CONNECTION
		try {
			
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File("config/server.properties")));
			Integer port = new Integer(prop.getProperty("port"));
			this.reg = LocateRegistry.getRegistry("localhost", port);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//USER CHECK VARIABLE INITIALISIATION
		errorOutput = "";
		
		//BACKGROUND STUFF
		bgImage = new Image("data/img/bg.png");
		loginBgImage = new Image("data/img/loginbg.png");
		loginHeader = new Image("data/img/loginheader.png");
		loginHeadline = new Image("data/img/loginheadline.png");
		loginButton = new Image("data/img/loginbutton.png");
		leftAnim = new Image("data/img/comp.png");
		
		userLabel = "USER";
		pwdLabel = "PASSWORD";
		
		//FONT INITIALISEREN
		uFont = new UnicodeFont(fontPath, 16, false, false);
        uFont.addAsciiGlyphs();   											//Add Glyphs
        uFont.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
        uFont.loadGlyphs();  												//Load Glyphs
        
        pwdFont = new UnicodeFont(pwdPath, 13, false, false);
        pwdFont.addAsciiGlyphs();   										//Add Glyphs
        pwdFont.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
        pwdFont.loadGlyphs();  												//Load Glyphs
        pwdFont.setPaddingTop(-7);
        
        //TEXTFIELD INITIALISEREN
        userTextField = 	new TextField(gamecon, uFont,   440, 320, 400, 30);
        userTextField.setBorderColor(Color.transparent);
        
        pwdTextField = 		new TextField(gamecon, pwdFont, 440, 390, 400, 30);
        pwdTextField.setBorderColor(Color.transparent);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		
		//BACKGROUND
		g.setFont(uFont);
		
		g.drawImage(bgImage, 0, 0);
		
		g.drawImage(leftAnim, 700, -600);
		
		g.drawImage(loginBgImage, 431, 235);
		g.drawImage(loginHeader, 431, 235);
		g.drawImage(loginHeadline, 431, 235);
		
		g.drawImage(loginButton, 600, 440);
		
		g.drawString(userLabel, 440, 300);
		g.drawString(pwdLabel, 440, 370);
		
		//TEXTFIELD
		userTextField.render(gc, g);
		pwdTextField.render(gc, g);
		
		//USER CHECK
		g.setColor(Color.red);
		g.drawString(errorOutput, 5, 700);
		g.setColor(Color.white);
		
	}

	@Override
	public void update(GameContainer gamecon, StateBasedGame game, int delta) throws SlickException {
		Input in = gamecon.getInput();
		
		if (in.isKeyPressed(Input.KEY_ENTER)) {
			
			String user = userTextField.getText();
			String pwd = pwdTextField.getText();
			
			if(!user.equals("") && !pwd.equals("")) {
				
				//INFO AN RMI SENDEN
				try {
					
					DoGInterface login = (DoGInterface) reg.lookup("login");
					if(login.login(user, pwd)) {
						
						errorOutput = "";
						
						//ENTER NEXT GAME STATE
						game.enterState(CHARMENU_STATE);
						
					}
					else
						errorOutput = "USER OR PASSWORD WRONG!";
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else
				errorOutput = "USERFIELD OR/AND PASSWORDFIELD IS/ARE EMPTY!";
			
		}

		if(in.isKeyPressed(Input.KEY_ESCAPE))
			System.exit(0);
		
		if(rotation < 360)
			rotation += 0.009f * delta;
		else
			rotation = 0;
		
		leftAnim.setCenterOfRotation(leftAnim.getWidth() / 2, leftAnim.getHeight() / 2);
		leftAnim.setRotation(rotation);
	}

	@Override
	public int getID() {
		return LOGIN_STATE;
	}

}
