package ir.sharif.ce.javaclass.chess.pieces;

import ir.sharif.ce.javaclass.chess.Board;
import ir.sharif.ce.javaclass.chess.block.Block;

import java.util.ArrayList;

public abstract class Piece {
	// TODO draw
	ArrayList<Block> availableBlocks;
	boolean isLose;
	int color; // 0->white 1->black

	public ArrayList<Block> getAvailableBlocks() {
		return availableBlocks;
	}

	public void setAvailableBlocks(ArrayList<Block> availableBlocks) {
		this.availableBlocks = availableBlocks;
	}

	public abstract String draw();

	public Piece() {
		this.isLose = false;
		availableBlocks = new ArrayList<Block>();
	}

	public int getColor() {
		return this.color;
	}

	public abstract void generateAvailableBlocks(Board board, Block pieceBlock);

	public boolean canMoveTo(Block block) {
		if (this.availableBlocks.size() == 0)
			return false;
		else {
			for (int i = 0; i < this.availableBlocks.size(); i++) {
				if (this.availableBlocks.get(i).equals(block))
					return true;
			}
		}
		return false;

	}

	public abstract String toString();

	public static boolean addAvailableforWhite(Block e,
			ArrayList<Block> availableBlocks) {
		if (e.isEmpty()) {
			availableBlocks.add(e);
			return true;
		} else if (e.getPiece().getColor() == 0)
			return false;
		else if (e.getPiece().getColor() == 1) {
			availableBlocks.add(e);
			return false;
		}
		return false;
	}

	public static boolean addAvailableforBlack(Block e,
			ArrayList<Block> availableBlocks) {
		if (e.isEmpty()) {
			availableBlocks.add(e);
			return true;
		} else if (e.getPiece().getColor() == 1)
			return false;
		else if (e.getPiece().getColor() == 0) {
			availableBlocks.add(e);
			return false;
		}
		return false;
	}
}
