package catfindfishbone;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
	
	private Image bgimage;
	private Image buttonimage;
	
	public Menu(int state){
	
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		bgimage = new Image("res/menu.png");
		bgimage.draw();
		buttonimage = new Image("res/button3.png");
		buttonimage.draw(220, 330);
		buttonimage = new Image("res/button4.png");
		buttonimage.draw(220, 430);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = container.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		if((xpos > 220) && (xpos < 420) && (ypos > 260) && (ypos < 300)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1);
			}
		}
		if((xpos > 220) && (xpos < 420) && (ypos > 160) && (ypos < 200)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(2);
			}
		}	
	}
	

	@Override
	public int getID() {
		return 0;
	}
	

}
