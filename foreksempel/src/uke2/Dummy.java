package uke2;

public class Dummy {

	int foo = 12;
	
	private void fun(int bar) {
		System.out.println(bar*2);
	}
	
	public static void main(String[] args) {
		
		Dummy d = new Dummy();
		d.fun(d.foo);
		
	}

}
