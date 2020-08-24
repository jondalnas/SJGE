package com.Jonas.SJGE;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.Jonas.SJGE.screen.ImageLoader;
import com.Jonas.SJGE.screen.Renderer;

public class Main implements Runnable {
	private static Renderer renderer;
	private static Game game;
	private Thread thread;
	
	public Main() {
		new ImageLoader();
	}
	
	public static void main(String[] args) {
		game = new Game();
		renderer = new Renderer(game);
		
		JFrame frame = new JFrame("Engine");
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add(renderer, 0);
		
		frame.setContentPane(panel);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		new Main().start();
	}
	
	private void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		while(true) {
			game.update();
			renderer.render();
		}
	}
}
