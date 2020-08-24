package com.Jonas.SJGE.tilemap;

import com.Jonas.SJGE.Game;
import com.Jonas.SJGE.screen.Screen;
import com.Jonas.SJGE.tilemap.tiles.Grass;
import com.Jonas.SJGE.tilemap.tiles.Gravel;
import com.Jonas.SJGE.tilemap.tiles.Tile;

public class Tilemap {
	private final Tile[] tilemap;
	private final int width, height;
	public static final int TILE_SIZE = 16;
	
	public Tilemap(Game game, int width, int height) {
		this.width = width;
		this.height = height;
		
		tilemap = new Tile[width * height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tilemap[x+y*width] = new Grass(game, x, y);
			}
		}
		
		tilemap[0] = new Gravel(game, 0, 0);
	}
	
	public void tick() {
		for (int i = 0; i < width * height; i++) {
			tilemap[i].tick();
		}
	}
	
	public void render(Screen screen) {
		for (int i = 0; i < width * height; i++) {
			tilemap[i].render(screen);
		}
	}
	
	public Tile getTile(int x, int y) {
		return tilemap[x + y * width];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
