package ir.sharif.ce.javaclass.chess.pieces;

import ir.sharif.ce.javaclass.chess.Board;
import ir.sharif.ce.javaclass.chess.block.Block;

public class PawnWhite extends Piece {
	public String draw() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		return "PW";
	}
	
	public PawnWhite(){
		super();
		this.color = 0;
	}


	public void generateAvailableBlocks(Board board, Block pieceBlock) {

		availableBlocks.clear();
		if (pieceBlock.getX() == 6) {
			Block e = board.getBoardBlocks()[4][pieceBlock.getY()];
			Block e2  = board.getBoardBlocks()[5][pieceBlock.getY()];
			if (e.isEmpty() && e2.isEmpty()) {
				availableBlocks.add(e);
			}
		}

		if (!Block.isOutOfRange(pieceBlock.getX() - 1, pieceBlock.getY())) {
			Block e = board.getBoardBlocks()[pieceBlock.getX() - 1][pieceBlock
					.getY()];
			if (e.isEmpty()) {
				availableBlocks.add(e);
			}
		}
		if (!Block.isOutOfRange(pieceBlock.getX() - 1, pieceBlock.getY() - 1)) {
			Block e = board.getBoardBlocks()[pieceBlock.getX() - 1][pieceBlock
					.getY() - 1];
			if (!e.isEmpty()) {
				if (e.getPiece().getColor() == 1)
					availableBlocks.add(e);
			}
		}
		if (!Block.isOutOfRange(pieceBlock.getX() - 1, pieceBlock.getY() + 1)) {
			Block e = board.getBoardBlocks()[pieceBlock.getX() - 1][pieceBlock
					.getY() + 1];
			if (!e.isEmpty()) {
				if (e.getPiece().getColor() == 1)
					availableBlocks.add(e);
			}
		}
	
	}
}
