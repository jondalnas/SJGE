package com.Jonas.SJGE;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.Jonas.SJGE.screen.Screen;

public class Main implements Runnable {
	private static Screen screen;
	private static Game game;
	private Thread thread;
	
	public Main() {
		game = new Game();
	}
	
	public static void main(String[] args) {
		screen = new Screen();
		
		JFrame frame = new JFrame("Engine");
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add(screen, 0);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
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
			screen.render();
		}
	}
}
