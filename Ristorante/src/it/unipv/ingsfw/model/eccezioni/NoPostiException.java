package it.unipv.ingsfw.model.eccezioni;

public class NoPostiException extends Exception{
	public static final String MESSAGGIO_ERRORE = "Posti finiti!";
	
	@Override
	public String getMessage() {
		return MESSAGGIO_ERRORE;
	}
}
