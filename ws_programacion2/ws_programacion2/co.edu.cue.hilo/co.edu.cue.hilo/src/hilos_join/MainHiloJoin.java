package hilos_join;

public class MainHiloJoin {

	public static void main(String[] args) {

		int c=0;
		int w=0;
		
		T1 t1= new T1(5,4);
		T2 t2= new T2(3);
		
		t1.runHilo();
		t2.runHilo();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		c=t1.getA()-t2.getB();
		System.out.println("Valor de C: "+c);
		
		w=c+1;
		System.out.println("Valor de w: "+w);
	}

}
