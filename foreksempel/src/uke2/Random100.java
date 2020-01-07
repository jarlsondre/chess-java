package uke2;

import java.util.Random;

public class Random100 {

	
	public int getRandom100() {
		Random random = new Random();
		return random.nextInt(100);
	}
	
	
	public static void main(String[] args) {
		Random100 ra = new Random100();
		System.out.println(ra.getRandom100());

	}

}
