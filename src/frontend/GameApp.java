package frontend;

import backend.CandyGame;
import backend.level.Level1;
import backend.level.Level2;
import backend.level.Level3;
import backend.level.Level4;

import javax.swing.JFrame;

public class GameApp {

	public static void main(String[] args) {
		CandyGame game = new CandyGame(Level3.class);
		CandyFrame frame = new CandyFrame(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}