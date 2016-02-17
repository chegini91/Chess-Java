package ir.sharif.ce.javaclass.chess.ui;

import ir.sharif.ce.javaclass.chess.Chess;
import ir.sharif.ce.javaclass.chess.block.Block;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChessGUI extends JFrame {
	JButton[][] chessJB;
	boolean flag;

	// JButton firstButton;
	// JButton temp;
	int firstI;
	int firstJ;
	int secondI;
	int secondJ;
	JButton temp = new JButton();

	public ChessGUI(final Chess g) {
		super();
		flag = false;
		// Blocks actions
		chessJB = new JButton[8][8];
		this.setBounds(100, 100, 532, 552);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				chessJB[i][j] = new JButton();

				chessJB[i][j].setSize(64, 64);
				chessJB[i][j].setBackground(Color.pink);
				chessJB[i][j].setLocation(j * 64, i * 64);
				chessJB[i][j]
						.setIcon(new ImageIcon(
								"chess_icons/"
										+ g.getBoard().getBoardBlocks()[i][j]
												.toString().substring(8)
										+ ".png"));

				chessJB[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (flag) {
							if (!g.getBoard().getBoardBlocks()[firstI][firstJ]
									.isEmpty()) {
								for (int i = 0; i < g.getBoard()
										.getBoardBlocks()[firstI][firstJ]
										.getPiece().getAvailableBlocks().size(); i++) {
									setBackGroundPink(g.getBoard()
											.getBoardBlocks()[firstI][firstJ]
											.getPiece().getAvailableBlocks()
											.get(i));

								}
							}
							if (!ChessGUI.myEqualsButtons(temp, (JButton) e
									.getSource())) {
								secondI = ((JButton) e.getSource())
										.getLocation().y / 64;
								secondJ = ((JButton) e.getSource())
										.getLocation().x / 64;
								try {
									g
											.move(
													g.getBoard()
															.getBoardBlocks()[firstI][firstJ],
													g.getBoard()
															.getBoardBlocks()[secondI][secondJ]);
									chessJB[firstI][firstJ]
											.setIcon(new ImageIcon(
													"chess_icons/"
															+ g
																	.getBoard()
																	.getBoardBlocks()[firstI][firstJ]
																	.toString()
																	.substring(
																			8)
															+ ".png"));
									chessJB[secondI][secondJ]
											.setIcon(new ImageIcon(
													"chess_icons/"
															+ g
																	.getBoard()
																	.getBoardBlocks()[secondI][secondJ]
																	.toString()
																	.substring(
																			8)
															+ ".png"));
								} catch (Exception exception) {
									
									JOptionPane.showMessageDialog(null,
											exception.getMessage(),
											"False Move",
											JOptionPane.ERROR_MESSAGE);

								}
								flag = !flag;

							} else
								flag = false;

						} else {
							temp = ((JButton) e.getSource());
							firstI = ((JButton) e.getSource()).getLocation().y / 64;
							firstJ = ((JButton) e.getSource()).getLocation().x / 64;
							g.generateAllBlocksAvailableMoves();
							if (!g.getBoard().getBoardBlocks()[firstI][firstJ]
									.isEmpty()) {
								if(g.getTurnToInt() !=g.getBoard()
										.getBoardBlocks()[firstI][firstJ]
										                          .getPiece().getColor()){
									JOptionPane.showMessageDialog(null,
											"IT is not your turn",
											"False Move",
											JOptionPane.ERROR_MESSAGE);	
								}
								else{
								for (int i = 0; i < g.getBoard()
										.getBoardBlocks()[firstI][firstJ]
										.getPiece().getAvailableBlocks().size(); i++) {
									setBackGround(g.getBoard().getBoardBlocks()[firstI][firstJ]
											.getPiece().getAvailableBlocks()
											.get(i));
								}
									flag = !flag;
								}
							}
							else{
								JOptionPane.showMessageDialog(null,
										"This Block is Empty",
										"False Move",
										JOptionPane.ERROR_MESSAGE);
							}
							
						}
					}
				});
				add(chessJB[i][j]);

			}
		}
		// JFrame properties
		this.setTitle("Chess");
		setLayout(null);
		setVisible(true);
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				requestFocus();
				System.out.println("x");
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public void setBackGround(Block e) {

		chessJB[e.getX()][e.getY()].setBackground(Color.green);

	}

	public static boolean myEqualsButtons(JButton x, JButton y) {
		if (x.getLocation().equals(y.getLocation()))
			return true;
		return false;
	}

	public void setBackGroundPink(Block e) {
		chessJB[e.getX()][e.getY()].setBackground(Color.pink);

	}

}
