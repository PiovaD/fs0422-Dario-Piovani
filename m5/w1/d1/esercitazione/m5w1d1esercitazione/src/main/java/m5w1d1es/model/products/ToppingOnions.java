package m5w1d1es.model.products;

import m5w1d1es.model.Pizza;
import m5w1d1es.model.PizzaTopping;

public class ToppingOnions  extends PizzaTopping{

	public ToppingOnions(Pizza pizza) {
		super(pizza,"Onions", 0.69, 22);
	}
}
