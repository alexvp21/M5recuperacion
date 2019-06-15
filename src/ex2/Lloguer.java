package ex2;

import java.util.Date;

public class Lloguer {
	private static final int QUANTITAT_VEHICLE_BASIC = 3;
	private static final int QUANTITAT_VEHICLE_GENERAL = 4;
	private static final int COMP_DIES_VEHIVLE_BASIC = 3;
	private static final int COMP_DIES_VEHIVLE_GENERAL = 2;
	private static final int COMP_DIES_VEHIVLE_LUXE = 6;
	
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
	
	public double preuLloguer() {
    	double preu = 0;
        switch (this.getVehicle().getCategoria()) {
            case Vehicle.BASIC:
            	preu += QUANTITAT_VEHICLE_BASIC;
                if (this.getDies() > COMP_DIES_VEHIVLE_BASIC) {
                	preu += (this.getDies() - COMP_DIES_VEHIVLE_BASIC) * 1.5;
                }
                break;
            case Vehicle.GENERAL:
            	preu += QUANTITAT_VEHICLE_GENERAL;
                if (this.getDies() > COMP_DIES_VEHIVLE_GENERAL) {
                	preu += (this.getDies() - COMP_DIES_VEHIVLE_GENERAL) * 2.5;
                }
                break;
            case Vehicle.LUXE:
            	preu += this.getDies() * COMP_DIES_VEHIVLE_LUXE;
                break;
        }
		return preu;
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
