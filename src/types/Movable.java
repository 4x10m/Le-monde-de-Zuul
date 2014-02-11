package types;

public class Movable extends Component {
	protected int x, y;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Movable(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void goUp() {
		y--;
	}
	
	public void goDown() {
		y++;
	}
	
	public void goRight() {
		x++;
	}
	
	public void goLeft() {
		x--;
	}

	@Override
	void update(int dt) {
	}

	@Override
	void draw() {
	}
}
