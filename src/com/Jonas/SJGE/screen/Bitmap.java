package com.Jonas.SJGE.screen;

public class Bitmap {
	public final int width, height;
	public int[] pixels;
	
	public Bitmap(int width, int height) {
		this.width = width;
		this.height = height;
		
		pixels = new int[width * height];
	}
	
	public void draw(Bitmap bitmap, int x0, int y0) {
		for (int y = 0; y < bitmap.height; y++) {
			int yy = y + y0;
			if (yy < 0 || yy >= height) continue;
			
			for (int x = 0; x < bitmap.width; x++) {
				int xx = x + x0;
				if (xx < 0 || xx >= width) continue;
				
				pixels[xx + yy * width] = bitmap.pixels[x + y * bitmap.width];
			}
		}
	}
}
