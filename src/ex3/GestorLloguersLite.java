package ex3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ex2.Lloguer;
import ex2.Vehicle;

public class GestorLloguersLite {

	public Client nouLloguer() {
		// creo el cliente
		Client clientPrincipal = new Client("123123X", "Alexander Vargas Pierola", "345345345");

		// defino el formato de la fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

		// demostració de construcció d'un vehicle de categoria BASIC
		Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);

		// demostració de construccuó d'un lloguer amb una data
		Date date = null;
		try {
			date = dateFormat.parse("2/8/2013");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);

		// demostració de construcció d'un vehicle de categoria GENERAL
		Vehicle vehicleGeneral = new Vehicle("Nissan", "GT-R", Vehicle.GENERAL);

		// demostració de construccuó d'un lloguer amb una data
		Date dateB = null;
		try {
			dateB = dateFormat.parse("2/12/2013");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Lloguer lloguerGeneral = new Lloguer(dateB, 3, vehicleGeneral);

		// demostració de construcció d'un vehicle de categoria LUXE
		Vehicle vehicleLuxe = new Vehicle("Rolls Royce", "Phantom", Vehicle.LUXE);

		// demostració de construccuó d'un lloguer amb una data
		Date dateC = null;
		try {
			dateC = dateFormat.parse("8/1/2014");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Lloguer lloguerLuxe = new Lloguer(dateC, 2, vehicleLuxe);

		// asigno todos los alquileres previos a un cliente
		clientPrincipal.afegeix(lloguerBasic);
		clientPrincipal.afegeix(lloguerGeneral);
		clientPrincipal.afegeix(lloguerLuxe);

		return clientPrincipal;
	}

	public static String historialLloguer(Client client) {
		double total = 0;
		int bonificacions = 0;
		String resultat = "Informe de lloguers del client " + client.getNom() + " (" + client.getNif() + ")\n";
		for (Lloguer lloguer : client.getLloguers()) {
			double quantitat = 0;
			switch (lloguer.getVehicle().getCategoria()) {
			case Vehicle.BASIC:
				quantitat += 3;
				if (lloguer.getDies() > 3) {
					quantitat += (lloguer.getDies() - 3) * 1.5;
				}
				break;
			case Vehicle.GENERAL:
				quantitat += 4;
				if (lloguer.getDies() > 2) {
					quantitat += (lloguer.getDies() - 2) * 2.5;
				}
				break;
			case Vehicle.LUXE:
				quantitat += lloguer.getDies() * 6;
				break;
			}

			// afegeix lloguers freqüents
			bonificacions++;

			// afegeix bonificació per dos dies de lloguer de Luxe
			if (lloguer.getVehicle().getCategoria() == Vehicle.LUXE && lloguer.getDies() > 1) {
				bonificacions++;
			}

			// composa els resultats d'aquest lloguer
			resultat += "\t" + lloguer.getVehicle().getMarca() + " " + lloguer.getVehicle().getModel() + ": "
					+ (quantitat * 30) + "€" + "\n";
			total += quantitat * 30;
		}

		// afegeix informació final
		resultat += "Import a pagar: " + total + "€\n" + "Punts guanyats: " + bonificacions + "\n";
		return resultat;
	}
}
