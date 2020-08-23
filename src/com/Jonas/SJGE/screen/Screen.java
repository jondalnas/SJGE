package com.Jonas.SJGE.screen;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen extends Canvas {
	private static final long serialVersionUID = 1L;
	
	public static int WIDTH = 160, HEIGHT = 120, SCALE = 4;
	
	private BufferedImage img;
	private int[] pixels;
	
	private Bitmap screen;
	
	public Screen() {
		setSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		
		screen = new Bitmap(WIDTH, HEIGHT);
		screen.pixels[10+10*WIDTH] = 0xff00ff;
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		//Render Screen
		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics graphics = bs.getDrawGraphics();
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		graphics.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
		graphics.dispose();
		bs.show();
	}
}
