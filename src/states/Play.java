package states;

import init.Program;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Inventory;
import core.Levels;
import core.Map;
import core.MapManager;
import core.Player;

public class Play extends BasicGameState {
	private  static GameContainer container = null;
	private static Map map = null;
	
	private Player player = null;
	private Inventory inventory = null;
	
	@Override
	public int getID() {
		return Program.PLAYSTATEID;
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		MapManager.loadmaps(arg0.getWidth(), arg0.getHeight());
		Levels.loadLevels();
		container = arg0;
		
		map = MapManager.getMap(1);
		inventory = new Inventory(arg0);
		player = new Player(arg0.getInput(), map, inventory);
		
		arg0.getInput().addKeyListener(player);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		map.draw(arg2);
		player.draw(map.getSquareW(), map.getSquareH());
		inventory.draw(arg2);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		player.addTime(arg2);
	}

	public static Map loadMap(int nextmapid) {
		map = MapManager.getMap(nextmapid);
		
		return map;
	}
}
