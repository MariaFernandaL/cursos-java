package co.edu.cue.lab.model;

public class Elemento {

	private String nombreElemento;
	private String codigo;
	private int cantElemento;
	private int cantStock;
	private boolean estado;
	
	
	
	
	public Elemento() {
		
	}

	public Elemento(String nombreElemento, String codigo, int cantElemento, int cantStock) {
		super();
		this.nombreElemento = nombreElemento;
		this.codigo = codigo;
		this.cantElemento = cantElemento;
		this.cantStock= cantStock;
	}




	public String getNombreElemento() {
		return nombreElemento;
	}




	public void setNombreElemento(String nombreElemento) {
		this.nombreElemento = nombreElemento;
	}




	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}




	public int getCantElemento() {
		return cantElemento;
	}




	public void setCantElemento(int cantElemento) {
		this.cantElemento = cantElemento;
	}



	public int getCantStock() {
		return cantStock;
	}

	public void setCantStock(int cantStock) {
		this.cantStock = cantStock;
	}

	
	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	
	
	
}
