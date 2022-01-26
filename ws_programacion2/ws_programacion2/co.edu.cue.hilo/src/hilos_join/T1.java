package hilos_join;

public class T1 extends Thread{

	private boolean runHilo;
	private int x,y;
	private int a;
	
	public T1(int x, int y){
		this.x=x;
		this.y=y;
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
		a = x + y;
		System.out.println("Valor de a: "+a);
	}
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
}
