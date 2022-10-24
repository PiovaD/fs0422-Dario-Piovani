package m5w1d1es.model.products;

import m5w1d1es.model.Pizza;
import m5w1d1es.model.PizzaTopping;

public class ToppingHam extends PizzaTopping{

	public ToppingHam(Pizza pizza) {
		super(pizza,"Ham", 0.99, 35);
	}


}
