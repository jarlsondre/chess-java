package uke3;

public class Regne {

	// De to tallene:
	int a, b;
	
	public Regne(int aa, int b) {
		super();
		a = aa;
		this.b = b;
	}

	public int gang() {
		return a*b;
	}

	public int pluss() {
		return a+b;		
	}
	
	public static void main(String[] args) {
		Regne r = new Regne(3,5);
		System.out.println(r.gang());
		System.out.println(r.pluss());
	}

}
