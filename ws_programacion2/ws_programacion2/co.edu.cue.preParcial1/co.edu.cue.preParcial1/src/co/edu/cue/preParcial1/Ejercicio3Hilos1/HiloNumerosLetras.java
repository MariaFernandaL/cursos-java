package co.edu.cue.preParcial1.Ejercicio3Hilos1;

public class HiloNumerosLetras implements Runnable{

	private int tipo;
	private String nombreHilo;
	private boolean runHilo;

	public HiloNumerosLetras() {

	}

	public HiloNumerosLetras(int tipo) {
		this.tipo = tipo;
	}

	public void runHilo(String nombreHilo){
		runHilo= true;
		this.nombreHilo=nombreHilo;
		this.run();
	}
	
	@Override
	public void run() {
		while (runHilo==true) {
			switch (tipo) {
			case 1:
				for (int i = 0; i < 30; i++) {
					System.out.println(i);
				}
				break;
			case 2:
				for (char c = 'a'; c <= 'z'; c++) {
					System.out.println(c);
				}
				break;
			default:
				break;
			}
			runHilo=false;
		}
		
	}	
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public boolean isRunHilo() {
		return runHilo;
	}

	public void setRunHilo(boolean runHilo) {
		this.runHilo = runHilo;
	}
	
	
	
}
