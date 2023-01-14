package it.unipv.ingsfw.model.eccezioni;

public class PiattoFinitoException extends Exception {
public static final String MESSAGGIO_ERRORE = "Piatto finito!";
	
	@Override
	public String getMessage() {
		return MESSAGGIO_ERRORE;
	}
}
