package ex5;

import static org.junit.Assert.*; // importa una classe static

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.*;

import ex2.Lloguer;
import ex2.Vehicle;
import ex3.Client;
import ex3.GestorLloguersLite;
import ex3.InformeDeClient;

public class ClientTest {
	// prueba con 1 alquiler de cada tipo
	@Test
	public void testInforme() {
		GestorLloguersLite gesLloguer = new GestorLloguersLite();
		Client client1 = gesLloguer.nouLloguer();
		
		assertEquals(new InformeDeClient(client1).informe(), GestorLloguersLite.historialLloguer(client1));
	}
	
	// sin ningun alquier
	@Test
	public void testInformeSenseLloguer() {
		Client clientPrincipal = new Client("123123X", "Alexander Vargas Pierola", "345345345");
		
		assertEquals(new InformeDeClient(clientPrincipal).informe(), GestorLloguersLite.historialLloguer(clientPrincipal));
	}
	
	// un alquiler de tipo basico de 1 dia
	@Test
	public void testInforme1LloguerBasic() {
		Client client1 = new Client("123123X", "Alexander Vargas Pierola", "345345345");
		
		// defino el formato de la fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

		// demostració de construcció d'un vehicle de categoria BASIC
		Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);

		// demostració de construccuó d'un lloguer amb una data
		Date date = null;
		try {
			date = dateFormat.parse("8/1/2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Lloguer lloguerBasic = new Lloguer(date, 1, vehicleBasic);
		
		client1.afegeix(lloguerBasic);
		
		assertEquals(new InformeDeClient(client1).informe(), GestorLloguersLite.historialLloguer(client1));
	}
	
	// un alquiler de tipo basico de 4 dias
	@Test
	public void testInforme1LloguerBasicB() {
		Client client1 = new Client("123123X", "Alexander Vargas Pierola", "345345345");
		
		// defino el formato de la fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

		// demostració de construcció d'un vehicle de categoria BASIC
		Vehicle vehicleBasic = new Vehicle("Opel", "Corsa", Vehicle.BASIC);

		// demostració de construccuó d'un lloguer amb una data
		Date date = null;
		try {
			date = dateFormat.parse("8/1/2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Lloguer lloguerBasic = new Lloguer(date, 4, vehicleBasic);
		
		client1.afegeix(lloguerBasic);
		
		assertEquals(new InformeDeClient(client1).informe(), GestorLloguersLite.historialLloguer(client1));
	}
	
	// alquiler de tipo general por 2 dias
	@Test
	public void testInforme1LloguerGeneral() {
		Client client1 = new Client("123123X", "Alexander Vargas Pierola", "345345345");
		
		// defino el formato de la fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

		// demostració de construcció d'un vehicle de categoria GENERAL
		Vehicle vehicleGeneral = new Vehicle("Volkswagen", "Golf R", Vehicle.GENERAL);

		// demostració de construccuó d'un lloguer amb una data
		Date date = null;
		try {
			date = dateFormat.parse("2/6/2018");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Lloguer lloguerGeneral = new Lloguer(date, 2, vehicleGeneral);
		
		client1.afegeix(lloguerGeneral);
		
		assertEquals(new InformeDeClient(client1).informe(), GestorLloguersLite.historialLloguer(client1));
	}
	
	// alquiler de tipo general por 5 dias
		@Test
		public void testInforme1LloguerGeneralB() {
			Client client1 = new Client("123123X", "Alexander Vargas Pierola", "345345345");
			
			// defino el formato de la fecha
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

			// demostració de construcció d'un vehicle de categoria GENERAL
			Vehicle vehicleGeneral = new Vehicle("Seat", "Leon", Vehicle.GENERAL);

			// demostració de construccuó d'un lloguer amb una data
			Date date = null;
			try {
				date = dateFormat.parse("7/8/2018");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Lloguer lloguerGeneral = new Lloguer(date, 5, vehicleGeneral);
			
			client1.afegeix(lloguerGeneral);
			
			assertEquals(new InformeDeClient(client1).informe(), GestorLloguersLite.historialLloguer(client1));
		}
	
	// alquiler de tipo lujo por 2 dias
	@Test
	public void testInforme1LloguerLuxe() {
		Client client1 = new Client("123123X", "Alexander Vargas Pierola", "345345345");
		
		// defino el formato de la fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

		// demostració de construcció d'un vehicle de categoria LUXE
		Vehicle vehicleLuxe = new Vehicle("McLaren", "Senna", Vehicle.LUXE);

		// demostració de construccuó d'un lloguer amb una data
		Date date = null;
		try {
			date = dateFormat.parse("8/1/2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Lloguer lloguerLuxe = new Lloguer(date, 2, vehicleLuxe);
		
		client1.afegeix(lloguerLuxe);
		
		assertEquals(new InformeDeClient(client1).informe(), GestorLloguersLite.historialLloguer(client1));
	}
	
	// alquiler de tipo lujo por 1 dia
	@Test
	public void testInforme1LloguerLuxeB() {
		Client client1 = new Client("123123X", "Alexander Vargas Pierola", "345345345");
		
		// defino el formato de la fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

		// demostració de construcció d'un vehicle de categoria LUXE
		Vehicle vehicleLuxe = new Vehicle("Lamborghini", "Huracan", Vehicle.LUXE);

		// demostració de construccuó d'un lloguer amb una data
		Date date = null;
		try {
			date = dateFormat.parse("8/2/2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Lloguer lloguerLuxe = new Lloguer(date, 1, vehicleLuxe);
		
		client1.afegeix(lloguerLuxe);
		
		assertEquals(new InformeDeClient(client1).informe(), GestorLloguersLite.historialLloguer(client1));
	}
	
	//Prueba a crear el informe HTML con un alquiler de cada tipo
	@Test
	public void testInformeHTML() {
		GestorLloguersLite gesLloguer = new GestorLloguersLite();
		Client client1 = gesLloguer.nouLloguer();
		
		assertEquals(new InformeDeClient(client1).informeHTML(), GestorLloguersLite.historialLloguerHTML(client1));
	}
	
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("TestPunt");
	}
}