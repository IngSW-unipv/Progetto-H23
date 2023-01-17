package it.unipv.ingsfw.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.ristorante.Ristorante;

public class ClienteTest {

	private Ristorante r;
	private Cliente c1, c2, c3;
	@Before
	public void initTest() {
		r = new Ristorante("asd", "ASD");
		c1 = new Cliente("A");
		c2 = new Cliente("B");
		c3 = new Cliente("C");
	}
	
	
	@Test
	public void testPrenotazioneCliente() throws IOException {
		r.prenotaCliente(c1, 100);
		r.prenotaCliente(c2, 2);
		r.prenotaCliente(c3, 5);
		
		assertTrue(c1.accediPrenotazione(r.getPrenotazioni())&&c2.accediPrenotazione(r.getPrenotazioni())&&c3.accediPrenotazione(r.getPrenotazioni()));
	}
	
	
	@Test
	public void testPostiFiniti() {
		r.setPostiLiberi(r.NUMERO_POSTI);
		assertFalse(r.prenotaCliente(c2, 502));
		assertFalse(r.prenotaCliente(c1, r.NUMERO_POSTI+1));
	}
	
	@Test
	public void testPostiFiniti2() {
		r.setPostiLiberi(r.NUMERO_POSTI);
		assertTrue(r.prenotaCliente(c2, 0));
		assertTrue(r.prenotaCliente(c3, r.NUMERO_POSTI));
		assertFalse(r.prenotaCliente(c1, r.NUMERO_POSTI-1));
	}

}
