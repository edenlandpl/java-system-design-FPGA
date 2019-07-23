/**
 * 
 */
package FPGA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Adrian
 * ProjektowanieSystemow.java
 */
public class LuTabelaDoGrafu {
	public static void rozkladDoGrafu() {
		int N; 
		//i=0, j=0,k=0;
//System.out.println("Paj rozmiar macierzy");
//N = inputScanner.nextInt();	
N = 4;int i,j,k,m,n, nr, T = 12000, jj, ii, kk, mm, nn;
int i11, i12, i13, m1i2 = 0, m1i1 = 0, a1i2, a1i1, a1i3;						// deklaracja zmiennych pierwszego gniazda
int i21, i22, i23, a2i2 = 0, a2i3, m2i2, m2i1, a2i1;		// deklaracja zmiennych drugiego gniazda

//double A[][] =	{ { 2, -1, -2 }, 
//				{ -4, 6, 3 }, 
//				{ -4, -2, 8 } };;	// wartości stałe, różne
double [][] A = new double[N+2][N+2];
double [][] L = new double[N+2][N+2];
double [][] U = new double[N+2][N+2];
int [][] tabela = new int[T][T];
int [][] tabelaGraf = new int[T][T];
int [][] tabelaTemp = new int[T][T];
int [] W1 = new int[T];
int [] W2 = new int[T];
int [] W3 = new int[T];
int [] Ia1i2 = new int[T];
int [] Ia1i3 = new int[T];
int [] Ia2i1 = new int[T];
int [] Ia2i3 = new int[T];
int [] Imi2 = new int[T];
int [] Imi1 = new int[T];

// Wypełnienie macierzy wartościami
//Random r = new Random();
for(i=0 ; i<N+1 ; i++) {
	for( j=0 ; j<N+1 ; j++) {
//		A[i][j]=r.nextDouble();	// losowe liczby double z zakresu 0-1

		A[i][j]=5f; // wartości stałe - 5
	}
}

// Wyświetlenie macierzy początkowej

System.out.println("Macierz wejściowa do grafu");
for(i=1 ; i<N+1 ; i++) {
	for(j=1 ; j<N+1 ; j++) {
		System.out.print(A[i][j]+ " ");		        
	}
	System.out.println(" ");
}

// Petla rozkladu macierzy LU metą Gaussa
// L - dolna macierz trójkątna, w macierzy A będzie macierz górna U

////////////////////////////////////////////////////////////////////
System.out.println("Tabela - indeksy");
nr = 0;int kolumna, wiersz = 0;					// deklaracja numeru linii

long czasStartMilisekundy = System.nanoTime(); // początkowy czas w milisekundach.
// wykonanie programu

for (i = 1;i < N;i++) {
	for(j = i+1; j <=N; j++) {
		for(k = i+1; k <=N; k++) {		// dane kolejne gniazdo
			nr++;
			W1[nr] = i;
			W2[nr] = j;
			W3[nr] = k;
			Ia1i2[nr]= j;
			Ia1i3[nr] = k;
			Ia2i1[nr] = i;
			Ia2i3[nr] = k;
			Imi2[nr] = j;
			Imi1[nr] = i;				// Konstruowanie grafu algorytmu
			kolumna = 0;
			wiersz = nr;
			tabela[wiersz][kolumna] = i;	// Tworzenie tabeli
			kolumna++;
			tabela[wiersz][kolumna] = j;
			kolumna++;
			tabela[wiersz][kolumna] = k;
			kolumna++;
			tabela[wiersz][kolumna] = j;
			kolumna++;
			tabela[wiersz][kolumna] = i;
			kolumna++;
			tabela[wiersz][kolumna] = i;
			kolumna++;
			tabela[wiersz][kolumna] = k;
			kolumna++;
			tabela[wiersz][kolumna] = j;
			kolumna++;
			tabela[wiersz][kolumna] = k;
			// Wyświetlanie tabeli pierwsze gniazdo
			System.out.println(nr + " -> " + W1[nr] + " " + W2[nr] + " " + W3[nr] + " " + Imi2[nr] + " " + Imi1[nr] + " " + Ia2i1[nr] + " " + Ia2i3[nr] + " " + Ia1i2[nr] + " " + Ia1i3[nr]);
		}
	
		if(A[i][i] != 0) {
			L[j][i] = A[j][i] / A[i][i];
		}
		else
			L[j][i] = 0;					
	}
	wiersz++;
	System.out.println("Drugie gniazdo");
	for(j = i+1; j <= N; j++) {
		for(k = i;k <= N ; k++) {
			A[j][k] = A[j][k] - (L[j][i]*A[i][k]);
			nr++;
			W1[nr] = i;
			W2[nr] = j;
			W3[nr] = k;
			Ia1i2[nr]= j;
			Ia1i3[nr] = k;
			Ia2i1[nr] = i;
			Ia2i3[nr] = k;
			Imi2[nr] = j;
			Imi1[nr] = i;		// Konstruowanie grafu algorytmu
			kolumna = 0;
			wiersz = nr;
			tabela[wiersz][kolumna] = i;	// Tworzenie tabeli
			kolumna++;
			tabela[wiersz][kolumna] = j;
			kolumna++;
			tabela[wiersz][kolumna] = k;
			kolumna++;
			tabela[wiersz][kolumna] = j;
			kolumna++;
			tabela[wiersz][kolumna] = i;
			kolumna++;
			tabela[wiersz][kolumna] = i;
			kolumna++;
			tabela[wiersz][kolumna] = k;
			kolumna++;
			tabela[wiersz][kolumna] = j;
			kolumna++;
			tabela[wiersz][kolumna] = k;
			// Wyświetlanie tabeli - drugie gniazdo
			System.out.println(nr + " -> " + W1[nr] + " " + W2[nr] + " " + W3[nr] + " " + Imi2[nr] + " " + Imi1[nr] + " " + Ia2i1[nr] + " " + Ia2i3[nr] + " " + Ia1i2[nr] + " " + Ia1i3[nr]);
		}		
	}		
}

	long czasStopMilisekundy = System.nanoTime();
	float executionTime = czasStopMilisekundy - czasStartMilisekundy; // czas wykonania programu w milisekundach.
	System.out.println(" ");
	System.out.println("Czas rozpoczęcia " + czasStartMilisekundy);
	System.out.println("Czas zakończenia " + czasStopMilisekundy);
	System.out.println("Czas w milisekundach " + executionTime / 1000000);
	System.out.println(" ");
	
	// datkowa pętla do wgrania z A do U z uwzględnieniem warunku dla i <= j
	for (i = 1;i <= N;i++) {
		for(j = i; j <=N; j++) {
			if(i <= j)
				U[i][j] =A[i][j];
				L[i][i] = 1; 		// przekątne wypełniamy 1
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
	System.out.println();
	}
	//System.out.println("Przepisanie do tabeli - bez dublikatów");
	int iloscBezDuplikatow = 0;
	for(i = 1; i <= nr; i++) {
		for(j = 0; j < 9; j++) {			
			for(k = i+1; k <= nr; k++) {
				if(tabela[i][0] == tabela[k][0] && tabela[i][1] == tabela[k][1] && tabela[i][2] == tabela[k][2]) {
					tabela[k][0] = 0; // ustawienie 0 na duplikatach
				}
			}
			
			// Przepisanie tabeli do tabeliGraf bez duplikatów
			if(tabela[i][0] != 0) {
				for(m = 0; m < 9 ; m++) {
					tabelaTemp[iloscBezDuplikatow][m] = tabela[i][m];
				}
				//System.out.print(tabelaTemp[i][j] + " ");
				if(j == 8) {
					//System.out.println();
					iloscBezDuplikatow++;
				}
			}

		}
		
	}	
	
	System.out.println();
	System.out.println("Tabela Temp - oba gniazda, bez sortu");
	for(i = 0 ; i < iloscBezDuplikatow ; i++) {
		for(j = 0 ; j < 9 ; j++) {
			System.out.print(tabelaTemp[i][j] + " ");
		}
		System.out.println();
	}
	
	System.out.println("Tabela posortowana");
	// Sortowanie tabeli
	int nrGraf = 0, nrWierszaMin = 0;	
	double WartGorna1, WartGorna2, WartGorna3, WartGornaW, WartDolna1, WartDolna2, WartDolna3, WartDolnaW;
	for( i = 0 ; i < iloscBezDuplikatow ; i++) {
		WartGorna1 = tabelaTemp[i][0] * 100;
		WartGorna2 = tabelaTemp[i][1] * 10;
		WartGorna3 = tabelaTemp[i][2] * 1;
		WartGornaW = WartGorna1 + WartGorna2 + WartGorna3;
		//System.out.println("WartGornaW - " + WartGornaW);
		nrWierszaMin = i;
		for( j = i+1 ; j < iloscBezDuplikatow ; j++) {
			if(tabelaTemp[j][0] == 0) {
				continue;
			}
			WartDolna1 = tabelaTemp[j][0] * 100;
			WartDolna2 = tabelaTemp[j][1] * 10;
			WartDolna3 = tabelaTemp[j][2] * 1;
			WartDolnaW = WartDolna1 + WartDolna2 + WartDolna3;
			if ( WartGornaW > WartDolnaW) {
				//System.out.println("Numer wiersza" + j);
				nrWierszaMin = j;			
				WartGornaW = WartDolnaW;
			}
			//System.out.println("WartDolnaW - " + WartDolnaW);
		}
		for(k = 0 ; k < 9 ; k++) {
			tabelaGraf[nrGraf][k] = tabelaTemp[nrWierszaMin][k];
			tabelaTemp[nrWierszaMin][k] = tabelaTemp[i][k];
		}
		nrGraf++;
	}
	

	System.out.println();
	System.out.println("Tabela Graf");
	for(i = 0 ; i < iloscBezDuplikatow ; i++) {
		for(j = 0 ; j < 9 ; j++) {
			System.out.print(tabelaGraf[i][j] + " ");
		}
		System.out.println();
	}
	
	// Wyszukiwanie połączeń między gniazdami
	System.out.println();
	System.out.println("Połączenia gniazd - węzły");
	for(i = 0 ; i < iloscBezDuplikatow ; i++) {
		for(j = i +1 ; j < iloscBezDuplikatow ; j++) {
				// Pierwsza kolumna -> Pierwsza kolumna
				if(tabelaGraf[i][3] == tabelaGraf[j][3] && tabelaGraf[i][4] == tabelaGraf[j][4] ) {
					if((tabelaGraf[i][0] + 1 ) < tabelaGraf[j][0] || (tabelaGraf[i][1] + 1 ) < tabelaGraf[j][1] || (tabelaGraf[i][2] + 1 ) < tabelaGraf[j][2]) {
						;
					}	
					else {
						System.out.println("Węzełek " + tabelaGraf[i][0] + tabelaGraf[i][1] + tabelaGraf[i][2] + " - > " +  + tabelaGraf[j][0] + tabelaGraf[j][1] + tabelaGraf[j][2] + " Od " + tabelaGraf[i][3] + tabelaGraf[i][4] + " do -> " + tabelaGraf[j][3] + tabelaGraf[j][4]);
					}
				} 
				// Pierwsza kolumna -> Druga kolumna
				if(tabelaGraf[i][3] == tabelaGraf[j][5] && tabelaGraf[i][4] == tabelaGraf[j][6] ) {
					if((tabelaGraf[i][0] + 1 ) < tabelaGraf[j][0] || (tabelaGraf[i][1] + 1 ) < tabelaGraf[j][1] || (tabelaGraf[i][2] + 1 ) < tabelaGraf[j][2]) {
						;
					}	
					else {
						System.out.println("Węzełek " + tabelaGraf[i][0] + tabelaGraf[i][1] + tabelaGraf[i][2] + " - > " +  + tabelaGraf[j][0] + tabelaGraf[j][1] + tabelaGraf[j][2] + " Od " + tabelaGraf[i][3] + tabelaGraf[i][4] + " do -> " + tabelaGraf[j][3] + tabelaGraf[j][4]);
					}
				} 
				// Pierwsza kolumna -> Trzecia kolumna
				if(tabelaGraf[i][3] == tabelaGraf[j][5] && tabelaGraf[i][4] == tabelaGraf[j][6] ) {
					if((tabelaGraf[i][0] + 1 ) < tabelaGraf[j][0] || (tabelaGraf[i][1] + 1 ) < tabelaGraf[j][1] || (tabelaGraf[i][2] + 1 ) < tabelaGraf[j][2]) {
						;
					}	
					else {
						System.out.println("Węzełek " + tabelaGraf[i][0] + tabelaGraf[i][1] + tabelaGraf[i][2] + " - > " +  + tabelaGraf[j][0] + tabelaGraf[j][1] + tabelaGraf[j][2] + " Od " + tabelaGraf[i][3] + tabelaGraf[i][4] + " do -> " + tabelaGraf[j][3] + tabelaGraf[j][4]);
					}
				} 
				// Druga kolumna -> Druga kolumna
				if(tabelaGraf[i][5] == tabelaGraf[j][5] && tabelaGraf[i][6] == tabelaGraf[j][6] ) {
					if((tabelaGraf[i][0] + 1 ) < tabelaGraf[j][0] || (tabelaGraf[i][1] + 1 ) < tabelaGraf[j][1] || (tabelaGraf[i][2] + 1 ) < tabelaGraf[j][2]) {
						;
					}	
					else {
						System.out.println("Węzełek " + tabelaGraf[i][0] + tabelaGraf[i][1] + tabelaGraf[i][2] + " - > " +  + tabelaGraf[j][0] + tabelaGraf[j][1] + tabelaGraf[j][2] + " Od " + tabelaGraf[i][3] + tabelaGraf[i][4] + " do -> " + tabelaGraf[j][3] + tabelaGraf[j][4]);
					}
				} 
				// Druga kolumna -> Trzecia kolumna
				if(tabelaGraf[i][5] == tabelaGraf[j][7] && tabelaGraf[i][6] == tabelaGraf[j][8] ) {
					if((tabelaGraf[i][0] + 1 ) < tabelaGraf[j][0] || (tabelaGraf[i][1] + 1 ) < tabelaGraf[j][1] || (tabelaGraf[i][2] + 1 ) < tabelaGraf[j][2]) {
						;
					}	
					else {
						System.out.println("Węzełek " + tabelaGraf[i][0] + tabelaGraf[i][1] + tabelaGraf[i][2] + " - > " +  + tabelaGraf[j][0] + tabelaGraf[j][1] + tabelaGraf[j][2] + " Od " + tabelaGraf[i][3] + tabelaGraf[i][4] + " do -> " + tabelaGraf[j][3] + tabelaGraf[j][4]);
					}
				} 
				// Trzecia kolumna -> Trzecia kolumna
				if(tabelaGraf[i][7] == tabelaGraf[j][7] && tabelaGraf[i][8] == tabelaGraf[j][8] ) {
					if((tabelaGraf[i][0] + 1 ) < tabelaGraf[j][0] || (tabelaGraf[i][1] + 1 ) < tabelaGraf[j][1] || (tabelaGraf[i][2] + 1 ) < tabelaGraf[j][2]) {
						;
					}	
					else {
						System.out.println("Węzełek " + tabelaGraf[i][0] + tabelaGraf[i][1] + tabelaGraf[i][2] + " - > " +  + tabelaGraf[j][0] + tabelaGraf[j][1] + tabelaGraf[j][2] + " Od " + tabelaGraf[i][3] + tabelaGraf[i][4] + " do -> " + tabelaGraf[j][3] + tabelaGraf[j][4]);
					}
				} 
				// Trzecia kolumna -> Druga kolumna
				if(tabelaGraf[i][7] == tabelaGraf[j][5] && tabelaGraf[i][8] == tabelaGraf[j][6] ) {
					if((tabelaGraf[i][0] + 1 ) < tabelaGraf[j][0] || (tabelaGraf[i][1] + 1 ) < tabelaGraf[j][1] || (tabelaGraf[i][2] + 1 ) < tabelaGraf[j][2]) {
						;
					}	
					else {
						System.out.println("Węzełek " + tabelaGraf[i][0] + tabelaGraf[i][1] + tabelaGraf[i][2] + " - > " +  + tabelaGraf[j][0] + tabelaGraf[j][1] + tabelaGraf[j][2] + " Od " + tabelaGraf[i][3] + tabelaGraf[i][4] + " do -> " + tabelaGraf[j][3] + tabelaGraf[j][4]);
					}
				} 
				
			}
	}
	///////////////////////////  	 EP z taktami 		//////////////////////////////////////
	
	// Deklarowane Macierz D i Ft
	
	int D[][] = 	{{ 1 , 0 , 0 , 1 },
					 { 0 , 1 , 0 , 1 },
					 { 0 , 0 , 1 , 0}};
	
	int Ft[] = { 1 , 1 , 1};
	
	int listaWezelkow[] = new int [iloscBezDuplikatow];
	int sprawdzenieFSd1 = 0;
	int sprawdzenieFSd2 = 0;
	int sprawdzenieFSd3 = 0;
	int takt = 0;
	int takt2 = 0;
	int takt3 = 0;
	
	
	// EP - pierwsza architektura
	int FS1[][] = {{  1 , 0 , 1},						// FS pierwsza wersja			
				   { -1 , 1 ,-1}};
	
	int FSd1Temp[] = new int [2];						// tablica temp, żeby sumować kolejne elementy
	int FSd1[][] = new int[2][5];						// FS 1 * d
	int epTemp[] = new int[2];							// ep tymczasowe do obliczenia EP
	int EP1[][] = new int[iloscBezDuplikatow][iloscBezDuplikatow];		// sprawdz dobra wielkosc tablicy
	int taktMinMax[] = { 99999,-999999 };
	
	// przepisanie wezęłków do nowej tabeli dla prostoty liczenia
	for(i = 0 ; i < iloscBezDuplikatow ; i++ ) {
		listaWezelkow[i] = tabelaGraf[i][0] * 100 + tabelaGraf[i][1] * 10 + tabelaGraf[i][2];
	}
	// ustalenie FS * d - tylko dla zmieniających się j, macierz pionowa
	System.out.println("Kolejne iteracje obliczeniowe tablicy FS * d");
	for( k = 0 ; k < 4 ; k++) {							// kolumna dla FSd1
		for( i = 0 ; i < 2 ; i ++) {
			for( j = 0 ; j < 3 ; j++) {
				FSd1Temp [i] = FS1[i][j] * D[j][k];
				FSd1[i][k] = FSd1[i][k] +  FSd1Temp[i];
				System.out.println(" k - i - j - FSd1 k=" + k + " = " + i + " " + j + " " + FSd1[i][k]);
			}
		}
	}
	// wyświetlenie FSd1 dla kolejnych kolumn
	System.out.println("Obliczona tablica FSd1");
	for( i = 0 ; i < 2 ; i++) {
		for( j = 0 ; j < 4 ; j++) {
			System.out.print(FSd1[i][j]);
			if(FSd1[i][j] == -1 || FSd1[i][j] == 0 || FSd1[i][j] == 1 ) {
				
			}else
			{
				sprawdzenieFSd1++;
			}
		}
		System.out.println("");
	}
	// jeśli warunek dla FSd1 nie został spełniony, FSd1 nie nadaje sie do architektury
	if(sprawdzenieFSd1 >0 ) {
		System.out.println("FSd1 nie spełnia warunku FS1 * d = -1 or 0 or 1");
	}else {
		System.out.println("FSd1 spełnia warunek FS1*d = -1 or 0 or 1");
	}
	System.out.println("Architektura FS 1");
	// Obliczenie EP dla FS1
	for(i = 0 ; i < iloscBezDuplikatow ; i ++) {			// pętla dla wszystkich węzełków, dla całej tabeliGraf
		for( k = 0 ; k < 3 ; k++) {
			epTemp[0] = epTemp[0] + FSd1[0][k] * tabelaGraf[i][k];
			epTemp[1] = epTemp[1] + FSd1[1][k] * tabelaGraf[i][k];
			takt = takt + tabelaGraf[i][k] * Ft[k];
		}
		EP1[i][0] = epTemp[0];			// EP - współrzędna x
		EP1[i][1] = epTemp[1];			// EP - współrzędna y 
		EP1[i][2] = takt;				// takt
		EP1[i][3] = tabelaGraf[i][0];			// Wektor[0]
		EP1[i][4] = tabelaGraf[i][1];			// Wektor[1]
		EP1[i][5] = tabelaGraf[i][2];			// Wektor[2]	
		System.out.println("x = " + EP1[i][0] + " y = " + EP1[i][1] + " takt - " + EP1[i][2] + " Wektor - " + EP1[i][3] + EP1[i][4] +EP1[i][5]);
		epTemp[0] = 0;
		epTemp[1] = 0;
		// takt Min
		if(taktMinMax[0] > takt) {
			taktMinMax[0] = takt;
		}
		// takt Max
		if(taktMinMax[1] < takt) {
			taktMinMax[1] = takt;
		}
		takt = 0;
	}

	
	// EP2 - druga architektura	///////////////////////////////////////////////////////////////////////////
	int FS2[][] = {{  1 , 0 , 1},						// FS pierwsza wersja			
				   { 1 , 0 ,-1}};
//	int FS2[][] = {{  1 , 0 , 1}};
	
	int FSd2Temp[] = new int [2];						// tablica temp, żeby sumować kolejne elementy
	int FSd2[][] = new int[2][5];						// FS 1 * d
	int epTemp2[] = new int[2];							// ep tymczasowe do obliczenia EP
	int EP2[][] = new int[iloscBezDuplikatow][iloscBezDuplikatow];		// sprawdz dobra wielkosc tablicy
	int taktMinMax2[] = { 99999,-999999 };
	
	// przepisanie wezęłków do nowej tabeli dla prostoty liczenia
	for(i = 0 ; i < iloscBezDuplikatow ; i++ ) {
		listaWezelkow[i] = tabelaGraf[i][0] * 100 + tabelaGraf[i][1] * 10 + tabelaGraf[i][2];
	}
	// ustalenie FS * d - tylko dla zmieniających się j, macierz pionowa
	System.out.println("Kolejne iteracje obliczeniowe tablicy FS2 * d");
	for( k = 0 ; k < 4 ; k++) {							// kolumna dla FSd1
		for( i = 0 ; i < 1 ; i ++) {
			for( j = 0 ; j < 3 ; j++) {
				FSd2Temp [i] = FS2[i][j] * D[j][k];
				FSd2[i][k] = FSd2[i][k] +  FSd2Temp[i];
				System.out.println(" k - i - j - FSd2 k=" + k + " = " + i + " " + j + " " + FSd2[i][k]);
			}
		}
	}
	// wyświetlenie FSd1 dla kolejnych kolumn
	System.out.println("Obliczona tablica FSd2");
	for( i = 0 ; i < 2 ; i++) {
		for( j = 0 ; j < 4 ; j++) {
			System.out.print(FSd2[i][j]);
			if(FSd2[i][j] == -1 || FSd2[i][j] == 0 || FSd2[i][j] == 1 ) {
				
			}else
			{
				sprawdzenieFSd2++;
			}
		}
		System.out.println("");
	}
	// jeśli warunek dla FSd1 nie został spełniony, FSd1 nie nadaje sie do architektury
	if(sprawdzenieFSd2 >0 ) {
		System.out.println("FSd2 nie spełnia warunku FS2 * d = -1 or 0 or 1");
	}else {
		System.out.println("FSd2 spełnia warunek FS2*d = -1 or 0 or 1");
	}
	//System.out.println("Architektura FS 2");
	// Obliczenie EP dla FS2
	for(i = 0 ; i < iloscBezDuplikatow ; i ++) {			// pętla dla wszystkich węzełków, dla całej tabeliGraf
		for( k = 0 ; k < 3 ; k++) {
			epTemp2[0] = epTemp2[0] + FSd2[0][k] * tabelaGraf[i][k];
			epTemp2[1] = epTemp2[1] + FSd2[1][k] * tabelaGraf[i][k];
			takt2 = takt2 + tabelaGraf[i][k] * Ft[k];
		}
		EP2[i][0] = epTemp2[0];			// EP - współrzędna x
		EP2[i][1] = epTemp2[1];			// EP - współrzędna y 
		EP2[i][2] = takt2;				// takt
		EP2[i][3] = tabelaGraf[i][0];			// Wektor[0]
		EP2[i][4] = tabelaGraf[i][1];			// Wektor[1]
		EP2[i][5] = tabelaGraf[i][2];			// Wektor[2]	
		//System.out.println("x = " + EP2[i][0] + " y = " + EP2[i][1] + " takt - " + EP2[i][2] + " Wektor - " + EP2[i][3] + EP2[i][4] +EP2[i][5]);
		epTemp2[0] = 0;
		epTemp2[1] = 0;
		// takt Min
		if(taktMinMax2[0] > takt2) {
			taktMinMax2[0] = takt2;
		}
		// takt Max
		if(taktMinMax2[1] < takt2) {
			taktMinMax2[1] = takt2;
		}
		takt2 = 0;
	}
		
//	// EP3 - druga architektura	///////////////////////////////////////////////////////////////////////////
//		int FS3[][] = {{  1 , 0 , 1},						// FS pierwsza wersja			
//					   { 1 , 0 ,-1}};
////		int FS3[][] = {{  1 , 0 , 1}};
//		
//		int FSd3Temp[] = new int [2];						// tablica temp, żeby sumować kolejne elementy
//		int FSd3[][] = new int[2][5];						// FS 1 * d
//		int epTemp3[] = new int[2];							// ep tymczasowe do obliczenia EP
//		int EP3[][] = new int[iloscBezDuplikatow][iloscBezDuplikatow];		// sprawdz dobra wielkosc tablicy
//		int taktMinMax3[] = { 99999,-999999 };
//		
//		// przepisanie wezęłków do nowej tabeli dla prostoty liczenia
//		for(i = 0 ; i < iloscBezDuplikatow ; i++ ) {
//			listaWezelkow[i] = tabelaGraf[i][0] * 100 + tabelaGraf[i][1] * 10 + tabelaGraf[i][2];
//		}
//		// ustalenie FS * d - tylko dla zmieniających się j, macierz pionowa
//		System.out.println("Kolejne iteracje obliczeniowe tablicy FS3 * d");
//		for( k = 0 ; k < 4 ; k++) {							// kolumna dla FSd1
//			for( i = 0 ; i < 1 ; i ++) {
//				for( j = 0 ; j < 3 ; j++) {
//					FSd3Temp [i] = FS3[i][j] * D[j][k];
//					FSd3[i][k] = FSd3[i][k] +  FSd3Temp[i];
//					System.out.println(" k - i - j - FSd3 k=" + k + " = " + i + " " + j + " " + FSd3[i][k]);
//				}
//			}
//		}
//		// wyświetlenie FSd1 dla kolejnych kolumn
//		System.out.println("Obliczona tablica FSd2");
//		for( i = 0 ; i < 2 ; i++) {
//			for( j = 0 ; j < 4 ; j++) {
//				System.out.print(FSd2[i][j]);
//				if(FSd3[i][j] == -1 || FSd3[i][j] == 0 || FSd3[i][j] == 1 ) {
//					
//				}else
//				{
//					sprawdzenieFSd3++;
//				}
//			}
//			System.out.println("");
//		}
//		// jeśli warunek dla FSd1 nie został spełniony, FSd1 nie nadaje sie do architektury
//		if(sprawdzenieFSd3 >0 ) {
//			System.out.println("FSd2 nie spełnia warunku FS2 * d = -1 or 0 or 1");
//		}else {
//			System.out.println("FSd2 spełnia warunek FS2*d = -1 or 0 or 1");
//		}
//		//System.out.println("Architektura FS 2");
//		// Obliczenie EP dla FS2
//		for(i = 0 ; i < iloscBezDuplikatow ; i ++) {			// pętla dla wszystkich węzełków, dla całej tabeliGraf
//			for( k = 0 ; k < 3 ; k++) {
//				epTemp3[0] = epTemp3[0] + FSd3[0][k] * tabelaGraf[i][k];
//				epTemp3[1] = epTemp3[1] + FSd3[1][k] * tabelaGraf[i][k];
//				takt2 = takt2 + tabelaGraf[i][k] * Ft[k];
//			}
//			EP3[i][0] = epTemp2[0];			// EP - współrzędna x
//			EP3[i][1] = epTemp2[1];			// EP - współrzędna y 
//			EP3[i][2] = takt2;				// takt
//			EP3[i][3] = tabelaGraf[i][0];			// Wektor[0]
//			EP3[i][4] = tabelaGraf[i][1];			// Wektor[1]
//			EP3[i][5] = tabelaGraf[i][2];			// Wektor[2]	
//			//System.out.println("x = " + EP2[i][0] + " y = " + EP2[i][1] + " takt - " + EP2[i][2] + " Wektor - " + EP2[i][3] + EP2[i][4] +EP2[i][5]);
//			epTemp3[0] = 0;
//			epTemp3[1] = 0;
//			// takt Min
//			if(taktMinMax3[0] > takt2) {
//				taktMinMax3[0] = takt2;
//			}
//			// takt Max
//			if(taktMinMax3[1] < takt2) {
//				taktMinMax3[1] = takt2;
//			}
//			takt3 = 0;
//		}
	System.out.println("Takt Min - " + taktMinMax[0] + " Takt Max - " + taktMinMax[1]);
	System.out.println("Czas w taktach: " +( taktMinMax[1] - taktMinMax[0] + 1));// dodajemy latency 15, bo dzielenie
	double Tk = taktMinMax[1] - taktMinMax[0] + 1;
	double Tclk = Tk + (((N * 2) + ( N - 4))*15);
	System.out.println("Czas Tk : " + Tk); // Czas w sek
	System.out.println("Czas Tclk : " + ((Tclk / 500000000 ) * 1000000) + " ms"); // Czas w sek
	System.out.println("Czas (komp) - " + executionTime / 1000000 + " ms");	
	System.out.println("P [ % ] - obiążenie procesora - " +( 20 / (iloscBezDuplikatow * Tk)));				// P [ % ] - obiążenie procesora
	
	System.out.println();	
	System.out.println("Architektura 2");	
	System.out.println("Takt Min - " + taktMinMax2[0] + " Takt Max - " + taktMinMax2[1]);
	System.out.println("Czas w taktach: " +( taktMinMax2[1] - taktMinMax2[0] - 1));// dodajemy latency 15, bo dzielenie
	double Tk2 = taktMinMax2[1] - taktMinMax2[0] + 1;
	double Tclk2 = Tk2 + (((N * 2) + ( N - 4))*15);
	System.out.println("Czas Tk : " + Tk2); // Czas w sek
	System.out.println("Czas Tclk : " + ((Tclk2 / 500000000 ) * 1000000) + " ms"); // Czas w sek
	System.out.println("Czas (komp) - " + executionTime / 1000000 + " ms");
	System.out.println("Ilość bez duplikatów - " + iloscBezDuplikatow);
	System.out.println("P [ % ] - obiążenie procesora - " +( 20 / (iloscBezDuplikatow * Tk2)));				// P [ % ] - obiążenie procesora
	
} // zakończenie metody głównej
}
