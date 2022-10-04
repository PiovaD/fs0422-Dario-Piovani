package lezionew2d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HMap {

	public static void main(String[] args) {
		
		HashMap<String, String> m1 = new HashMap<>();

		m1.put("name", "Luigi");
		m1.put("lastname", "verdi");
		m1.put("role", "Developer");

		for (Map.Entry set : m1.entrySet()) {
			System.out.println("Chiave: " + set.getKey() + " Valore: " + set.getValue());
		}

		System.out.println(m1.values());

		System.out.println(m1.get("name") + " " + m1.get("lastname"));
		
		HashMap<String, ArrayList<Integer>> student1 = new HashMap<>();
		
		student1.put("java", new ArrayList<>(Arrays.asList(8,7,6)));		
		student1.put("php", new ArrayList<>(Arrays.asList(5,6,4)));		
		student1.put("html", new ArrayList<>(Arrays.asList(8,2,6)));
		
		for (Map.Entry set : student1.entrySet()) {
			System.out.println("Materia: " + set.getKey() + " Valore: " + set.getValue());
		}
	}

}

class EpicodeStudent {
	String name;

	HashMap<String, ArrayList<Integer>> ratings = new HashMap<>();
	
	public EpicodeStudent(String name, HashMap<String, ArrayList<Integer>> ratings) {
		this.name = name;
		this.ratings = ratings; 
	}
	
	double printMedia(String topic) {
		double avg = 0;
		int l = 0;
		
		for(Map.Entry set : this.ratings.entrySet()) {
			if(topic.equals(set.getKey())) {
				ArrayList<Integer> r = (ArrayList<Integer>) set.getValue();
				l= r.size();
			}
		}
		
		return avg;
	}
	
}

