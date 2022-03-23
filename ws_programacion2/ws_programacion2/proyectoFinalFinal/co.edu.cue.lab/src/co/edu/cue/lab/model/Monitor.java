package co.edu.cue.lab.model;

public class Monitor extends Estudiante{

	private String salario;
	private String user;
	private String password;

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Monitor() {
		
	}
	
	
	public Monitor(String documento, String nombre, String apellido, String genero, String ciudadResidencia,
			TipoDocumento tipoDocumento, String direccion,String salario, String user, String password) {
		super(documento, nombre, apellido, genero, ciudadResidencia, tipoDocumento, direccion);
		this.salario = salario;
		this.user = user;
		this.password = password;
	}
	
	
	
	
}
