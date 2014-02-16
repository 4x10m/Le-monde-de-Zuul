package core;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.util.xml.XMLElement;

public class Item {
	private final int level;
	private final int x, y;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	private Item(int level, int x, int y) {
		this.level = level;
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics arg0, int x, int y, int w, int h) {
		arg0.setColor(Levels.getLevelColor(level));
		arg0.fillOval(x, y, w, h);
	}
	
	public static Item loadItem(XMLElement element) {
		Item item = null;
		int level = 0, x = 0, y = 0;
		
		if(element.getName() == "item") {
			level = Integer.parseInt(element.getAttribute("level"));
			x = Integer.parseInt(element.getAttribute("x"));
			y = Integer.parseInt(element.getAttribute("y"));
			
			item = new Item(level, x, y);
		}
		
		return item;
	}
}
