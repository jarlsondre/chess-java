package uke11.egenfg_ferdig;


/* 
 * Et funksjonelt grensesnitt (FG) er et grensesnitt som har EN abstrakt metode - den skal
 * altså ikke være implementert i grensesnittet men kun nevnt ved overskrift.
 * Vi har allerede en drøss med slike FG, men ingen av dem som tar inn 3 variable. 
 * Dette skal vi nå lage! 
 */
public interface Trippel {

	// Det eneste vi kan gjøre her. Det er opp til implementasjonen å kverne på tallene.
	public int beregn(int a, int b, int c);
	
}
