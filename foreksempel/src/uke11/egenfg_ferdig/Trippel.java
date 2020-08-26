package uke11.egenfg_ferdig;


/* 
 * Et funksjonelt grensesnitt (FG) er et grensesnitt som har EN abstrakt metode - den skal
 * alts� ikke v�re implementert i grensesnittet men kun nevnt ved overskrift.
 * Vi har allerede en dr�ss med slike FG, men ingen av dem som tar inn 3 variable. 
 * Dette skal vi n� lage! 
 */
public interface Trippel {

	// Det eneste vi kan gj�re her. Det er opp til implementasjonen � kverne p� tallene.
	public int beregn(int a, int b, int c);
	
}
