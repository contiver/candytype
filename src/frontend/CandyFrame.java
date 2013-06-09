package frontend;

import backend.CandyGame;
import backend.GameListener;
import backend.cell.Cell;
import backend.cell.JellyCell;

import backend.element.Element;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class CandyFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final int CELL_SIZE = 65;
	private static final int SCORE_HEIGHT = 80;

	private BoardPanel bp;
	private ScorePanel sp;
	private ImageManager images;
	private GameListener listener;
	private Point lastPoint;
	private CandyGame game;

	public CandyFrame(CandyGame game) {
		this.game = game;
		
		images = new ImageManager();
		
		setLayout(null);
		setSize(game.getSize() * CELL_SIZE + 20, game.getSize() * CELL_SIZE + SCORE_HEIGHT);

		bp = new BoardPanel(game.getSize(), game.getSize(), CELL_SIZE);
		add(bp);
		
		sp = new ScorePanel(bp.getWidth(), SCORE_HEIGHT);
		sp.setLocation(1, bp.getHeight());
		add(sp);
		
		game.initGame();
		game.addGameListener(listener = new GameListener() {
				@Override
				public void gridUpdated() {
					for (int i = 0; i < game().getSize(); i++) {
						for (int j = 0; j < game().getSize(); j++) {
							Cell cell = CandyFrame.this.game.get(i, j);
							Element element = cell.getContent();
							bp.clearImage(i, j);
							Image image = images.getImage(element);
							bp.setImage(i, j, image);
                            if(cell instanceof JellyCell){
                                image = images.getImage(cell);
                                bp.appendImage(i, j, image);
                            }
						}
					}
					bp.paintImmediately(bp.getBounds());
				}
				@Override
				public void cellExplosion(Element e) {
				}
		});
				
		listener.gridUpdated();
		
		addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					if (lastPoint == null) {
						lastPoint = translateCoords(event.getX(), event.getY());
						System.out.println("Get first = " +  lastPoint);
					} else {
						Point newPoint = translateCoords(event.getX(), event.getY());
						if (newPoint != null) {
							System.out.println("Get second = " +  newPoint);
							game().tryMove(lastPoint.x, lastPoint.y, newPoint.x, newPoint.y);
							
							String message = ((Long)game().getScore()).toString();
							if (game().isFinished()) {
								if (game().playerWon()) {
									message = message + " Finished - Player Won!";
								} else {
									message = message + " Finished - Loser !";
								}
							} 
							sp.updateScore(message);
							lastPoint = null;
						}
					}
				}
		});
		
	}
	
	private CandyGame game() {
		return game;
	}
	
	private Point translateCoords(int x, int y) {
		int i = x / CELL_SIZE;
		int j = y / CELL_SIZE;
		return (i >= 0 && i < game.getSize() && j >= 0 && j < game.getSize()) ? new Point(j, i) : null;
	}
}
