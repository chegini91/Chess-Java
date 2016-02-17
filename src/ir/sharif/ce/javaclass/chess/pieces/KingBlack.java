package ir.sharif.ce.javaclass.chess.pieces;

import java.awt.Graphics;

import ir.sharif.ce.javaclass.chess.Board;
import ir.sharif.ce.javaclass.chess.block.Block;

public class KingBlack extends Piece {
	boolean isCheck;

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

	public String draw(Graphics g) {
//	//	g.s
		return null;
	}

	public String toString() {
		return "KB";
	}

	public KingBlack() {
		super();
		this.color = 1;
		isCheck = false;
	}

	public boolean isCheck(Board b, Block pieceBlock) {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				Block e = b.getBoardBlocks()[i][j];
				if (!e.isEmpty()) {
					if (e.getPiece().getColor() == 0) {
						if (e.getPiece().canMoveTo(pieceBlock))
							return true;
					}
				}
			}
		return false;
	}

	public void generateAvailableBlocks(Board board, Block pieceBlock) {
		availableBlocks.clear();
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (!(i == 0 && j == 0)
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

	@Override
	public String draw() {
		// TODO Auto-generated method stub
		return null;
	}
}
