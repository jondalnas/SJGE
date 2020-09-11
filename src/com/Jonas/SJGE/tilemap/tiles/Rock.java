package com.Jonas.SJGE.tilemap.tiles;

import com.Jonas.SJGE.Game;
import com.Jonas.SJGE.screen.Screen;

public class Rock extends Tile {

	public Rock(Game game, int x, int y) {
		super(game, x, y);
		tilemapLocation = 0+1*16;
	}

	public void tick() {
	}

	public void render(Screen screen) {
		renderTile(screen);
	}
}
