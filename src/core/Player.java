package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

public class Player extends Character implements KeyListener, Component {
	public static final String uppicturepath = "res/pic/player/up.png";
	public static final String downpicturepath = "res/pic/player/down.png";
	public static final String leftpicturepath = "res/pic/player/left.png";
	public static final String rightpicturepath = "res/pic/player/right.png";
	private static final Color transparentcolor = new Color(0, 255, 0, 255);
	private Image uppicture = null, downpicture = null, rightpicture = null, leftpicture = null, picturetodraw = null;
	private Boolean acceptinginput = null;
	private Input input = null;
	
	public Player(GameContainer container, Map map) throws SlickException {
		super(map);
		
		setInput(container.getInput());
		
		uppicture = new Image(uppicturepath);
		downpicture = new Image(downpicturepath);
		rightpicture = new Image(rightpicturepath);
		leftpicture = new Image(leftpicturepath);
		picturetodraw = downpicture;
		
		x = 8;
		y = 8;
		
		direction = direction.down;
		
		//inputStarted();
	}

	@Override
	public void inputEnded() {
		acceptinginput = false;
	}

	@Override
	public void inputStarted() {
		acceptinginput = true;
	}

	@Override
	public boolean isAcceptingInput() {
		return acceptinginput;
	}

	@Override
	public void setInput(Input arg0) {
		input = arg0;
	}

	@Override
	public void keyPressed(int arg0, char arg1) {
		switch(arg0) {
		case Input.KEY_UP:
			move(Direction.up);
			break;
		case Input.KEY_DOWN:
			move(Direction.down);
			break;
		case Input.KEY_RIGHT:
			move(Direction.right);
			break;
		case Input.KEY_LEFT:
			move(Direction.left);
			break;
		}
	}

	@Override
	public void keyReleased(int arg0, char arg1) {
		
	}
	@Override
	public void update(int dt) {
		Image temp = null;
		
		switch(direction) {
		case down:
			temp = downpicture;
			break;
		case left:
			temp = leftpicture;
			break;
		case right:
			temp = rightpicture;
			break;
		case up:
			temp = uppicture;
			break;
		default:
			break;
		}
		
		picturetodraw = temp;
	}
	
	@Override
	public void draw(Graphics arg0) {
		picturetodraw.draw(getX() * getMap().getSquareW(), getY() * getMap().getSquareH(), getMap().getSquareW(), getMap().getSquareH());
		//arg0.drawImage(picturetodraw, x * Map.squarew, y * Map.squareh, Map.squarew, Map.squareh);
	}
}
