package com.Jonas.SJGE.entity;

import com.Jonas.SJGE.Game;
import com.Jonas.SJGE.screen.Screen;

public abstract class Entity {
	public double x, y;
	public double dx, dy;
	protected Game game;
	
	public Entity(Game game) {
		this.game = game;
	}
	
	public abstract void update();
	public abstract void render(Screen screen);
}
