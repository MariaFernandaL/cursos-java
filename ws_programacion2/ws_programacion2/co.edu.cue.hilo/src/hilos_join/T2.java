package hilos_join;

public class T2 extends Thread{
	
	private boolean runHilo;
	private int z;
	private int b;
	
	public T2(int z){
		this.z = z;
	}
	public void runHilo(){
		runHilo= true;
		this.start();
	}
	
	public void stopHilo(){
		runHilo=false;
	}
	@Override
	public void run() {
		b=z-1;
		System.out.println("Valor de b: "+b);
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
}
