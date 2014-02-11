package core;

import types.Component;
import types.Movable;

public class Character extends Movable {
	public enum Direction {
		up,
		down,
		right,
		left
	}
	
	private Direction direction;
	
	private void move(Direction direction) {
		this.direction = direction;
		
		switch(direction) {
		case up:
			setX(x-1);
		case down:
			setX(x+1);
		case right:
			setY(y-1);
		case left:
			setY(y++);
		}
	}
	
	public Character(int x, int y) {
		super(x, y);
	}

	@Override
	void update(int dt) {

	}

	@Override
	void draw() {
		
	}
}
