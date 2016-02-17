package ir.sharif.ce.javaclass.chess.block;

import ir.sharif.ce.javaclass.chess.pieces.Piece;

public class Block {
	private int x;
	private int y;
	private boolean isEmpty;

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	private int color; // 0->white & 1->black
	private Piece piece;
	private String blockIcon;

	public String getBlockIcon() {
		return blockIcon;
	}

	public void setBlockIcon(String blockIcon) {
		this.blockIcon = blockIcon;
	}

	public Block(int x, int y, int color, Piece piece) {
		this.setEmpty(false);
		this.setColor(color);
		this.setX(x);
		this.setY(y);
		this.setPiece(piece);
	}

	public Block(int x, int y, int color) {
		this.setEmpty(true);
		this.piece = null;
		this.setColor(color);
		this.setX(x);
		this.setY(y);
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String toString() {
		if (this.isEmpty) {
			if (this.color == 0)
				return "(" + this.x + " , " + this.y + ") " + "W" + "Empty";
			else
				return "(" + this.x + " , " + this.y + ") " + "B" + "Empty";
		} else {
			if (this.color == 0)
				return "(" + this.x + " , " + this.y + ") " + "W"
						+ this.piece.toString();
			else
				return "(" + this.x + " , " + this.y + ") " + "B"
						+ this.piece.toString();
		}
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Block other = (Block) obj;
		if (color != other.color)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public static boolean isOutOfRange(int x, int y) {
		if (x > 7)
			return true;
		if (x < 0)
			return true;
		if (y > 7)
			return true;
		if (y < 0)
			return true;
		return false;

	}

}
