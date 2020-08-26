package uke4;

public class A {

	private int tall = 12;

	public int getTall() {
		return tall;
	}

	public void setTall(int tall) {
		if (tall > 10) {
			throw new IllegalArgumentException("Tallet er for stort.");
		}
		this.tall = tall;
	}
	
	
}
