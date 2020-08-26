package uke12.exceptions;


/**
 * NorskeTallException er en måte å vise at man kan utvide et unntak til sitt eget,
 * og i Tall.java viser jeg hvordan dette kan utløses når man prøve å gjøre om
 * strengen 'åttifjørti' til et heltall.
 * @author borgeha
 *
 */
public class NorskeTallException extends NumberFormatException {

	public NorskeTallException() {
		super();
	}

	public NorskeTallException(String s) {
		super(s);
	}
	
}
