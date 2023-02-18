package it.unipv.ingsfw.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import it.unipv.ingsfw.model.persone.Dipendente;
import it.unipv.ingsfw.model.ristorante.Ristorante;

public class DipendenteTest {
		private Ristorante r;
		private Dipendente d1;
	
		@Before
		public void initTest() {
			r = new Ristorante("asd", "ASD");
			d1 = r.creaDipendente("A");
		}


		@Test
		public void testIdentificatiDipendente() throws IOException {
			assertTrue(d1.identificati(r.getPassword()));
		}

		
	}


