package com.Jonas.SJGE;

import com.Jonas.SJGE.entity.Camera;
import com.Jonas.SJGE.tilemap.Tilemap;

public class Game {
	public Tilemap tilemap;
	public Camera cam;
	
	public Game() {
		cam = new Camera(this);
		tilemap = new Tilemap(this, 64, 64);
	}
	
	public void update() {
		cam.update();
	}
}
