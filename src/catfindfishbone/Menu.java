package catfindfishbone;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
	
	public Menu(int state){
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.fillOval(75, 100, 100, 100);
		g.drawString("Play Now!", 80, 70);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = container.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		System.out.println(xpos);
		System.out.println(ypos);
		if((xpos > 75) && (xpos < 175) && (ypos > 440) && (ypos < 540)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1);
			}
		}
		
		
	}
	

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
