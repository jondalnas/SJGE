package com.Jonas.SJGE.tilemap.tiles;

import com.Jonas.SJGE.Game;
import com.Jonas.SJGE.screen.Screen;

public class Gravel extends Tile {

	public Gravel(Game game, int x, int y) {
		super(game, x, y);
		
		tilemapLocation = 1+0*16;
	}

	public void tick() {
	}

	public void render(Screen screen) {
		renderTile(screen);
	}
}
