package m5w1d2es.products;

import m5w1d2es.model.PizzaTopping;
import m5w1d2es.model.superclass.Pizza;

public class ToppingOnions  extends PizzaTopping{

	public ToppingOnions(Pizza pizza) {
		super(pizza,"Onions", 0.69, 22);
	}
}
