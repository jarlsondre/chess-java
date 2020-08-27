package sjakk;

public class Rounder {

    // if (tall % 50 < 25) {tall = (tall//50 + 1)*50 }
    // else tall = (tall//50)*50
	
	public static int round50(double num) {
		int numRet = 50;
		int negOrPos = 1;
		if (num < 0) negOrPos = -1;
		if (Math.abs(Math.round(num) % 50) > 24) numRet = (int) ((Math.round(num)/50 + negOrPos)*50);
		else numRet = (int) Math.round(num)/50 * 50;
		return numRet;
	}

	public static void main(String[] args) {
		System.out.println((-18)%15);
		
		System.out.println(round50(75));
	}
}
