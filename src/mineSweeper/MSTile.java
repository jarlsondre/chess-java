package mineSweeper;

public class MSTile {
	// i denne klassen skal jeg ha en konstrukt�r for tiles.
		// Hver enkelt tile m� ha x- og ykoordinater slik at det
		// blir enklere � sjekke hvilke bomber som er i n�rheten. 
		// Jeg m� ha en boolean som sier noe om dette skal v�re en
		// bombe eller ikke. 
		
		private int x;
		private int y;
		private boolean bomb;
		private boolean opened;
		
		public MSTile(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + "), "+bomb;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public void setBomb(boolean a) {
			this.bomb = a;
		}
		public boolean getBomb() {
			return bomb;
		}
		public boolean getOpen() {
			return opened;
		}
		public void setOpen(boolean a) {
			this.opened = a;
		}
		
		

}
