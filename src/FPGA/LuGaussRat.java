/**
 * 
 */
package FPGA;

import java.util.Scanner;

/**
 * @author Adrian
 * ProjektowanieSystemow.java
 */

// Właściwy kod do Rokładu Gaussa - bez rozkładu do tabeli

public class LuGaussRat {
		public static void rozkladrat() {
		int N=1; 
		N = 4;int i,j,k,ii,jj,kk;
		double [][] A = new double[N+1][N+1];
		double [][] L = new double[N+1][N+1];
		double [][] U = new double[N+1][N+1];
		
		// Wypełnienie macierzy wartościami
		//Random r = new Random();	// użyj dla losowych liczb w macierzy
		for(i=0 ; i<N+1 ; i++) {
			for( j=0 ; j<N+1 ; j++) {
		//		A[i][j]=r.nextDouble();	// losowe liczby double z zakresu 0-1
				A[i][j]=5f; // wartości stałe = 5
			}
		}
		
		// Wyświetlenie macierzy początkowej
		System.out.println("Macierz wejściowa");
		for(i=1 ; i<N+1 ; i++) {
			for(j=0 ; j<N ; j++) {
				System.out.print(A[i][j]+ " ");		        
			}
			System.out.println(" ");
		}
		
		System.out.println(" ");
		System.out.println("Macierz wejściowa do grafu Rat"); // nazwa własna dla klasy, dla porządku
		
		for (i = 1;i < N;i++) {
			for(j = i+1; j <=N; j++) {
				if(A[i][i] != 0) {
					L[j][i] = A[j][i] / A[i][i];
				}
				else
					L[j][i] = 0;					
				}
			
			for(j = i+1; j <= N; j++) {
				for(k = i+1;k <= N ; k++) {
					A[j][k] = A[j][k] - (L[j][i]*A[i][k]);
				}		
			}
			// dodatkowa pętla do wgrania z A do U z uwzględnieniem warunku dla i <= j
			for (i = 1;i <= N;i++) {
				for(j = i; j <=N; j++) {
					if(i <= j)
						U[i][j] =A[i][j];
						L[i][i] = 1; 		// przekątne wypełniamy 1
				}
			}
		}
		
		System.out.println("Macierz L - dolna");
		for(i=1 ; i<N+1 ; i++) {
			for( j=1 ; j<N+1 ; j++) {
				System.out.print(L[i][j]+ " ");		        
			}
			System.out.println(" ");
		}
	
		System.out.println("macierz U górna");
		
		for(i=1 ; i<N+1 ; i++) {
			for(j=1 ; j<N+1 ; j++) {
				System.out.print(U[i][j]+ " ");		        
			}		
		System.out.println(" ");
		}
		
		System.out.println("macierz A górna - zmieniona !!!");
		
		for(i=1 ; i<N+1 ; i++) {
			for(j=1 ; j<N+1 ; j++) {
				System.out.print(A[i][j]+ " ");		        
		}
		System.out.println(" ");
		}
	}
}
