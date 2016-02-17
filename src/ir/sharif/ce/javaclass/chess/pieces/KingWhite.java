package ir.sharif.ce.javaclass.chess.pieces;

import ir.sharif.ce.javaclass.chess.Board;
import ir.sharif.ce.javaclass.chess.block.Block;


public class KingWhite extends Piece{
	boolean isCheck;
	public String draw() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {		
		return "KW";
	}
	
	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

	public KingWhite(){
		super();
		this.isCheck = false;
		this.color = 0;
	}

	public boolean isCheck(Board b, Block pieceBlock) {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				Block e = b.getBoardBlocks()[i][j];
				if (!e.isEmpty()) {
					if (e.getPiece().getColor() == 1) {
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
				if (!(i == 0 && j == 0) && pieceBlock.getX() + i < 8
						&& pieceBlock.getX() + i > -1
						&& pieceBlock.getY() + j < 8
						&& pieceBlock.getY() + j > -1) {
					Block e = board.getBoardBlocks()[pieceBlock.getX() + i][pieceBlock
							.getY()
							+ j];
					addAvailableforWhite(e, availableBlocks);
				}
			}

		}
		
	}
	
}
