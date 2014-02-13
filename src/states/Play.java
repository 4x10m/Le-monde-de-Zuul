package states;

import init.Program;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Cell.NotImplementedCellTypeException;
import core.Map;
import core.Player;

public class Play extends BasicGameState {
	private Map map = null;
	private Player player = null;
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		try {
			map = new Map(arg0, Program.MAPW, Program.MAPH);
		} catch (NotImplementedCellTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		player = new Player(arg0, map);
		
		arg0.getInput().addKeyListener(player);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		map.draw(arg2);
		player.draw(arg2);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		player.update(arg2);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Program.PLAYSTATEID;
	}
}
