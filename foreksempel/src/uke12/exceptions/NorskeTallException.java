package uke12.exceptions;


/**
 * NorskeTallException er en m�te � vise at man kan utvide et unntak til sitt eget,
 * og i Tall.java viser jeg hvordan dette kan utl�ses n�r man pr�ve � gj�re om
 * strengen '�ttifj�rti' til et heltall.
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
