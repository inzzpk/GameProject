package catfindfishbone;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import catfindfishbone.Fishbone;
import catfindfishbone.Cat;


public class MainGameTime extends BasicGameState {

	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 640;
	private Fishbone fishbone;
	private Cat cat;
	private BackgroundMaingame bgmain;
	public static int score = 10;
	public static int time ;
	public static int leasttime = 1000000000 ; 
	public static boolean isGameOver = false;
	public static boolean isStarted = false;


	
	public MainGameTime(int state) {
//		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container,StateBasedGame sbg, Graphics g)
			throws SlickException {
		bgmain.drawtime();
		bgmain.timeandscore_time(time, score);
		cat.draw();
		// fishbone.draw();
		if(isGameOver == true){
			bgmain.gameover();
			bgmain.gameoverbuttontime(container, sbg);
		}

	}

	@Override
	public void init(GameContainer container,StateBasedGame sbg) throws SlickException {
		cat = new Cat(150, 100);
		fishbone = new Fishbone(100, 100);
		bgmain = new BackgroundMaingame(0, 0);
		bgmain.play();
	}

	void updateCatMovement(Input input, int delta) {
		if (input.isKeyDown(Input.KEY_LEFT)) {
			isStarted = true;
			cat.moveLeft(fishbone.getCenterX());
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			isStarted = true;
			cat.moveRight(fishbone.getCenterX());
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			isStarted = true;
			cat.moveDown(fishbone.getCenterY());
		}
		if (input.isKeyDown(Input.KEY_UP)) {
			isStarted = true;
			cat.moveUp(fishbone.getCenterY());
		}
		if (input.isKeyDown(Input.KEY_SPACE)) {
			isStarted = true;
			handleCollision(delta);
		}

	}
	
	
	void newGame(Input input, int delta) {
		if (input.isKeyDown(Input.KEY_S)) {
			isGameOver = false;
			time = 0;
			score = 10;
		}
	}

	private void handleCollision(int delta) {
		if (cat.closeTo(fishbone.getCenterX(), fishbone.getCenterY())) {
			fishbone.setPosition();
	//		leasttime();
			score -= 1;
		} else {
			time += 10;
		}

	}

	@Override
	public void update(GameContainer container,StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = container.getInput();
		newGame(input, delta);
		if (isGameOver == false) {
			updateCatMovement(input, delta);
			if (isStarted == true) {
				time += delta;
				if (score==0) {
					leasttime();
					isGameOver = true;
				}
			}
		}

	}
	
	public void leasttime(){
		if(leasttime > time){
			leasttime = time;
		}
	}

	public static void main(String[] args) {

	}


	@Override
	public int getID() {

		return 2;
	}

}
