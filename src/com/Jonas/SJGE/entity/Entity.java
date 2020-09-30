package com.Jonas.SJGE.entity;

import com.Jonas.SJGE.Game;
import com.Jonas.SJGE.screen.Screen;
import com.Jonas.SJGE.tilemap.Tilemap;

public abstract class Entity {
	public int x, y;
	public int dx, dy;
	protected Game game;
	protected int xColOffs, yColOffs, sizeD = 16;
	
	public Entity(Game game) {
		this.game = game;
	}
	
	public abstract void update();
	public abstract void render(Screen screen);
	
	public void move() {
		if (dx != 0) {
			for (int xx = dx * (dx < 0 ? -1 : 1); xx > 0; xx--) {
				int x2 = x + xx * (dx < 0 ? -1 : 1);
				
				if (x2+xColOffs < 0 || x2+xColOffs+sizeD >= Tilemap.TILE_SIZE * game.tilemap.getWidth()) continue;
				
				if (game.tilemap.getTile((x2+xColOffs        )/Tilemap.TILE_SIZE, (y+yColOffs        )/Tilemap.TILE_SIZE).solid ||
					game.tilemap.getTile((x2+xColOffs+sizeD-1)/Tilemap.TILE_SIZE, (y+yColOffs        )/Tilemap.TILE_SIZE).solid ||
					game.tilemap.getTile((x2+xColOffs        )/Tilemap.TILE_SIZE, (y+yColOffs+sizeD-1)/Tilemap.TILE_SIZE).solid ||
					game.tilemap.getTile((x2+xColOffs+sizeD-1)/Tilemap.TILE_SIZE, (y+yColOffs+sizeD-1)/Tilemap.TILE_SIZE).solid) continue;
				
				boolean collided = false;
				for (Entity e : game.entities) {
					if (e.x + e.xColOffs > x2 + xColOffs + sizeD ||
						e.y + e.yColOffs > y + yColOffs + sizeD ||
						e.x + e.xColOffs + e.sizeD < x2 + xColOffs ||
						e.y + e.yColOffs + e.sizeD < y + yColOffs) continue;
					
					if (e.collide(this)) {
						collided = true;
						break;
					}
				}
				
				if (collided) continue;
				
				x = x2;
				dx = 0;
				break;
			}
		}
		
		if (dy != 0) {
			for (int yy = dy * (dy < 0 ? -1 : 1); yy > 0; yy--) {
				int y2 = y + yy * (dy < 0 ? -1 : 1);
				
				if (y2+yColOffs < 0 || y2+yColOffs+sizeD >= Tilemap.TILE_SIZE * game.tilemap.getHeight()) continue;
				
				if (game.tilemap.getTile((x+xColOffs        )/Tilemap.TILE_SIZE, (y2+yColOffs        )/Tilemap.TILE_SIZE).solid ||
					game.tilemap.getTile((x+xColOffs+sizeD-1)/Tilemap.TILE_SIZE, (y2+yColOffs        )/Tilemap.TILE_SIZE).solid ||
					game.tilemap.getTile((x+xColOffs        )/Tilemap.TILE_SIZE, (y2+yColOffs+sizeD-1)/Tilemap.TILE_SIZE).solid ||
					game.tilemap.getTile((x+xColOffs+sizeD-1)/Tilemap.TILE_SIZE, (y2+yColOffs+sizeD-1)/Tilemap.TILE_SIZE).solid) continue;
				
				boolean collided = false;
				for (Entity e : game.entities) {
					if (e.x + e.xColOffs > x + xColOffs + sizeD ||
						e.y + e.yColOffs > y2 + yColOffs + sizeD ||
						e.x + e.xColOffs + e.sizeD < x + xColOffs ||
						e.y + e.yColOffs + e.sizeD < y2 + yColOffs) continue;
					
					if (e.collide(this)) {
						collided = true;
						break;
					}
				}
				
				if (collided) continue;
				
				y = y2;
				dy = 0;
				break;
			}
		}
	}
	
	public abstract boolean collide(Entity e);
}
