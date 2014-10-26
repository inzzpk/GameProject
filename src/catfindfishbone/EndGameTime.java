package catfindfishbone;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class EndGameTime extends BasicGameState {
	

	private Image bgimagetime;

	public EndGameTime(int state){
	
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		bgimagetime = new Image("res/endgametime.png");
		bgimagetime.draw();
		BackgroundMaingame.font2.drawString(300, 380, ""+ (MainGameTime.time)/1000);
		BackgroundMaingame.font1.drawString(380, 470, ""+ (MainGameTime.leasttime)/1000);
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
				NewGameMainGameTime();
				sbg.enterState(2);
				
			}
		}
		if((xpos > 335) && (xpos < 535) && (ypos > 40) && (ypos < 100)){
			if(input.isMouseButtonDown(0)){
				NewGameMainGameTime();
				sbg.enterState(0);
			}
		}
		
	}
	
	public void NewGameMainGameTime(){
		MainGameTime.isGameOver = false;
		MainGameTime.isStarted = false;
		MainGameTime.time = 00;
		MainGameTime.score = 10;
	}
	
	

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 4;
	}
	

}
