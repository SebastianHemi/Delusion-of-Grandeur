package dog.main;

public interface BasicInterface {
	public static Integer LOGIN_STATE = 0;
	public static Integer GAME_STATE = 1;
	public static Integer CHARMENU_STATE = 2;
	
	public static Integer DELUSION_OF_GRANDEUR_STATE = 3;
	
	//Movement
	public static int LEFT			= 0;
	public static int LEFT_TOP		= 1;
	public static int TOP			= 2;
	public static int TOP_RIGHT		= 3;
	public static int RIGHT			= 4;
	public static int BOTTOM_RIGHT	= 5;
	public static int BOTTOM		= 6;
	public static int BOTTOM_LEFT	= 7;
	public static int NONE			= 8;
}
