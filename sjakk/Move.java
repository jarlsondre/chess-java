package sjakk;

public class Move {
	private int x;
	private int y;
	
	public Move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		Move check = (Move) obj;
		return (check.getX() == this.getX() && check.getY() == this.getY());
	}
	
}
