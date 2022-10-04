package Exerc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ListEx {

		
	public static void main(String[] args) {
//		- 1
//		creare una LinkedList di interi (scegli 4 valori dati dall'utente) e stampa il valore più piccolo
//
//		- 2
//		creare una classe Item(name, values) avente un nome e un ArrayList di valori numerici. Ha poi il metodo getBestValue(che restituisce il valore più grande
//
//		- 3
//		creare una PriorityQueue di Item e aggiungere 5 istanze di Item create con valori a piacere. Implementare un comparatore che da la priorità agli Item con bestValue più piccolo
//
//		iterare la coda e stampare ogni volta il valore toString dell'istanza corrente, rimuovendolo dalla coda (alla fine dell'iterazione la coda deve essere vuota)

		
		Scanner scanner = new Scanner(System.in);
		
			LinkedList<Integer> numList = new LinkedList<>(); 
			System.out.println("Inserisci 4 valori");
			
			for (int i=0; i<4; i++) {
				
				try {
					int x = Integer.parseInt(scanner.nextLine());
					numList.add(x);
					
				}catch (NumberFormatException e){
					System.out.println("Hai inserito un elemento del tipo sbagliato");
					i--;
				}
	
			}
			
			System.out.println(numList);
			System.out.println("il valore più piccolo è" + getMin(numList));
			
			System.out.println("--------- EX 2 -------------");
			
			Item item = new Item("numeroni", new ArrayList<Integer>(Arrays.asList(5, 7, 9, 10)));
			
			System.out.println("Il numero più alto è: " + item.getBestValue());
			
			System.out.println("--------- EX 3 -------------");
			
			Item item1 = new Item("aldo", new ArrayList<Integer>(Arrays.asList(5, 7, 9, 10)));
			Item item2 = new Item("baldo", new ArrayList<Integer>(Arrays.asList(6, 234, 54, 13)));
			Item item3 = new Item("caldo", new ArrayList<Integer>(Arrays.asList(0, 353, 765, 21)));
			Item item4 = new Item("daldo", new ArrayList<Integer>(Arrays.asList(7, 98, 43, 2)));
			Item item5 = new Item("ealdo", new ArrayList<Integer>(Arrays.asList(43, 65, 876, 21)));
			
			PriorityQueue<Item> items = new PriorityQueue<>(new QueueClear());
			items.add(item1);
			items.add(item2);
			items.add(item3);
			items.add(item4);
			items.add(item5);	
			
			while(items.size() > 0) {
				System.out.println(items.poll());
				System.out.println(items);
			}
			
		scanner.close();
	}
	
	static int getMin(LinkedList<Integer> list) {
		int x = list.get(0);
		for(int i=0; i<list.size(); i++) {
			if (list.get(i) < x) {
				x = list.get(i);
			}
		}	
			return x;
	}

}

class Item {
	
	String name;
	ArrayList<Integer> values;
	
	public Item(String name, ArrayList<Integer> values) {
		this.name = name;
		this.values = values;
	}
	
	public int getBestValue() {
		Collections.sort(this.values, new Ascendent());
		return values.get(values.size() - 1);
	}
	

	@Override
	public String toString() {
		return this.name + " " + this.values;
	}
}


class Ascendent implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}

class QueueClear implements Comparator<Item>
	{
	   @Override
	   public int compare(Item x, Item y)
	   {
	      return x.getBestValue() - y.getBestValue();
	   }
}

