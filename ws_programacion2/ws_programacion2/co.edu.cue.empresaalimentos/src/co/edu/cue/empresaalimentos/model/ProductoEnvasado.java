package co.edu.cue.empresaalimentos.model;

public class ProductoEnvasado extends Producto{

	private String fechaEnvasado;
	private double pesoEnvase;
	private Pais paisOrigen;
	public String getFechaEnvasado() {
		return fechaEnvasado;
	}
	public void setFechaEnvasado(String fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	public double getPesoEnvase() {
		return pesoEnvase;
	}
	public void setPesoEnvase(double pesoEnvase) {
		this.pesoEnvase = pesoEnvase;
	}
	public Pais getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(Pais paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
}
