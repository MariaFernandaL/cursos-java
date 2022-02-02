package co.edu.cue.tallerApropiacion.model;

import javax.swing.JOptionPane;

public class EjercicioApropiacion {

	public String ejercicio1() {
	int numeroAzar=(int) Math.floor(Math.random()*(100-1)+1);
	JOptionPane.showMessageDialog(null,"El numero es: "+numeroAzar);
		for (int i=0; i<3; i++) {
			int numeroUsua=Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));
			if (numeroUsua==numeroAzar) {
				return "Ganaste";
			}
			else {
				JOptionPane.showMessageDialog(null,"Sigue Intentando");
			}
			}
		
		return"No lograste adivinar, el numero al azar era: "+numeroAzar;
	}
	
	
	
	public String ejercicio2() {
		
		int[] arreglo=new int [10];
		
		
		for (int i=0; i<arreglo.length;i++) {
			arreglo[i]=Integer.parseInt(JOptionPane.showInputDialog("Digite el numero para la posicion "+(i+1)));
		}
		
		JOptionPane.showMessageDialog(null,"Estos son los elementos del arreglo: ");
		for (int i=0;i<arreglo.length;i++) {
			JOptionPane.showMessageDialog(null, "El dato almacenado en la posicion "+(i+1)+" es: "+arreglo[i]);
			
		}
		calcularPrimos(arreglo);
		calcularMayor(arreglo);
		arregloInvertido(arreglo);
		calcularSumaImpares(arreglo);
		calcularPorcentajesPar(arreglo);
		
		return "";
		
	}
	
	
	
	// FUNCION calcularMayor
	 public String calcularMayor(int [] arreglo2) {
		 int indiceMayor=0;	
		 for (int i = 0; i<arreglo2.length; i++) {

				if (arreglo2[i]> arreglo2[indiceMayor]) {
					indiceMayor=i;
				}
		
			}
			int mayor=arreglo2[indiceMayor];
			JOptionPane.showMessageDialog(null,"El mayor es: "+ mayor+" y se encuentra en la posicion: "+(indiceMayor+1));
			
			return " ";
			
	 }
			
	 
	// FUNCION calcularSumaImpares
	 public String calcularSumaImpares(int [] arreglo2) {
		int impar=0,sumaImpar=0;
		
		for (int i = 0; i<arreglo2.length; i++) {
			if (i%2!=0) {
				impar++;
				sumaImpar+=arreglo2[i];
			}
	
		}
		JOptionPane.showMessageDialog(null, "La suma total de los numeros en las posiciones impares es: "+sumaImpar);
		return " ";
	 }
	 
	 
	//FUNCION calcularPorcentajePar
	
	public String calcularPorcentajesPar(int [] arreglo2) {
		
		int par=0;
		
		for (int i = 0; i<arreglo2.length; i++) {
			
			if (arreglo2[i]%2==0) {
				par++;
			}
		}
		JOptionPane.showMessageDialog(null, "El porcentaje de numeros pares es: "+(par*10)+"%"); 
		return " ";
	}
	
		// FUNCION arregloInvertido
	public String arregloInvertido(int [] arreglo2) {
		
		int[] invertido = new int[arreglo2.length];
       
	
		for (int i=arreglo2.length-1, j=0; i>=0; --i , ++j) {
			invertido[j]=arreglo2[i];
			
		}
		for (int i=0; i<invertido.length; i++) {
			JOptionPane.showMessageDialog(null, "El arreglo invertido en la posicion: "+(i+1)+" es: "+invertido[i]);
			
	}
		return " ";
	}
	
			
			
	//FUNCION calcularPrimos
	public String calcularPrimos(int [] arreglo2) {
		
		int contador=0;
		int divisores=0;
		for (int i=0; i<arreglo2.length; i++) {
			divisores=0;
			for (int j = 1; j<=arreglo2[i];j++) {
				if (arreglo2[i]%j==0) {
					divisores++;
				}
			}
			if (divisores==2) {
				contador++;
			}
		}
		
		JOptionPane.showMessageDialog(null, "La cantidad de numeros primos es: "+contador);
		return " ";
	}
	
	

	public String ejercicio3() {
		
		int nElementos=Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño del arreglo"));
		int[] arreglo=new int [nElementos];
		int ultimo;
		
		for (int i=0; i<arreglo.length;i++) {
			arreglo[i]=Integer.parseInt(JOptionPane.showInputDialog("Digite el numero para la posicion "+(i+1)));
		}
		
		JOptionPane.showMessageDialog(null,"Estos son los elementos del arreglo: ");
		for (int i=0;i<arreglo.length;i++) {
			JOptionPane.showMessageDialog(null, "El dato almacenado en la posicion "+(i+1)+" es: "+arreglo[i]);
			
		}
		
		ultimo=arreglo[arreglo.length-1];
		
		for(int i=arreglo.length-2;i>=0; i--) {
			arreglo[i+1]=arreglo[i];
			
		}
		
		arreglo[0]=ultimo;
		
		for (int i=0; i<arreglo.length; i++) {
			JOptionPane.showMessageDialog(null, "Los datos desplazados 1 unidad hacia abajo son: "+arreglo[i]);
		}
		
		return "";
	}

	public String ejercicio4() {
		
		String sCadena = "Holacomoestas";
		int contador=0;
		char[] arregloCadena = sCadena.toCharArray();

		for (int i=0;i<arregloCadena.length;i++) {
			JOptionPane.showMessageDialog(null, ((i+1)+". "+arregloCadena[i]));
	}
		
		for (int i=0;i<arregloCadena.length;i++) {
			if (arregloCadena[i]!='a' && arregloCadena[i]!='e' && arregloCadena[i]!='i' &&arregloCadena[i]!='o' && arregloCadena[i]!='u' ) {
				JOptionPane.showMessageDialog(null, "En esta posicion no hay vocal");
			}else {
				JOptionPane.showMessageDialog(null, "En esta posicion si hay vocal y es: "+arregloCadena[i]);
				contador++;
			}
	}
		JOptionPane.showMessageDialog(null, "La cantidad de vocales es: "+contador);
		return " ";
	}

	
	
	
	
	public String ejercicio5() {
		
		int nElementos=Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño del arreglo"));
		String [] cadena1=new String[nElementos];
		
		for (int i=0; i<cadena1.length;i++) {	
			cadena1[i]=JOptionPane.showInputDialog("Digite las palabras del arreglo en la posicion "+(i+1)+". ");
		}
		
		JOptionPane.showMessageDialog(null,"Estos son los elementos del arreglo: ");
		for (int i=0;i<cadena1.length;i++) {
			JOptionPane.showMessageDialog(null, "El dato almacenado en la posicion "+(i+1)+" es: "+cadena1[i]);
	}
		
		
		 String aux;
		for (int i =0; i<cadena1.length;i++) {
			for(int j=0; j<cadena1.length-1; j++) { 
			if (cadena1[j].compareTo( cadena1[j+1] ) > 0) {
				aux= cadena1[j]; 
	            cadena1[j]  = cadena1[j+1]; 
	            cadena1[j+1]= aux; 
			}
			
			}
		}
		JOptionPane.showMessageDialog(null, " En orden decreciente el arreglo queda: ");
		for (int i =cadena1.length-1; i>=0;i--) {
			JOptionPane.showMessageDialog(null,cadena1[i]);
	
		}
		 return " ";
	}	
	
	
	public String ejercicio6() {
		
		int nElementos=Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño del arreglo restandole 2"));
		int [] arregloNum=new int[nElementos+2];
		boolean creciente=true;
		
		do {
			for (int i = 0; i<arregloNum.length; i++) {
				arregloNum[i]= Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "+(i+1)));
			}
			for (int i = 0; i<arregloNum.length-1; i++) {
				if (arregloNum[i]< arregloNum[i+1]) {
					creciente=true;
					
				} else if (arregloNum[i]>arregloNum[i+1]) {
					creciente=false;
					break;
				}
			}
			if (creciente == false) {
				JOptionPane.showMessageDialog(null, "El arreglo no esta ordenado");
			}
		} while (creciente == false);
		
		ejercicio7(arregloNum);
		
		
		
		
		int numeroInsert=Integer.parseInt(JOptionPane.showInputDialog("Digite el numero para insertar"));
		int posicion_numeros=0, j=0;
		
		while (arregloNum[j]<numeroInsert && j<arregloNum.length) {
			posicion_numeros++;
			j++;	
		}
		
		for (int i=nElementos; i>=posicion_numeros;i--) {
			arregloNum[i+1]=arregloNum[i];
			
		}
		
		arregloNum[posicion_numeros]=numeroInsert;
		
		
		JOptionPane.showMessageDialog(null, "El arreglo con el elemento agregado es: ");
		
		for (int i=0; i<arregloNum.length;i++) {
			JOptionPane.showMessageDialog(null, arregloNum[i]);
		}
		return " ";
		
		
	}
	
	
	
	
	public String ejercicio7(int [] arreglo2) {
		
		
		int numberSearch=Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a buscar"));
		
		int i=0;
		
		while(i<arreglo2.length && arreglo2[i]<numberSearch) {
			i++;
		}
		if(i==arreglo2.length) {
			JOptionPane.showMessageDialog(null,"El numero no se encontro" );
		}
		else {
			if(arreglo2[i]==numberSearch) {
				JOptionPane.showMessageDialog(null,"numero encontrado y está y en la posición:" +i);
			}
			else {
				JOptionPane.showMessageDialog(null,"El numero no se encontro" );

			}
		}
		
		return " ";
		
		
	}
	


	
	
	
	
	//MATRICES
	
	
	public void matriz1() {
		int filas= Integer .parseInt(JOptionPane.showInputDialog("ingrese la cantidad de filas que desea"));
		int columnas= Integer .parseInt(JOptionPane.showInputDialog("ingrese la cantidad de columnas que desea"));
		
		int matriz[][]= new int[filas][columnas];
		
		for(int i=0; i<matriz.length;i++) {
			for(int j=0;j<columnas;j++) {
				matriz[i][j]=Integer .parseInt(JOptionPane.showInputDialog("ingrese los numeros que desea encontrar en la matriz"));
			}
		}
		
		JOptionPane.showMessageDialog(null,"la matriz creada por el usuario fue:");
	
		for(int i=0;i<matriz.length;i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println("");
			
	}
		//ejercicio1Matriz(matriz,filas,columnas);
		//ejercicio3Matriz(matriz, filas, columnas);
		//ejercicio4Matriz(matriz, filas, columnas);
		ejercicio7Matriz(matriz, filas, columnas);
	}
	
	
	
	
	public String ejercicio1Matriz(int matrizEje1[][], int filitas, int columnas) {
		
		int elementoMayor=matrizEje1[0][0];
		int posicionFila=0;
		int posicionColumna=0;
		
		for (int i=0; i<filitas;i++) {
			for (int j = 0; j <columnas; j++) {
				if (matrizEje1[i][j]>elementoMayor) {
					elementoMayor=matrizEje1[i][j];
					posicionFila=i;
					posicionColumna=j;
				}
			}
			
		}
		JOptionPane.showMessageDialog(null, "El elemento mayor de la matriz es: "+elementoMayor+" en la fila "+(posicionFila+1)+" y en la columna "+(posicionColumna+1) );
		
		return " ";
		
		
	}
	
	public String ejercicio2Matriz() {
		
		int matrizita[][]= new int[5][5];
		for(int i=0; i<5;i++) {
			for(int j=0;j<5;j++) {
				matrizita[i][j]=Integer .parseInt(JOptionPane.showInputDialog("ingrese los numeros que desea encontrar en la matriz"));
			}
		}
		
		JOptionPane.showMessageDialog(null,"la matriz creada por el usuario fue:");
	
		for(int i=0;i<5;i++) {
			for (int j = 0; j <5; j++) {
				System.out.print(matrizita[i][j]+" ");
			}
			System.out.println("");
			
	}
		ejercicio1Matriz(matrizita, 5, 5);
		return " ";
	}
	
	
	public String ejercicio3Matriz(int matrizEje1[][], int filitas, int columnas) {
		
	int dato=1;
	
	for(int i=0; i<filitas;i++) {
		for(int j=0;j<columnas;j++) {
			matrizEje1[i][j]=dato;
			dato++;
	}
		}
	
	int diagonalPrincipal[]= new int[matrizEje1.length];
	
	for(int i=0; i<filitas;i++) {
		for(int j=0;j<columnas;j++) {
			if (i==j) {
				diagonalPrincipal[i]=matrizEje1[i][j];
			} 
	}
		}
	
	int suma=0;
	for (int elemento:diagonalPrincipal) {
		suma=suma+elemento;
	}
	JOptionPane.showMessageDialog(null, "La suma de la diagonal principal es: es: "+suma);
		 return " ";
	}
	
	
	public String ejercicio4Matriz(int matrizEje1[][], int filitas, int columnas) {
		
		int aux;
		for(int i=0;i<filitas;i++) {
			for(int j=0;j<i;j++) {
			aux= matrizEje1[i] [j];
			matrizEje1[i] [j]=matrizEje1[j] [i];
			matrizEje1[j] [i]=aux;
	}
		
				
}
	System.out.println("la matriz inversa  es:");
	for(int i=0;i<filitas;i++) {
		for(int j=0;j<columnas;j++) {
			System.out.print(matrizEje1[i][j]+" ");	
	}
		System.out.println("");
}
		
		return " ";
	}
	
	public String ejercicio5Matriz() {
		
		boolean simetrica=true;
		
		int matriza[][]= new int[4][4];
		for(int i=0; i<4;i++) {
			for(int j=0;j<4;j++) {
				matriza[i][j]=Integer.parseInt(JOptionPane.showInputDialog("ingrese los numeros que desea encontrar en la matriz:"));
			}
		}
		
		int i=0,j;
		while(i<4 && simetrica==true) {
			j=0;
			while(j<i && simetrica==true) {
				if(matriza[i][j]!=matriza[j][i]) {
					simetrica=false;
				}
				j++;
			}
			i++;
		}
		if(simetrica==true) {
			JOptionPane.showMessageDialog(null,"la matriz es simetrica");
		}else {
			JOptionPane.showMessageDialog(null,"la matriz no es simetrica");
		}
		return " ";
		
	}
	
	public String ejercicio6Matriz() {
		int filas= Integer .parseInt(JOptionPane.showInputDialog("ingrese la cantidad de filas que desea en la matriz A"));
		int columnas= Integer .parseInt(JOptionPane.showInputDialog("ingrese la cantidad de columnas que desea en la matriz A"));
		int numeroresultante[][]=new int[filas][columnas];
		
		int matriz[][]= new int[filas][columnas];
		
		for(int i=0; i<filas;i++) {
			for(int j=0;j<columnas;j++) {
				matriz[i][j]=Integer .parseInt(JOptionPane.showInputDialog("ingrese los numeros que desea encontrar en la matriz A"));
			}
		}
		
		int matriz2[][]= new int[filas][columnas];
		
		for(int i=0; i<filas;i++) {
			for(int j=0;j<columnas;j++) {
				matriz2[i][j]=Integer .parseInt(JOptionPane.showInputDialog("ingrese los numeros que desea encontrar en la matriz B"));
			}
		}
		
		
		//sumo matrices
		for(int i=0;i<matriz.length;i++) {
			for (int j = 0; j < matriz2.length; j++) {
				numeroresultante[i][j]=matriz[i][j]+matriz2[i][j];
			}
		
		}
		
		//imprimo matrices
		for(int i=0;i<matriz.length;i++) {
			
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			
			if (i==1) {
				System.out.print("  +  ");
			} else {
				System.out.print("     ");
			}
			
			
			for (int j = 0; j < matriz2.length; j++) {
				System.out.print(matriz2[i][j]+" ");
			}
			
			if (i==1) {
				System.out.print("  =  ");
			} else {
				System.out.print("     ");
			}
			
			for (int j = 0; j < numeroresultante.length; j++) {
				System.out.print(numeroresultante[i][j]+" ");
			}
			System.out.println("");
		}
		return " ";
	}
	
	public String ejercicio7Matriz(int matrizEje1[][], int filitas, int columnas) {
	
		int contador=0;
		for (int i = 0; i < matrizEje1.length-1; i++) {
			//contador=0;
			for (int j = 0; j < matrizEje1.length-1; j++) {
				if (matrizEje1[i][j]==0 && matrizEje1[i+1][j+1]==0) {
					contador++;
				}
			}
		}
		JOptionPane.showMessageDialog(null, " Si hay "+contador+" '0' consecutivos en la matriz");
		return " ";	
	}
}
