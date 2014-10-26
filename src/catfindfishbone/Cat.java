package catfindfishbone;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Cat {

	private Image image;
	private Image cat;
	public static final int WIDTH = 150;
	public static final int HEIGHT = 100;
	public static final int COLORMAX = 128;
	private int x;
	private int y;
	private int colorsx;
	private int colorsy;
	private Sound sound;

	public Cat(int x, int y) throws SlickException {
		cat = new Image("res/cat.png");
		image = new Image("res/cat-nose1.png");
		this.x = x;
		this.y = y;
		sound = new Sound("res/Bonus.wav");
	}

	public void draw() {
		cat.draw(x, y);
		Color color = new Color(0, 0, 0);
		color = new Color((colorsx + colorsy), 0, 0);
		image.draw(x, y, color);

	}

	public void moveLeft(int fishbonex) {
		if ((x >= 0)) {
			colorsx = COLORMAX;
			x -= 1;
			colorsx = colorsx - (Math.abs(x - fishbonex));

		}

	}

	public void moveRight(int fishbonex) {
		if ((x <= MainGame.GAME_WIDTH - WIDTH)) {
			colorsx = COLORMAX;
			x += 1;
			colorsx = colorsx - (Math.abs(x - fishbonex));
		}
	}

	public void moveDown(int fishboney) {
		if ((y <= MainGame.GAME_HEIGHT - HEIGHT)) {
			colorsy = COLORMAX;
			y += 1;
			colorsy = colorsy - (Math.abs(y - fishboney));
		}

	}

	public void moveUp(int fishboney) {
		if ((y >= 0)) {
			colorsy = COLORMAX;
			y -= 1;
			colorsy = colorsy - (Math.abs(y - fishboney));
		}
	}

	public boolean closeTo(int fishbonex, int fishboney) {
		if ((fishbonex >= this.x - (WIDTH / 2))
				&& (fishbonex <= this.x + (WIDTH / 2))
				&& (fishboney >= this.y - (HEIGHT / 2))
				&& (fishboney <= this.y + (HEIGHT / 2))) {
			colorsx = 0;
			colorsy = 0;
			draw();
			sound.play(1f,0.8f);
			return true;
		} else
			return false;
	}

}
