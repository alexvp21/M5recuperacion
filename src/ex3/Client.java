package ex3;

import java.util.Vector;

import ex2.Lloguer;

public class Client {
	public static final double EUROS_PER_UNITAT_DE_COST = 30;
	public static final String DIVISA = "€";
	
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
    	return new InformeDeClient(this).informeHTML();
    }
    
    public String informe() {
    	return new InformeDeClient(this).informe();
    }
}