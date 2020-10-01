package com.Jonas.SJGE;

import java.util.ArrayList;
import java.util.List;

import com.Jonas.SJGE.entity.BigTree;
import com.Jonas.SJGE.entity.Camera;
import com.Jonas.SJGE.entity.Entity;
import com.Jonas.SJGE.tilemap.Tilemap;

public class Game {
	public Tilemap tilemap;
	public Camera cam;
	public List<Entity> entities = new ArrayList<Entity>();
	public Input input;
	
	public Game() {
		input = new Input();
		cam = new Camera(this);
		tilemap = new Tilemap(this);
		
		addEntity(new BigTree(this, 64, 64));
	}
	
	public void update() {
		cam.update();
		
		for (Entity e : entities) {
			e.update();
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
}
