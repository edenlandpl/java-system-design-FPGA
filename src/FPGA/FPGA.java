package FPGA;

/** Projektowanie systemów FPGA
 * author - Adrian
 * date - 6 paź 2018
 * version - 
 */

public class FPGA {

	public static void main(String[] args) {
		
//        RamkaGui okno = new RamkaGui();
//        okno.setVisible(true);
//		
		
//		Lu rozkladLu = new Lu();
//		rozkladLu.rozklad();
//		System.out.println(" ");
		LuTabelaDoGrafu rozkladLuTabelaDoGrafu = new LuTabelaDoGrafu();
		rozkladLuTabelaDoGrafu.rozkladDoGrafu();
//		System.out.println(" ");
//		LuGaussRat rozkladRat = new LuGaussRat();
//		rozkladRat.rozkladrat();
/////////////////////////////////////////////////////
		
		//public static double[][][] rozklad() {
		
			int N=3; 
			//i=0, j=0,k=0;
	//System.out.println("Podaj rozmiar macierzy");
	//N = inputScanner.nextInt();
	int i,j,k;
	double [][] A = new double[N][N];
	//double A[][] =	{ { 2, -1, -2 }, 
//					{ -4, 6, 3 }, 
//					{ -4, -2, 8 } };;	// wartości stałe, różne
	double [][] L = new double[N][N];
	double [][] U = new double[N][N];
	//double L[][] = 		{{1, 0, 0},
//						{1, 1, 0},
//						{1, 0, 1}};
	//double U[][] = 		{{5, 5, 5},
//						{0, 0, 0},
//						{0, 0, 0}};
	// Wypełnienie macierzy wartościami
	//Random r = new Random();
	for(i=0 ; i<N ; i++) {
		for( j=0 ; j<N ; j++) {
//			A[i][j]=r.nextDouble();	// losowe liczby double z zakresu 0-1

			A[i][j]=5f; // wartości stałe - 5
		}
	}
	//////////////////////////////////////////////////////////////////////
	// Moje wypocinki
	//U[0][0] = A[0][0];
	//U[0][1] = A[0][1];
	//U[0][2] = A[0][2];
	//U[1][1] = A[1][1] - U[0][1] * L[1][0];
	//U[1][1] = A[1][2] - U[0][2] * L[1][0];
	//U[2][2] = A[2][2] - ((U[0][2] * L[2][0]) + (U[1][2] * L[2][1]));
	//
	//L[1][0] = A[1][0] / U[0][0];
	//L[2][0] = A[2][0] / U[0][0];
	//if(U[1][1] != 0)
	//L[2][1] = (A[2][1] - (U[0][1] * L[2][0])) / U[1][1];
	//else
//		U[1][1] = 0;
	//
	/////////////////////////////////////////////////////////////////////
	// Petla rozkladu macierzy LU metodą Gaussa
	// L - dolna macierz trójkątna, w macierzy A będzie macierz górna U

//	for ( j = 0; j < N; j++) {
//	    for ( i = 0; i < j + 1; i++) {
//	        double s1 = 0;
//	        for (k = 0; k < i; k++)
//	            s1 += U[k][j] * L[i][k];
//	        U[i][j] = A[i][j] - s1;
//	    }
//	    for (i = j; i < N; i++) {
//	        double s2 = 0;
//	        for (k = 0; k < j; k++)
//	            s2 += U[k][j] * L[i][k];
//	        if(U[j][j] != 0)
//	        	L[i][j] = (A[i][j] - s2) / U[j][j];
//	        else
//	        	L[i][j] = 0;
//	    }L[j][j] = 1;
//	}
	   
		////////////////////////////////////////////////
		
//		System.out.println("Macierz L - dolna");
//		for(i=0 ; i<N ; i++) {
//			for( j=0 ; j<N ; j++) {
//				System.out.print(L[i][j]+ " ");		        
//			}
//			System.out.println(" ");
//		}
//
//		System.out.println("macierz U górna");
//		for(i=0 ; i<N ; i++) {
//			for(j=0 ; j<N ; j++) {
//				System.out.print(U[i][j]+ " ");		        
//			}
//			System.out.println(" ");
//		}
	}
}
