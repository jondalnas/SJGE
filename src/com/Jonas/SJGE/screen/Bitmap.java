package com.Jonas.SJGE.screen;

public class Bitmap {
	public final int width, height;
	public int[] pixels;
	
	public Bitmap(int width, int height) {
		this.width = width;
		this.height = height;
		
		pixels = new int[width * height];
	}
}
