package co.edu.cue.recursividad.application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class EjemlosBasicos{
	static int fib = 0;
	public static void main(String[] args) 
	{
		int n = 3;
		
		sumaN_Enteros(n);
//		calcularFactorial(n);
//		calcularFactorial_Iteractio(3);
//		System.out.println(fibonacci(n));
	}
	
	
//-----------------------------------------SUMA DE N NÚMEROS ENTEROS--------------------------------------
//--------------------------------------------------------------------------------------------------------	
	//Ejemplo suma de N numeros enteros
	public static int sumaN_Enteros(int n)
	{
		int resultado = 0;
		
		if(n == 1)
		{
			System.out.println("Resultado: "+n);
			return 1;
		}
		else
		{
			resultado = sumaN_Enteros(n-1) + n;
			System.out.println("Resultado: "+resultado);
			return resultado;
		}
		
	}

//-----------------------------------------CALCULAR FACTORIAL DE UN NÚMERO--------------------------------
//--------------------------------------------------------------------------------------------------------		
	
	public static int calcularFactorial(int n)
	{
		int resultado = 0;
		
		if(n==1)
		{
			return 1;
		}
		else
		{
			resultado = n * calcularFactorial(n-1);
			System.out.println("El resultado del calculo es: "+resultado);
			return resultado;
		}
	}

	
	
//-----------------------------------------CALCULAR FACTORIAL DE UN NÚMERO DE FORMA IETRACTIVA------------
//--------------------------------------------------------------------------------------------------------		
	
	public static void calcularFactorial_Iteractio(int n)
	{
		
		int fact = 1;
		
		
		for (int i = 1; i <= n; i++)
		{
			fact = i * fact;
			System.out.println("Valor del factorial de "+i+"!= "+fact);
		}
	}
	
//-----------------------------------------CALCULAR FIBONACCI--------------------------------------
//--------------------------------------------------------------------------------------------------------		
	public static int fibonacci(int n) 
	{
		if(n == 1 || n==0){
			return n;
		}
		else
		{
			return fibonacci(n-1)+ fibonacci(n-2);
		}
	}
}
