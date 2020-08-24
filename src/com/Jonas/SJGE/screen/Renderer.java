package com.Jonas.SJGE.screen;

import com.Jonas.SJGE.Game;

public class Renderer extends Screen {
	private static final long serialVersionUID = 1L;
	
	private Game game;
	public Renderer(Game game) {
		this.game = game;
	}
	
	public void renderGame() {
		game.tilemap.render(this);
	}
}
