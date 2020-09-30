package com.Jonas.SJGE.entity;

import com.Jonas.SJGE.Game;
import com.Jonas.SJGE.Main;
import com.Jonas.SJGE.screen.Screen;

public class Camera extends Entity {
	private final int CAM_SPEED = 60;

	public Camera(Game game) {
		super(game);

		xColOffs = (int) (Screen.WIDTH  / 2 - sizeD / 2.0);
		yColOffs = (int) (Screen.HEIGHT / 2 - sizeD / 2.0);
	}

	public void update() {
		dx = game.input.getKeyDown('d') ? 1 : (game.input.getKeyDown('a') ? -1 : 0);
		dy = game.input.getKeyDown('s') ? 1 : (game.input.getKeyDown('w') ? -1 : 0);
		
		dx *= Math.round(CAM_SPEED * Main.getDeltaTime());
		dy *= Math.round(CAM_SPEED * Main.getDeltaTime());
		
		move();
	}

	public void render(Screen screen) {
		screen.screen.draw(0xff00ff, xColOffs, yColOffs, sizeD, sizeD);
	}
}
