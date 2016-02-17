package ir.sharif.ce.javaclass.chess;

import ir.sharif.ce.javaclass.chess.block.Block;
import ir.sharif.ce.javaclass.chess.exceptions.ChessException;
import ir.sharif.ce.javaclass.chess.exceptions.EmptyBlockException;
import ir.sharif.ce.javaclass.chess.exceptions.FalseTurnException;
import ir.sharif.ce.javaclass.chess.exceptions.KhodieBawException;
import ir.sharif.ce.javaclass.chess.exceptions.KinCheckException;
import ir.sharif.ce.javaclass.chess.exceptions.NotAvailableException;
import ir.sharif.ce.javaclass.chess.pieces.KingBlack;
import ir.sharif.ce.javaclass.chess.pieces.KingWhite;
import ir.sharif.ce.javaclass.chess.pieces.Piece;
import ir.sharif.ce.javaclass.chess.ui.ChessGUI;

public class Chess {
	Board board;
	int turn; // 0->white 1->black
	ChessGUI chessGUI;
	IPlayer ai1;
	IPlayer ai2;

	public Chess() {
		board = new Board();
		turn = 0;
		ChessGUI myGUI = new ChessGUI(this);
	}

	public Chess(IPlayer ai1, IPlayer ai2) {
		board = new Board();
		this.ai1 = ai1;
		this.ai2 = ai2;
		turn = 0;
	}

	public void nextMove() throws ChessException {
		String s = "";
		Block first;
		Block second;
		if (turn == 0)
			s = this.ai1.move(this);
		if (turn == 1)
			s = this.ai2.move(this);
		int yFirst = columnToint(s.substring(0, 1).charAt(0));
		int xFirst = Integer.parseInt(s.substring(1, 2)) - 1;
		int ySecond = columnToint(s.substring(4, 5).charAt(0));
		int xSecond = Integer.parseInt(s.substring(5, 6)) - 1;
		xFirst = reverse(xFirst);
		xSecond = reverse(xSecond);
		first = this.getBoard().getBoardBlocks()[xFirst][yFirst];
		second = this.getBoard().getBoardBlocks()[xSecond][ySecond];
		this.moveForAI(first, second);
	}

	public static int reverse(int x) {
		switch (x) {
		case 0:
			return 7;
		case 1:
			return 6;
		case 2:
			return 5;
		case 3:
			return 4;
		case 4:
			return 3;
		case 5:
			return 2;
		case 6:
			return 1;
		case 7:
			return 0;

		}
		return x;
	}


	public void moveForAI(Block first, Block second) throws ChessException {
		this.generateAllBlocksAvailableMoves();
		if (first.isEmpty()) {
			if (turn == 0)
				throw new ChessException("Exception for W");
			if (turn == 1)
				throw new ChessException("Exception for B");
		}
		if (this.board.boardBlocks[first.getX()][first.getY()].getPiece()
				.getColor() != turn) {
			if (turn == 0)
				throw new ChessException("Exception for W");
			if (turn == 1)
				throw new ChessException("Exception for B");
		}
		if (!second.isEmpty()) {
			if (first.getPiece().getColor() == second.getPiece().getColor()) {
				if (turn == 0)
					throw new ChessException("Exception for W");
				if (turn == 1)
					throw new ChessException("Exception for B");
			}
		}
		if (this.board.boardBlocks[first.getX()][first.getY()].isEmpty()) {
			if (turn == 0)
				throw new ChessException("Exception for W");
			if (turn == 1)
				throw new ChessException("Exception for B");
		}
		if (!first.getPiece().canMoveTo(second)) {
			if (turn == 0)
				throw new ChessException("Exception for W");
			if (turn == 1)
				throw new ChessException("Exception for B");
		}

		Piece p = null;
		if (!second.isEmpty()) {
			p = second.getPiece();
		}
		this.simpleMove(first, second);
		this.generateAllBlocksAvailableMoves();
		KingBlack KB;
		KingWhite KW;
		boolean isCheck = false;
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				Block e = this.getBoard().getBoardBlocks()[i][j];
				if (!e.isEmpty()) {
					if (e.getPiece().toString().equals("KB")) {
						KB = (KingBlack) e.getPiece();
						if (KB.isCheck(this.board, e)) {
							if (this.getTurn() == "B")
								isCheck = true;
						}
					}
					if (e.getPiece().toString().equals("KW")) {
						KW = (KingWhite) e.getPiece();
						if (KW.isCheck(this.board, e)) {
							if (this.getTurn() == "W")
								isCheck = true;
						}
					}
				}
			}
		if (isCheck) {
			this.simpleMove(second, first);
			if (p != null) {
				second.setPiece(p);
				second.setEmpty(false);
			}
			if (turn == 0)
				throw new ChessException("Exception for W");
			if (turn == 1)
				throw new ChessException("Exception for B");
		}

