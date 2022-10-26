package m5w1d2es.products;

import m5w1d2es.model.PizzaTopping;
import m5w1d2es.model.superclass.Pizza;

public class ToppingHam extends PizzaTopping{

	public ToppingHam(Pizza pizza) {
		super(pizza,"Ham", 0.99, 35);
	}


}
