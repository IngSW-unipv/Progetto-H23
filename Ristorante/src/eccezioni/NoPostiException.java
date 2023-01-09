package eccezioni;

public class NoPostiException extends Exception{
	public final String MESSAGGIO_DI_ERRORE="Posti finiti";
	
	public void stampaErrore() {
		System.out.println(MESSAGGIO_DI_ERRORE);
	}
}
