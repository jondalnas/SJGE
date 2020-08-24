package com.Jonas.SJGE.tilemap.tiles;

import com.Jonas.SJGE.Game;
import com.Jonas.SJGE.screen.Screen;

public class Grass extends Tile {
	public Grass(Game game, int x, int y) {
		super(game, x, y);
		tilemapLocation = 0;
	}

	public void tick() {
	}

	public void render(Screen screen) {
		renderTile(screen);
	}
}
