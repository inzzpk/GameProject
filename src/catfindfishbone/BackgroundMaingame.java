package catfindfishbone;

import java.awt.Font;
import java.io.InputStream;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

public class BackgroundMaingame {

	private int x;
	private int y;
	private Image image;
	private Image imagetime;
	private Music music;
	public static TrueTypeFont font1, font2;
	private Image imagegameover;


	public BackgroundMaingame(int x, int y) throws SlickException {
		image = new Image("res/bgmainnnn.png");
		imagetime = new Image("res/bgmainnnntime.png");
		imagegameover = new Image("res/gameover.png");
		this.x = x;
		this.y = y;
		music = new Music("res/BGSound.wav");
		music.setVolume(0.1f);
		try {
			InputStream inputStream1 = ResourceLoader
					.getResourceAsStream("AGENCYB.TTF");
			InputStream inputStream2 = ResourceLoader
					.getResourceAsStream("AGENCYB.TTF");

			Font s1 = Font.createFont(Font.TRUETYPE_FONT, inputStream1);
			s1 = s1.deriveFont(40f); // set font size
			Font s2 = Font.createFont(Font.TRUETYPE_FONT, inputStream2);
			s2 = s2.deriveFont(50f); // set font size

			font1 = new TrueTypeFont(s1, false);
			font2 = new TrueTypeFont(s2, false);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void draw() {
		image.draw(x, y);

	}

	public void drawtime() {
		imagetime.draw(x, y);

	}

	public void play() {
		music.loop();

	}

	public void gameover() {
		imagegameover.draw();
		font2.drawString(220, 230, "Game Over", Color.orange);
	}
	
	public void gameoverbutton(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		Input input = container.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		System.out.println(xpos);
		System.out.println(ypos);
		if((xpos > 250) && (xpos < 390) && (ypos > 260) && (ypos < 325)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(3);
			}
		}
	}
	
	public void gameoverbuttontime(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		Input input = container.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		System.out.println(xpos);
		System.out.println(ypos);
		if((xpos > 250) && (xpos < 390) && (ypos > 260) && (ypos < 325)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(4);
			}
		}
	}
	

	public void timeandscore(int time, int score) {
		font1.drawString(510, 30, "" + score);
		font1.drawString(100, 30, "" + (60 + (time / 1000)));
	}

	public void timeandscore_time(int time, int score) {
		font1.drawString(510, 30, "" + score);
		font1.drawString(100, 30, "" + (time / 1000));
	}



}
