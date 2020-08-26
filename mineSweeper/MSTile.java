package mineSweeper;

public class MSTile {
	// i denne klassen skal jeg ha en konstruktør for tiles.
		// Hver enkelt tile må ha x- og ykoordinater slik at det
		// blir enklere å sjekke hvilke bomber som er i nærheten. 
		// Jeg må ha en boolean som sier noe om dette skal være en
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
