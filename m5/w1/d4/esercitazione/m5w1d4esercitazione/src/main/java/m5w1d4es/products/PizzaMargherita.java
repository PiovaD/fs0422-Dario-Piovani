package m5w1d4es.products;

import javax.persistence.Entity;

import m5w1d4es.model.PizzaBase;
import m5w1d4es.model.enumerable.PizzaSize;

@Entity
public class PizzaMargherita extends PizzaBase{

	public PizzaMargherita(PizzaSize size) {
		super(size, "Pizza Margherita (tomato, cheese)", 4.99, 1104);
	}
	
}
