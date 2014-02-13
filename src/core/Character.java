package core;


public class Character {
	private Map map;
	protected int x = 0, y = 0;
	
	public Character(Map map) {
		this.map = map;
	}
	
	public enum Direction {
		up,
		down,
		right,
		left
	}
	
	protected Direction direction;
	
	protected void move(Direction direction) {
		this.direction = direction;
		
		switch(direction) {
		case up:
			if(map.getCell(x, y - 1).isWalkable()) {
				y--;
			}
			
			break;
		case down:
			if(map.getCell(x, y + 1).isWalkable()) {
				y++;
			}
			
			break;
		case right:
			if(map.getCell(x + 1, y).isWalkable()) {
				x++;
			}
			
			break;
		case left:
			if(map.getCell(x - 1, y).isWalkable()) {
				x--;
			}
			
			break;
		}
	}
}
