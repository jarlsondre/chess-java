package uke2;

public class DownCounter {

	int counter = 0;

	
	public int getCounter() {
		return counter;
	}


	public static void main(String[] args) {	
		DownCounter dc = new DownCounter(4);
		System.out.println(dc.getCounter());

	}


	public DownCounter(int counter) {
		super();
		this.counter = counter;
	}

}
