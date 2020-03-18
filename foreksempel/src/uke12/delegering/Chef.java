package uke12.delegering;


/*
 * Grensesnittet som enhver kokk på oppfylle.
 * Hovedkokken ChefdelaChef og underkokkene fyller alle denne rollen.
 */
public interface Chef {
	public String makeMain();
	public String makePotatoes();
	public String makeSauce();
}
