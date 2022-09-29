import w1d3.Class1;
import w1d3.animals.Dog;
import java.util.*;

import MyArray.MyArray;

public class ControlloFlusso {

	public static void main(String[] args) {

		Class1 c = new Class1();

		c.stampaSomma();

		Dog dog1 = new Dog("blue", 2);
		System.out.println(dog1.name + " " + dog1.age);

		w1d3.mammals.Dog dog2 = new w1d3.mammals.Dog();
		System.out.println(dog2.breed);

		String color = "blue";

		switch (color) {
		case "blue":
			System.out.println('a');
			break;

		case "red":
			System.out.println('b');
			break;

		case "green":
			System.out.println('c');
			break;

		default:
			System.out.println('d');
		}

		for (int i = 1; i <= 10; i++) {
			if (i == 4)
				continue;
			System.out.println(i);
		}

		Scanner in = new Scanner(System.in);

		System.out.printf("Inserisci quanti elementi vuoi inserire ");
		int length = Integer.parseInt(in.nextLine());
		int[] arr = new int[length];

		for (int i = 0; i < length; i++) {

			System.out.printf("Inserisci il " + (i + 1) + "° elemento dell array: ");
			int num = Integer.parseInt(in.nextLine());
			arr[i] = num;

		}
		MyArray myArr = new MyArray(arr);

		myArr.print();
		boolean again = true;
		do {
			System.out.println("Cosa vuoi fare adesso: 1: push, 2: shift, 3: pop, 4: unshift, 5: per uscire");
			int operation = Integer.parseInt(in.nextLine());

			switch (operation) {

			case 1:
				System.out.println("Inserisci l'elemento dell array: ");
				int push = Integer.parseInt(in.nextLine());
				myArr.push(push);
				break;
			case 2:
				System.out.println("Inserisci l'elemento dell array: ");
				int shift = Integer.parseInt(in.nextLine());
				myArr.shift(shift);
				break;
			case 3:
				myArr.pop();
				System.out.println("Ultimo elemento rimosso");
				break;
			case 4:
				myArr.unshift();
				System.out.println("Primo elemento rimosso");
				break;
			case 5:
				again = false;
				break;

			}
			

			myArr.print();

		} while (again);
		
		System.out.println("The end");
	}

}
