package m5w1d2es.products;

import m5w1d2es.model.PizzaBase;
import m5w1d2es.model.enumerable.PizzaSize;

public class PizzaMargherita extends PizzaBase{

	public PizzaMargherita(PizzaSize size) {
		super(size, "Pizza Margherita (tomato, cheese)", 4.99, 1104);
	}
	
}
