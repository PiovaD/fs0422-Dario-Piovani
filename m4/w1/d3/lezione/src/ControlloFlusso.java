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
		
		for(int i = 1; i <= 10; i++) {
			if(i==4)continue;
			System.out.println(i);
		}
		
	
		MyArray myArr = new MyArray(new int[] {1,5,6});
		
		myArr.push(7);
		myArr.shift(2);
		myArr.print();
		myArr.pop();
		myArr.print();
		myArr.unshift();
		myArr.print();
	
	}

}
