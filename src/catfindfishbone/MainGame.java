package catfindfishbone;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import catfindfishbone.Fishbone;
import catfindfishbone.Cat;
import catfindfishbone.MainGame;

public class MainGame extends BasicGame {

	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 640;
	private Fishbone fishbone;
	private Cat cat;
	private BackgroundMaingame bgmain;
	private int score;
	private int time;
	private boolean isGameOver = false;
	private boolean isStarted = false;
	private int button;

	public MainGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		bgmain.draw();
		bgmain.timeandscore(time, score);
		cat.draw();
		// fishbone.draw();
		if(isGameOver == true)
			bgmain.gameover();

	}

	@Override
	public void init(GameContainer container) throws SlickException {
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
	//	if (input.isMouseButtonDown(button)){
			
	//	}
	}
	
	
	void newGame(Input input, int delta) {
		if (input.isKeyDown(Input.KEY_S)) {
			isGameOver = false;
			time = 60;
			score = 0;
		}
	}

	private void handleCollision(int delta) {
		if (cat.closeTo(fishbone.getCenterX(), fishbone.getCenterY())) {
			fishbone.setPosition();
			score += 10;
			time += 5000;
		} else {
			time -= 10;

		}

	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		Input input = container.getInput();
		newGame(input, delta);
		if (isGameOver == false) {
			updateCatMovement(input, delta);
			if (isStarted == true) {
				time -= delta;
				if (60 + (time / 1000) <= 0) {
					isGameOver = true;
				}
			}
		}

	}

	public static void main(String[] args) {
		try {
			MainGame game = new MainGame("Cat Find Fishbone");
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
