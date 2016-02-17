package ir.sharif.ce.javaclass.chess.pieces;

import ir.sharif.ce.javaclass.chess.Board;
import ir.sharif.ce.javaclass.chess.block.Block;

public class RookBlack extends Piece{
	public String draw() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		return "RB";
	}
	
	public RookBlack(){
		super();
		this.color = 1;
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
			notBreak = addAvailableforBlack(e, availableBlocks);
			if(!notBreak)
				break;
			downMove++;
		}
		while (upMove > -1) {
			Block e = board.getBoardBlocks()[upMove][pieceBlock.getY()];
			notBreak = addAvailableforBlack(e, availableBlocks);
			if(!notBreak)
				break;
			--upMove;	
		}
		while(rightMove < 8 ){
			Block e = board.getBoardBlocks()[pieceBlock.getX()][rightMove];
			notBreak = addAvailableforBlack(e, availableBlocks);
			if(!notBreak)
				break;
			rightMove++;
		}
		while(leftMove > -1){
			Block e = board.getBoardBlocks()[pieceBlock.getX()][leftMove];
			notBreak = addAvailableforBlack(e, availableBlocks);
			if(!notBreak)
				break;
			--leftMove;
			                                 
		}
		
	}
}
