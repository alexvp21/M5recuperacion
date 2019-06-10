package ex2;

public class Vehicle {
	private String model;
	private String marca;
	private Integer categoria;

	public Vehicle(String model, String marca, Integer categoria) {
		this.model = model;
		this.marca = marca;
		this.categoria = categoria;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

}
