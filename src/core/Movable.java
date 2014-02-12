package core;


public interface Movable extends Component {
	public int getX();
	public int getY();
	
	public void goUp();
	public void goDown();
	public void goRight();
	public void goLeft();
}