		if (turn == 0)
			turn = 1;
		else
			turn = 0;
	}

	public static int columnToint(char c) {
		int column = 0;
		switch (c) {
		case 'A':
			column = 0;
			break;
		case 'B':
			column = 1;
			break;
		case 'C':
			column = 2;
			break;
		case 'D':
			column = 3;
			break;
		case 'E':
			column = 4;
			break;
		case 'F':
			column = 5;
			break;
		case 'G':
			column = 6;
			break;
		case 'H':
			column = 7;
			break;
		}
		return column;
	}

	public String getPieceIn(String place) {

		if (!place.equals(null)) {
			char columnChar = place.substring(0, 1).charAt(0);
			int column = Chess.columnToint(columnChar);
			int row = Integer.parseInt(place.substring(1)) - 1;
			row = reverse(row);
			Block e = this.getBoard().getBoardBlocks()[row][column];
			if (e.isEmpty())
				return "E";
			else {
				return e.getPiece().toString();
			}
		}
		return null;
	}

	public String getTurn() {
		if (this.turn == 0)
			return "W";
		else
			return "B";
	}

	public int getTurnToInt() {
		return this.turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	// public boolean move(Coordinate first, Coordinate second) {
	//
	// if (this.board.boardBlocks[first.x][first.y].isEmpty()) {
	// System.err.println("idiot");
	// return false;
	// } else {
	// this.board.boardBlocks[second.x][second.y] = new Block(second.x,
	// second.y, this.board.boardBlocks[second.x][second.y]
	// .getColor(),
	// this.board.boardBlocks[first.x][first.y].getPiece());
	// this.board.boardBlocks[first.x][first.y] = new Block(first.x,
	// first.y, this.board.boardBlocks[first.x][first.y]
	// .getColor());
	// return true;
	//
	// }
	// }

	public void generateAllBlocksAvailableMoves() {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				if (!this.getBoard().getBoardBlocks()[i][j].isEmpty()) {
					this.getBoard().getBoardBlocks()[i][j].getPiece()
							.generateAvailableBlocks(this.getBoard(),
									this.board.getBoardBlocks()[i][j]);
				}
			}
	}

	public boolean move(Block first, Block second) throws Exception {
		this.generateAllBlocksAvailableMoves();
		if (this.board.boardBlocks[first.getX()][first.getY()].getPiece()
				.getColor() != turn) {
			throw new FalseTurnException("it is not your turn");
		}
		if (!second.isEmpty()) {
			if (first.getPiece().getColor() == second.getPiece().getColor())
				throw new KhodieBawException("khodie baw!");
		}
		if (this.board.boardBlocks[first.getX()][first.getY()].isEmpty()) {
			throw new EmptyBlockException("You choose an empty block");
		}
		if (!first.getPiece().canMoveTo(second))
			throw new NotAvailableException("This block is not available");
		Piece p = null;
		if (!second.isEmpty()) {
			p = second.getPiece();
		}
		this.simpleMove(first, second);
		this.generateAllBlocksAvailableMoves();
		KingBlack KB;
		KingWhite KW;
		boolean isCheck = false;
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				Block e = this.getBoard().getBoardBlocks()[i][j];
				if (!e.isEmpty()) {
					if (e.getPiece().toString().equals("KB")) {
						KB = (KingBlack) e.getPiece();
						if (KB.isCheck(this.board, e)) {
							if (this.getTurn() == "B")
								isCheck = true;
						}
					}
					if (e.getPiece().toString().equals("KW")) {
						KW = (KingWhite) e.getPiece();
						if (KW.isCheck(this.board, e)) {
							if (this.getTurn() == "W")
								isCheck = true;
						}
					}
				}
			}
		if (isCheck) {
			this.simpleMove(second, first);
			if (p != null) {
				second.setPiece(p);
				second.setEmpty(false);
			}
			throw new KinCheckException("King is Check");
		}

		if (turn == 0)
			turn = 1;
		else
			turn = 0;
		return true;

	}

	public void simpleMove(Block first, Block second) {
		second.setEmpty(false);
		second.setPiece(first.getPiece());
		first.setEmpty(true);
		first.setPiece(null);
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
