import java.lang.reflect.Array;
import java.util.Scanner;

public class first {
	public static void main(String[] args) {
		System.out.println("Hello world");

		int x = 100;
		byte v1 = 127;
		short v2 = 32_767;
		int v3 = 2_147_483_647;
		long v4 = 9200000000000000000L;

		System.out.println(x);

		System.out.println(x + x);

		System.out.println("il val è: " + v1 + v1);

		System.out.println(v2 + v2 + " il val è: ");

		float v5 = 100.5f;

		double v6 = 100.54;

		char v7 = 'c';

		char v8 = 'i';
		
		System.out.println(v7 + v8);

		String name = "Luigi";
		byte studentAge = 28;

		System.out.println("Nome studente: " + name + " | Età studente: " + studentAge);

		double d1 = 10.54475;
		int z = (int) d1;

		System.out.println(z);
		
		
		saluta("Mario");
		saluta("Franco");
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Dammi nome: ");
		String n = in.nextLine();
		
		System.out.println("Dammi eta ");
		int a = Integer.parseInt(in.nextLine());
		
		System.out.println("Il tuo nome è " + n + " la tua età è ");
		
	}

	public static void saluta(String name) {
		System.out.printf("Ciao da %s! %n", name);

	}
}