package core;


public class Character {
	protected int x = 0, y = 0;
	
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
			y--;
			break;
		case down:
			y++;
			break;
		case right:
			x++;
			break;
		case left:
			x--;
			break;
		}
	}
}
