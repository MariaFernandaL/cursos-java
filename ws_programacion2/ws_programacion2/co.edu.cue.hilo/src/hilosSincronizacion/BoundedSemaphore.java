package hilosSincronizacion;

public class BoundedSemaphore {

	private int se�al = 0;
	private int bound   = 0;

	public BoundedSemaphore(int upperBound){
		this.bound = upperBound;
	}

	public synchronized void ocupar() throws InterruptedException{
		while(this.se�al == bound){
			wait();
		}
		this.se�al++;
		this.notify();
	}

	public synchronized void liberar() throws InterruptedException{
		while(this.se�al == 0){
			wait();
		}
		this.se�al--;
		this.notify();
	}
}
