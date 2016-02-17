package ir.sharif.ce.javaclass.chess;

import ir.sharif.ce.javaclass.chess.block.Block;
import ir.sharif.ce.javaclass.chess.pieces.BishopBlack;
import ir.sharif.ce.javaclass.chess.pieces.BishopWhite;
import ir.sharif.ce.javaclass.chess.pieces.KingBlack;
import ir.sharif.ce.javaclass.chess.pieces.KingWhite;
import ir.sharif.ce.javaclass.chess.pieces.KnightBlack;
import ir.sharif.ce.javaclass.chess.pieces.KnightWhite;
import ir.sharif.ce.javaclass.chess.pieces.PawnBlack;
import ir.sharif.ce.javaclass.chess.pieces.PawnWhite;
import ir.sharif.ce.javaclass.chess.pieces.QueenBlack;
import ir.sharif.ce.javaclass.chess.pieces.QueenWhite;
import ir.sharif.ce.javaclass.chess.pieces.RookBlack;
import ir.sharif.ce.javaclass.chess.pieces.RookWhite;

public class Board {
	Block[][] boardBlocks;

	public Board() {
		// construct black pieces
		boardBlocks = new Block[8][8];
		boardBlocks[0][0] = new Block(0, 0, 0, new RookBlack());
		boardBlocks[0][1] = new Block(0, 1, 1, new KnightBlack());
		boardBlocks[0][2] = new Block(0, 2, 0, new BishopBlack());
		boardBlocks[0][3] = new Block(0, 3, 1, new QueenBlack());
		boardBlocks[0][4] = new Block(0, 4, 0, new KingBlack());
		boardBlocks[0][5] = new Block(0, 5, 1, new BishopBlack());
		boardBlocks[0][6] = new Block(0, 6, 0, new KnightBlack());
		boardBlocks[0][7] = new Block(0, 7, 1, new RookBlack());
		for (int i = 0; i < 8; i = i + 2)
			boardBlocks[1][i] = new Block(1, i, 1, new PawnBlack());
		for (int j = 1; j < 8; j = j + 2)
			boardBlocks[1][j] = new Block(1, j, 0, new PawnBlack());
		// construct white pieces
		boardBlocks[7][0] = new Block(7, 0, 1, new RookWhite());
		boardBlocks[7][1] = new Block(7, 1, 0, new KnightWhite());
		boardBlocks[7][2] = new Block(7, 2, 1, new BishopWhite());
		boardBlocks[7][3] = new Block(7, 3, 0, new QueenWhite());
		boardBlocks[7][4] = new Block(7, 4, 1, new KingWhite());
		boardBlocks[7][5] = new Block(7, 5, 0, new BishopWhite());
		boardBlocks[7][6] = new Block(7, 6, 1, new KnightWhite());
		boardBlocks[7][7] = new Block(7, 7, 0, new RookWhite());
		for (int i = 0; i < 8; i = i + 2)
			boardBlocks[6][i] = new Block(6, i, 0, new PawnWhite());
		for (int j = 1; j < 8; j = j + 2)
			boardBlocks[6][j] = new Block(6, j, 1, new PawnWhite());
		// construct empty blocks
		for (int i = 2; i < 6; i++)
			for (int j = 0; j < 8; j++)
				boardBlocks[i][j] = new Block(i, j, (i + j) % 2);
	}

	public String toString() {
		String result = "";
		for (int j = 0; j < 8; j++)
		{
			for (int k = 0; k < 8; k++)
			{
				result = result + this.boardBlocks[j][k].toString();
				if (k != 7)
				{
					result = result + "-";
				}
				else
					result = result + "\n";
			}
		}
		return result;
	}

	public Block[][] getBoardBlocks() {
		return boardBlocks;
	}

	public void setBoardBlocks(Block[][] boardBlocks) {
		this.boardBlocks = boardBlocks;
	}

}
