package core;

import enums.CellTypes;
import enums.Directions;


public class Character {
	private Map map;
	protected int x = 0, y = 0;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	private void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Map getMap() {
		return map;
	}
	
	public Character(Map map) {
		this.map = map;
	}
	
	protected Directions direction;
	
	protected void move(Directions direction) {
		this.direction = direction;
		Cell nextcell = null;
		
		switch(direction) {
		case up:
			nextcell = map.getCell(getX(), getY() - 1);
			
			break;
		case down:
			nextcell = map.getCell(getX(), getY() + 1);
			
			break;
		case right:
			nextcell = map.getCell(getX() + 1, getY());
			
			break;
		case left:
			nextcell = map.getCell(getX() - 1, getY());
			
			break;
		}
		
		if(nextcell.getType() != CellTypes.UnWalkable) {
			move(nextcell.getX(), nextcell.getY());
		}
		
		if(nextcell.getType() == CellTypes.Teleporter) {
			//TODO Teleport to next map
		}
	}
}
