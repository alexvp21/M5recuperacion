package ex2;

import java.util.Date;

public class Lloguer {
	private Date data;
	private Integer dies;
	private Vehicle vehicle;

	public Lloguer(Date data, Integer dies, Vehicle vehicle) {
		this.data = data;
		this.dies = dies;
		this.vehicle = vehicle;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getDies() {
		return dies;
	}

	public void setDies(Integer dies) {
		this.dies = dies;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public double quantitat() {
    	double quantitat = 0;
        switch (this.getVehicle().getCategoria()) {
            case Vehicle.BASIC:
                quantitat += 3;
                if (this.getDies() > 3) {
                    quantitat += (this.getDies() - 3) * 1.5;
                }
                break;
            case Vehicle.GENERAL:
                quantitat += 4;
                if (this.getDies() > 2) {
                    quantitat += (this.getDies() - 2) * 2.5;
                }
                break;
            case Vehicle.LUXE:
                quantitat += this.getDies() * 6;
                break;
        }
		return quantitat;
    }
	
	public Integer bonificacionsDeLloguer() {
    	/*como en cada alquiler se le sumaba siempre una bonificacion,
    	entonces ya inicio la variable en 1 y si cumple la condición sumara 1*/
    	Integer bonificacion = 1;
    	// afegeix bonificació per dos dies de lloguer de Luxe
        if (this.getVehicle().getCategoria() == Vehicle.LUXE &&
                this.getDies()>1 ) {
        	bonificacion ++;
        }
    	return bonificacion;
    }
}
