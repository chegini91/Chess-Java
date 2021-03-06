package ir.sharif.ce.javaclass.chess.pieces;

import ir.sharif.ce.javaclass.chess.Board;
import ir.sharif.ce.javaclass.chess.block.Block;

public class QueenWhite extends Piece {
	public String draw() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		return "QW";
	}
	
	
	public QueenWhite(){
		super();
		this.color = 0;
	}

	
	public void generateAvailableBlocks(Board board, Block pieceBlock) {
		availableBlocks.clear();
		int downMove = pieceBlock.getX() + 1;
		int upMove = pieceBlock.getX() - 1;
		int rightMove = pieceBlock.getY() + 1;
		int leftMove = pieceBlock.getY() -1;
		boolean notBreak;
		while (downMove < 8) {
			Block e = board.getBoardBlocks()[downMove][pieceBlock.getY()];
			notBreak = addAvailableforWhite(e, availableBlocks);
			if(!notBreak)
				break;
			downMove++;
		}
		while (upMove > -1) {
			Block e = board.getBoardBlocks()[upMove][pieceBlock.getY()];
			notBreak = addAvailableforWhite(e, availableBlocks);
			if(!notBreak)
				break;
			--upMove;
		}
		while(rightMove < 8 ){
			Block e = board.getBoardBlocks()[pieceBlock.getX()][rightMove];
			notBreak = addAvailableforWhite(e, availableBlocks);
			if(!notBreak)
				break;
			rightMove++;
		}
		while(leftMove > -1){
			Block e = board.getBoardBlocks()[pieceBlock.getX()][leftMove];
			notBreak = addAvailableforWhite(e, availableBlocks);
			if(!notBreak)
				break;
			--leftMove;
			                                 
		}
		downMove = pieceBlock.getX() + 1;
		upMove = pieceBlock.getX() - 1;
		rightMove = pieceBlock.getY() + 1;
		leftMove = pieceBlock.getY() - 1;
		while (upMove > -1 && rightMove < 8) {
			Block e = board.getBoardBlocks()[upMove][rightMove];
			notBreak = addAvailableforWhite(e, availableBlocks);
			if (!notBreak)
				break;
			--upMove;
			rightMove++;
		}
		downMove = pieceBlock.getX() + 1;
		upMove = pieceBlock.getX() - 1;
		rightMove = pieceBlock.getY() + 1;
		leftMove = pieceBlock.getY() - 1;

		while (upMove > -1 && leftMove > -1) {
			Block e = board.getBoardBlocks()[upMove][leftMove];
			notBreak = addAvailableforWhite(e, availableBlocks);
			if(!notBreak)
				break;
			--upMove;
			--leftMove;
		}

		downMove = pieceBlock.getX() + 1;
		upMove = pieceBlock.getX() - 1;
		rightMove = pieceBlock.getY() + 1;
		leftMove = pieceBlock.getY() - 1;
		while (downMove < 8 && rightMove < 8) {
			Block e = board.getBoardBlocks()[downMove][rightMove];
			notBreak = addAvailableforWhite(e, availableBlocks);
			if(!notBreak)
				break;
			downMove++;
			rightMove++;
		}

		downMove = pieceBlock.getX() + 1;
		upMove = pieceBlock.getX() - 1;
		rightMove = pieceBlock.getY() + 1;
		leftMove = pieceBlock.getY() - 1;
		while (downMove < 8 && leftMove > -1) {
			Block e = board.getBoardBlocks()[downMove][leftMove];
			notBreak = addAvailableforWhite(e, availableBlocks);
			if(!notBreak)
				break;
			downMove++;
			--leftMove;
		}
		
	}

}
