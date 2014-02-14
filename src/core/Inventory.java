package core;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Inventory {
	public static final String backgroundpath = "res/pic/ath/inventorybackground.png";
	private final Image backgroundpicture;
	public static final int w = 100, h = 50;
	private int x = 0, y = 0;
	
	private void setX(int x) {
		this.x = x;
	}
	
	private void setY(int y) {
		this.y = y;
	}
	
	public Inventory(GameContainer container) throws SlickException {
		setX(container.getWidth() - w);
		setY(container.getHeight() - h);
		
		backgroundpicture = new Image(backgroundpath);
	}

	public void draw(Graphics arg0) {
		backgroundpicture.draw(x, y, w, h);
		
	}
}
