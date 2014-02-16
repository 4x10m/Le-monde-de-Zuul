package core;

import org.newdawn.slick.Graphics;

public class CommonCell extends Cell {
	private Item item = null;
	
	public Boolean hasItem() {
		return item != null;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	public CommonCell(int x, int y) {
		super(x, y);
	}
	public CommonCell(Item item, int x, int y) {
		super(x, y);
		
		this.item = item;
	}
	
	public Item giveItem() {
		Item value = item;
		
		item = null;
		
		return value;
	}
	
	@Override
	public void draw(Graphics arg0, int w, int h) {
		super.draw(arg0, w, h);
		
		if(hasItem()) {
			getItem().draw(arg0, getX() * w, getY() * h, w, h);
		}
	}
}
