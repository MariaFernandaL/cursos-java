package hilosSincronizacion;

public class MainHilo {

	public static void main(String[] args) {			
			
		ManejadorHilos manejadorHilos = new ManejadorHilos();
			manejadorHilos.runHiloServicio1(2);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			manejadorHilos.runHiloServicio2();
		}

	}
