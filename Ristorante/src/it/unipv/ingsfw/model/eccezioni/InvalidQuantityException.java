package it.unipv.ingsfw.model.eccezioni;

public class InvalidQuantityException extends Exception{
	public static final String MESSAGGIO_ERRORE = "Quantit� non valida";
	
	@Override
	public String getMessage() {
		return MESSAGGIO_ERRORE;
	}
}
