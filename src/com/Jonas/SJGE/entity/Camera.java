package com.Jonas.SJGE.entity;

import com.Jonas.SJGE.Game;
import com.Jonas.SJGE.screen.Screen;

public class Camera extends Entity {
	private final double CAM_SPEED = 0.01;

	public Camera(Game game) {
		super(game);
	}

	public void update() {
		dx = game.input.getKeyDown('a') ? 1 : (game.input.getKeyDown('d') ? -1 : 0);
		dy = game.input.getKeyDown('w') ? 1 : (game.input.getKeyDown('s') ? -1 : 0);
		
		double d = Math.sqrt(dx * dx + dy * dy);
		
		if (d == 0) return;

		dx /= d;
		dy /= d;
		
		x += dx * CAM_SPEED;
		y += dy * CAM_SPEED;
	}

	public void render(Screen screen) {
	}
}
