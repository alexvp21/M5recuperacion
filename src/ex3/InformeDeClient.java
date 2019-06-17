package ex3;

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
        return informeCapsalera(client) + 
        		informeDetall(client) + 
        		informePeu(client);
    }
    
    private String informeCapsalera(Client client) {
    	String resultat = "Informe de lloguers del client " +
		client.getNom() +
        " (" + client.getNif() + ")\n";
    	
    	return resultat;
    }
    
    private String informeDetall(Client client) {
    	String resultat = "";
    	for (Lloguer lloguer: client.getLloguers()) {
        	// composa els resultats d'aquest lloguer
            resultat += "\t" +
            lloguer.getVehicle().getMarca() +
            " " +
            lloguer.getVehicle().getModel() + ": " +
            (lloguer.preuLloguer() * Client.EUROS_PER_UNITAT_DE_COST) + Client.DIVISA + "\n";
        }
    	return resultat;
    }
    
    private String informePeu(Client client) {
    	String resultat = "Import a pagar: " + importTotal(client) + Client.DIVISA+"\n" +
        "Punts guanyats: " + bonificacionsTotals(client) + "\n";
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
