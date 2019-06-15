package ex3;

import java.util.Vector;

import ex2.Lloguer;

public class Client {
	private static final double EUROS_PER_UNITAT_DE_COST = 30;
	private static final String DIVISA = "€";
	
    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }
    public Vector<Lloguer> getLloguers() {
        return this.lloguers;
    }
    
    public String informeHTML() {
    	return informeHTMLCapsalera() +
    			informeHTMLDetall() +
    			informeHTMLPeu();
    }
    
    public String informe() {
        return informeCapsalera() + 
        		informeDetall() + 
        		informePeu();
    }
    
    private String informeCapsalera() {
    	String resultat = "Informe de lloguers del client " +
        getNom() +
        " (" + getNif() + ")\n";
    	
    	return resultat;
    }
    
    private String informeDetall() {
    	String resultat = "";
    	for (Lloguer lloguer: lloguers) {
        	// composa els resultats d'aquest lloguer
            resultat += "\t" +
            lloguer.getVehicle().getMarca() +
            " " +
            lloguer.getVehicle().getModel() + ": " +
            (lloguer.preuLloguer() * EUROS_PER_UNITAT_DE_COST) + DIVISA + "\n";
        }
    	return resultat;
    }
    
    private String informePeu() {
    	String resultat = "Import a pagar: " + importTotal() + DIVISA+"\n" +
        "Punts guanyats: " + bonificacionsTotals() + "\n";
    	return resultat;
    }
    
    private String informeHTMLCapsalera() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("<h1>Informe de lloguers</h1>");
    	sb.append("<p>Informe de lloguers del client  <em>");
    	sb.append(getNom()).append("</em>");
    	sb.append("(<strong>").append(getNif()).append("</strong>)</p>");
    	
    	return sb.toString();
    }
    
    private String informeHTMLDetall() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("<table><tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>");
    	for (Lloguer lloguer: lloguers) {
            sb.append("<tr>");
            	sb.append("<td>");
            		sb.append(lloguer.getVehicle().getMarca());
            	sb.append("</td>");
            	sb.append("<td>");
        			sb.append(lloguer.getVehicle().getModel());
        		sb.append("</td>");
        		sb.append("<td>");
    				sb.append((lloguer.preuLloguer() * EUROS_PER_UNITAT_DE_COST) + DIVISA);
    			sb.append("</td>");
            sb.append("</tr>");
        }
    	sb.append("</table>");
    	return sb.toString();
    }
    
    private String informeHTMLPeu() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("<p>Import a pagar: <em>").append(importTotal() + DIVISA).append("</em></p>");
    	sb.append("<p>Punts guanyats: <em>").append(bonificacionsTotals()).append("</em></p>");
    	return sb.toString();
    }
    
    private double importTotal() {
    	double total = 0;
    	for (Lloguer lloguer: lloguers) {
    		total += lloguer.preuLloguer() * EUROS_PER_UNITAT_DE_COST;
    	}
    	return total;
    }
    
    private int bonificacionsTotals() {
    	int bonificacions = 0;
    	for (Lloguer lloguer: lloguers) {
    		bonificacions += lloguer.bonificacionsDeLloguer();
    	}
    	return bonificacions;
    }
}