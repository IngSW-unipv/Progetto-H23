package it.unipv.ingsfw.model.eccezioni;

public class NoIdentificatoException extends Exception {
	public static final String MESSAGGIO_ERRORE = "Identificazione fallita";

	@Override
	public String getMessage() {
		return MESSAGGIO_ERRORE;
	}
}


