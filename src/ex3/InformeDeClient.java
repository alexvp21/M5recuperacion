package ex3;

import java.util.ArrayList;
import java.util.List;

import ex2.Lloguer;

public class InformeDeClient {
	private Client client;
	
	public InformeDeClient(Client client) {
		this.client = client;
	}
	
	public String informeHTML() {
    	return informeHTMLCapsalera(client) +
    			informeHTMLDetall(client) +
    			informeHTMLPeu(client);
    }
    
    public String informe() {
    	return setDatosInforme(client, informeCapsalera(), informeDetall(client), informePeu());
    }
    
    private String setDatosInforme(Client client, String cabecera, String detalle, String pie) {
    	String nombre = client.getNom();
    	String nif = client.getNif();
    	List<InformacioLloguer> listaInfoLloguer = new ArrayList<InformacioLloguer>();
    	for (Lloguer lloguer: client.getLloguers()) {
    		InformacioLloguer infoLloguer = new InformacioLloguer();
    		infoLloguer.setMarca(lloguer.getVehicle().getMarca());
    		infoLloguer.setModel(lloguer.getVehicle().getModel());
    		infoLloguer.setPreu(lloguer.preuLloguer() * Client.EUROS_PER_UNITAT_DE_COST);
    		listaInfoLloguer.add(infoLloguer);
        }
    	double total = importTotal(client);
    	int bonificacions = bonificacionsTotals(client);
    	return null;
    }
    
    private String informeCapsalera() {
    	String resultat = "Informe de lloguers del client %s" +
        " (%s)%n";
    	
    	return resultat;
    }
    
    private String informeDetall(Client client) {
    	String resultat = "";
    	for (Lloguer lloguer: client.getLloguers()) {
        	// composa els resultats d'aquest lloguer
            resultat += "\t %s %s: %s" + Client.DIVISA + "\n";
        }
    	return resultat;
    }
    
    private String informePeu() {
    	String resultat = "Import a pagar: %s" + Client.DIVISA+"\n" +
        "Punts guanyats: %s" + "\n";
    	return resultat;
    }
    
    private String informeHTMLCapsalera(Client client) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("<h1>Informe de lloguers</h1>");
    	sb.append("<p>Informe de lloguers del client  <em>");
    	sb.append(client.getNom()).append("</em>");
    	sb.append("(<strong>").append(client.getNif()).append("</strong>)</p>");
    	
    	return sb.toString();
    }
    
    private String informeHTMLDetall(Client client) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("<table><tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>");
    	for (Lloguer lloguer: client.getLloguers()) {
            sb.append("<tr>");
            	sb.append("<td>");
            		sb.append(lloguer.getVehicle().getMarca());
            	sb.append("</td>");
            	sb.append("<td>");
        			sb.append(lloguer.getVehicle().getModel());
        		sb.append("</td>");
        		sb.append("<td>");
    				sb.append((lloguer.preuLloguer() * Client.EUROS_PER_UNITAT_DE_COST) + Client.DIVISA);
    			sb.append("</td>");
            sb.append("</tr>");
        }
    	sb.append("</table>");
    	return sb.toString();
    }
    
    private String informeHTMLPeu(Client client) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("<p>Import a pagar: <em>").append(importTotal(client) + Client.DIVISA).append("</em></p>");
    	sb.append("<p>Punts guanyats: <em>").append(bonificacionsTotals(client)).append("</em></p>");
    	return sb.toString();
    }
    
    private double importTotal(Client client) {
    	double total = 0;
    	for (Lloguer lloguer: client.getLloguers()) {
    		total += lloguer.preuLloguer() * Client.EUROS_PER_UNITAT_DE_COST;
    	}
    	return total;
    }
    
    private int bonificacionsTotals(Client client) {
    	int bonificacions = 0;
    	for (Lloguer lloguer: client.getLloguers()) {
    		bonificacions += lloguer.bonificacionsDeLloguer();
    	}
    	return bonificacions;
    }
}
