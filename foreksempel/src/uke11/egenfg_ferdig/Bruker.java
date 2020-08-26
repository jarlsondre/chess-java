package uke11.egenfg_ferdig;

public class Bruker {

	int a, b, c;
	
	public int behandle(Trippel trippel) {
		return trippel.beregn(a, b, c);
	}
	
	
	public static void main(String[] args) {
		Bruker bruker = new Bruker(1, 2, 3);
		System.out.println("Pluss: " + bruker.behandle(new TrippelSumFG()));
		System.out.println("Ganger: " + bruker.behandle(new Trippel() {

			@Override
			public int beregn(int a, int b, int c) {
				return a * b * c;
			}
		}));
		System.out.println("Minus: " + bruker.behandle((a, b, c) -> a - b - c));
	}


	public Bruker(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

}
