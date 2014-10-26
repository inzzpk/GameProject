package catfindfishbone;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Game extends StateBasedGame {
	
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 640;
	public static final String GameName = "catfindfishbone";
	public static final int menu = 0;
	public static final int maingame = 1;
	public static final int maingametime = 2;
	public static final int endgame = 3;
	public static final int endgametime = 4;
	private static String gamename;

	public Game(String GameName){
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new MainGame(maingame));
		this.addState(new MainGameTime(maingametime));
		this.addState(new EndGame(endgame));
		this.addState(new EndGameTime(endgametime));
	}


	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(menu).init(container, this);
		this.getState(maingame).init(container, this);
		this.getState(maingametime).init(container, this);
		this.getState(endgame).init(container, this);
		this.getState(endgametime).init(container, this);
		this.enterState(menu);
		
	}
	
	public static void main(String[] args) {
		try {
			Game game = new Game("Cat Find Fishbone");
			AppGameContainer container = new AppGameContainer(game);
			container.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			//container.setMinimumLogicUpdateInterval(800 / 60);
			container.setShowFPS(false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}


}
