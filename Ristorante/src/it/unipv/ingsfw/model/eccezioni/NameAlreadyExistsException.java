package it.unipv.ingsfw.model.eccezioni;

public class NameAlreadyExistsException extends Exception{
	public static final String MESSAGGIO_ERRORE = "Nome già inserito";

	@Override
	public String getMessage() {
		return MESSAGGIO_ERRORE;
	}
}
