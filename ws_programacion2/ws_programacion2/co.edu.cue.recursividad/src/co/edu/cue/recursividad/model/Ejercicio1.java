package co.edu.cue.recursividad.model;

import javax.swing.JOptionPane;

public class Ejercicio1 {

	public static void main(String[] args) {
		int n1=Integer.parseInt(JOptionPane.showInputDialog("Digite un numero de mas de 2 cifras"));
		System.out.println("La cantidad de cifras en el numero son: "+numero_Cifras(n1));
	}
	public static int numero_Cifras(int n){
		int contador=0;
		
		if (n<10) {
			return 1;
		} else {
			contador= 1+numero_Cifras(n/10);
			return contador;
		}
	}
}
