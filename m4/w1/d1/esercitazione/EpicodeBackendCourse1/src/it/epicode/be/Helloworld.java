package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

	public static void main(String[] args) {
		// Stampa a console la frase
		System.out.println("This is my first Epicode Java Project!");

		System.out.println(moltiplication(5, 3));

		System.out.println(concat("ciao", 3));

		String[] arr = { "c1", "c2", "c3", "c4", "c5" };

		printArr(inserisciArray(arr, "epicode"));
		

		/*------------3---------------*/

		Scanner in = new Scanner(System.in);
		String[] str = new String[3];
		System.out.println("Stringa 1 ");
		str[0] = in.nextLine();
		System.out.println("Stringa 2 ");
		str[1] = in.nextLine();
		System.out.println("Stringa 3 ");
		str[2] = in.nextLine();

		printArr(str);

		printArrRev(str);
		

		/*------------4---------------*/
		
		
		
		System.out.println("inserire numero per verificare se dispari ");
		System.out.println(
				isOdd(in.nextInt())
				);
		
		System.out.println("permietro rettangolo: lato 1 ");
		double lr1 = in.nextDouble();
		System.out.println("lato 2 ");
		System.out.println(
				perimetro(in.nextInt(), lr1)
				);
		
		System.out.println(" area triangoilo: lato 1 ");
		double lt1 = in.nextDouble();
		System.out.println("lato 2 ");
		double lt2 = in.nextDouble();
		System.out.println("lato 3 ");
		System.out.println(
				areaTriangolo(in.nextInt(), lt1, lt2)
				);
		
		
		
	}

	public static int moltiplication(int x, int y) {
		return x * y;
	}

	public static String concat(String x, int y) {

		return x + y;
	}

	public static String[] inserisciArray(String[] arr, String s) {

		String[] x = { arr[0], arr[1], arr[2], s, arr[3], arr[4] };
		return x;
	}

	public static void printArr(String[] x) {
		for(int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
	}

	public static void printArrRev(String[] x) {
		for (int i = x.length - 1; i >= 0; i--) {
			System.out.println(x[i]);
		}
	}
	
	public static double perimetro(double l1, double l2) {
		return l1*2 + l2*2;
	}
	
	public static boolean isOdd(int num) {
		return num % 2 != 0 ? true : false;
	}
	
	public static double areaTriangolo(double l1, double l2, double l3) {
		
		double p = (l1 +l2 + l3) / 2;			
		
		return Math.sqrt(p*(p-l1)*(p-l2)*(p-l3));
	}

}
