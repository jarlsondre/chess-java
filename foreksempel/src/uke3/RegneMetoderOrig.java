package uke3;

public class RegneMetoderOrig {

	
	int a, b;
	
	// har ikke public eller slik først? Det kommer om det neste uke!
	int leggSammen() {
		return a+b;
	}
	
	int gang() {
		return a*b;
	}
	
	
	
	public RegneMetoderOrig(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		RegneMetoderOrig rm = new RegneMetoderOrig(3, 4);
		System.out.println(rm.leggSammen());
		System.out.println(rm.gang());

	}

}
