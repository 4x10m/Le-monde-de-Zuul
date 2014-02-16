package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

import states.Play;
import enums.CellTypes;
import enums.Directions;

public class Player implements KeyListener {
	public static final String uppicturepath = "res/pic/player/up.png";
	public static final String downpicturepath = "res/pic/player/down.png";
	public static final String leftpicturepath = "res/pic/player/left.png";
	public static final String rightpicturepath = "res/pic/player/right.png";
	public static final int updateinterval = 100;
	
	private final Image uppicture, downpicture, rightpicture, leftpicture;
	
	private final Inventory inventory;
	private Map map;
	
	private Directions direction;
	private Image picturetodraw = null;
	private int x = 0, y = 0, actualtime = 0, nextmapid =0;
	private Boolean keypressed = null, onteleporter = null;
	
	private Boolean acceptinginput = null;
	private Input input = null;
	
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
	private Input getInput() {
		return input;
	}
	
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
	
	public void addTime(int i) {
		actualtime += i;
		
		if(actualtime >= updateinterval) {
			updatePosition();
			
			actualtime = 0;
		}
	}

	public Player(Input input, Map map, Inventory inventory) throws SlickException {
		this.input = input;
		this.map = map;
		this.inventory = inventory;
		
		uppicture = new Image(uppicturepath);
		downpicture = new Image(downpicturepath);
		rightpicture = new Image(rightpicturepath);
		leftpicture = new Image(leftpicturepath);
		
		picturetodraw = downpicture;
		direction = direction.down;
		
		x = map.getW() / 2;
		y = map.getH() / 2;
		
		keypressed = false;
		onteleporter = false;
	}

	@Override
	public void keyPressed(int arg0, char arg1) {
		if(!keypressed) {
			switch(arg0) {
			case Input.KEY_UP:
				keypressed = true;
				direction = Directions.up;
				
				break;
				
			case Input.KEY_DOWN:
				keypressed = true;
				direction = Directions.down;
				
				break;
				
			case Input.KEY_RIGHT:
				keypressed = true;
				direction = Directions.right;
				
				break;
				
			case Input.KEY_LEFT:
				keypressed = true;
				direction = Directions.left;
				
				break;
				
			case Input.KEY_SPACE:
				takeItem();
				
				break;
			}
		}
	}
	
	@Override
	public void keyReleased(int arg0, char arg1) {
		if(keypressed) {
			switch(arg0) {
			case Input.KEY_UP:
				keypressed = false;
				
				break;
				
			case Input.KEY_DOWN:
				keypressed = false;
				
				break;
				
			case Input.KEY_RIGHT:
				keypressed = false;
				
				break;
				
			case Input.KEY_LEFT:
				keypressed = false;
				
				break;
			}
		}
	}
	
	private Cell getNextCell() {
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
		
		return nextcell;
	}
	
	private void takeItem() {
		Cell nextcell = null;
		CommonCell transformedcell = null;
		Item item = null;
		
		nextcell = getNextCell();
		
		if(nextcell instanceof CommonCell) {
			transformedcell = (CommonCell) nextcell;
			
			if(transformedcell.hasItem()) {
				item = transformedcell.giveItem();
				
				inventory.appendItem(item);
			}
		}
	}
	
	
	private void updatePosition() {
		Cell nextcell = null;
		CommonCell nextcommoncell = null;
		Teleporter teleportercell = null;
		
		if(onteleporter) {
			teleportercell = (Teleporter) map.getCell(getX(), getY());
			
			map = Play.loadMap(nextmapid);
			
			onteleporter = false;
			
			move(teleportercell.getRelatedMapX(), teleportercell.getRelatedMapY());
			
			updatePicture();
			
			return;
		}
		
		nextcell = getNextCell();
		
		if(nextcell != null) {
			if(nextcell instanceof CommonCell) {
				nextcommoncell = (CommonCell) nextcell;
				
				
				if(keypressed && !nextcommoncell.hasItem()) {
					move(nextcell.getX(), nextcell.getY());
				}
			}
	
			if(nextcell instanceof Teleporter) {
				if(keypressed && inventory.contains(((Teleporter) nextcell).getLevel())) {
					onteleporter = true;
					move(nextcell.getX(), nextcell.getY());
					nextmapid = ((Teleporter)nextcell).getRelatedMap();
				}
			}
		}
		
		updatePicture();
	}
	
	public void updatePicture() {
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
		}
		
		picturetodraw = temp;
	}

	public void draw(int w, int h) {
		int drawedx = 0, drawedy = 0;
		
		drawedx = getX() * w;
		drawedy = getY() * h;
		
		picturetodraw.draw(drawedx, drawedy, w, h);
	}
}
