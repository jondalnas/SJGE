package com.Jonas.SJGE.tilemap.tiles;

import com.Jonas.SJGE.Game;
import com.Jonas.SJGE.screen.ImageLoader;
import com.Jonas.SJGE.screen.Screen;
import com.Jonas.SJGE.tilemap.Tilemap;

public abstract class Tile {
	protected int x, y;
	protected int tilemapLocation;
	protected Game game;
	
	public boolean solid = false;
	
	public Tile(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
	}
	
	public abstract void tick();
	public abstract void render(Screen screen);

	protected void renderTile(Screen screen) {
		renderTile(screen, tilemapLocation);
	}
	protected void renderTile(Screen screen, int tilemapLocation) {
		screen.screen.draw(ImageLoader.tilemap, x * Tilemap.TILE_SIZE - (int) game.cam.x, y * Tilemap.TILE_SIZE - (int) game.cam.y, (tilemapLocation % 16) * Tilemap.TILE_SIZE, (tilemapLocation / 16) * Tilemap.TILE_SIZE, Tilemap.TILE_SIZE, Tilemap.TILE_SIZE);
	}
}
