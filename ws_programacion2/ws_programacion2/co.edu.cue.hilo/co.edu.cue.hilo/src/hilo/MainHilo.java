package hilo;

public class MainHilo {

	public static void main(String[] args) {
		
		/*HiloPropio1 miHilo= new HiloPropio1();
		miHilo.runHilo("Hilo 1");
		
		Hilo2 miHilo2= new Hilo2();
		miHilo2.runHilo("Hilo 2 ");
		
		Hilo3 miHilo3= new Hilo3();
		miHilo3.runHilo("Hilo 3");*/
		
		ManejadorHilos manejadorHilos= new ManejadorHilos();
		manejadorHilos.runHiloServicio1(2);
		manejadorHilos.runHiloServicio2();
	}
}
