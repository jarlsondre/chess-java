package uke3;

public class CounterOrig {


	private int end;
	private int counter = 1;

	public CounterOrig(int max) {
		end = max; 
	}

	public int getCounter() {
		return counter;
	}

	public boolean count() {
		if (counter < this.end) {
			counter++;
			return true;
		}
		return false;
	}

	public boolean count(int inc) {
		if (counter+inc <= this.end) {
			counter += inc;
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		CounterOrig c = new CounterOrig(10);
		System.out.println(c.getCounter());
//		while (c.count()) {
//			System.out.println(c.getCounter());
//		}
		c.count(5);
		System.out.println(c.getCounter());
		c.count(4);
		System.out.println(c.getCounter());
	}
}
