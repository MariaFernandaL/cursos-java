package hilosSincronizacion;

public class BoundedSemaphore {

	private int señal = 0;
	private int bound   = 0;

	public BoundedSemaphore(int upperBound){
		this.bound = upperBound;
	}

	public synchronized void ocupar() throws InterruptedException{
		while(this.señal == bound){
			wait();
		}
		this.señal++;
		this.notify();
	}

	public synchronized void liberar() throws InterruptedException{
		while(this.señal == 0){
			wait();
		}
		this.señal--;
		this.notify();
	}
}
