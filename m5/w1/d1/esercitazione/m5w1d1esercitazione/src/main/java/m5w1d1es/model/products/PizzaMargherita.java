package m5w1d1es.model.products;

import m5w1d1es.model.PizzaBase;
import m5w1d1es.model.enumerable.PizzaSize;

public class PizzaMargherita extends PizzaBase{

	public PizzaMargherita(PizzaSize size) {
		super(size, "Pizza Margherita (tomato, cheese)", 4.99, 1104);
	}
	
}
