package ir.sharif.ce.javaclass.chess.pieces;

import ir.sharif.ce.javaclass.chess.Board;
import ir.sharif.ce.javaclass.chess.block.Block;

public class KnightBlack extends Piece {

	public String draw() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		return "NB";
	}

	public KnightBlack() {
		super();
		this.color = 1;
	}

	public void generateAvailableBlocks(Board board, Block pieceBlock) {
		availableBlocks.clear();
		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				if (!(i == j)
						&& !(i == -j)
						&& (i != 0)
						&& (j != 0)
						&& (i == 2 || j == 2 || i == -2 || j == -2)
						&& !Block.isOutOfRange(pieceBlock.getX() + i,
								pieceBlock.getY() + j)) {
					Block e = board.getBoardBlocks()[pieceBlock.getX() + i][pieceBlock
							.getY()
							+ j];
					addAvailableforBlack(e, availableBlocks);
				}
			}

		}

	}
}
