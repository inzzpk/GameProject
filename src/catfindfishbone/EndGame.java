package catfindfishbone;


import org.lwjgl.input.Mouse;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class EndGame extends BasicGameState {
	
	private Image bgimage;


	public EndGame(int state){
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		bgimage = new Image("res/endgame.png");
		bgimage.draw();
		BackgroundMaingame.font2.drawString(300, 380, ""+ MainGame.score);
		BackgroundMaingame.font1.drawString(380, 470, ""+ MainGame.highscore);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = container.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		System.out.println(xpos);
		System.out.println(ypos);
		if((xpos > 95) && (xpos < 285) && (ypos > 40) && (ypos < 100)){
			if(input.isMouseButtonDown(0)){
				NewGameMainGame();
				sbg.enterState(1);
			}
		}
		if((xpos > 335) && (xpos < 535) && (ypos > 40) && (ypos < 100)){
			if(input.isMouseButtonDown(0)){
				NewGameMainGame();
				sbg.enterState(0);
			}
		}
		
	}
	
	public void NewGameMainGame(){
		MainGame.isGameOver = false;
		MainGame.isStarted = false;
		MainGame.time = 60;
		MainGame.score = 0;
	}
	

	@Override
	public int getID() {
		return 3;
	}
	

}
