package core;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import core.Item;

public class Inventory {
	public static final String backgroundpath = "res/pic/ath/inventorybackground.png";
	
	private final Image backgroundpicture;
	
	public static final int w = 100, h = 50;
	
	private int x = 0, y = 0;
	private Item[] items = null;
	
	private void setX(int x) {
		this.x = x;
	}
	
	private void setY(int y) {
		this.y = y;
	}
	
	public void appendItem(Item item) {
		for(int i = 0; i < items.length; i++) {
			if(items[i] == null) {
				items[i] = item;
				
				break;
			}
		}
	}
	
	public Inventory(GameContainer container) throws SlickException {
		setX(container.getWidth() - w);
		setY(container.getHeight() - h);
		
		backgroundpicture = new Image(backgroundpath);
		
		items = new Item[Levels.getNumberOfLevel()];
	}

	public void draw(Graphics arg0) {
		backgroundpicture.draw(x, y, w, h);
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				items[i].draw(arg0, x + i * 40, y + 20, 30, 20);
			}
		}
		
	}

	public boolean contains(int level) {
		if(items[level] != null) {
			
			return true;
		}
		
		return false;
	}
}
