package com.Jonas.SJGE;

import com.Jonas.SJGE.tilemap.Tilemap;

public class Game {
	public Tilemap tilemap;
	
	public void update() {
		tilemap = new Tilemap(this, 64, 64);
	}
}
