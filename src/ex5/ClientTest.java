package ex5;

import static org.junit.Assert.*; // importa una classe static

import org.junit.*;

import ex3.Client;
import ex3.GestorLloguersLite;

public class ClientTest {
	@Test
	public void testInforme() {
		GestorLloguersLite gesLloguer = new GestorLloguersLite();
		Client client1 = gesLloguer.nouLloguer();
		
		assertEquals(client1.informe(), GestorLloguersLite.historialLloguer(client1));
	}
	
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("TestPunt");
	}
}