package main;

import java.awt.EventQueue;

import interfaces.menu.WindowMain;

public class Main {

	public static void main(String[] args) {
		System.setProperty("file.encoding", "UTF-8");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowMain frame = new WindowMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
