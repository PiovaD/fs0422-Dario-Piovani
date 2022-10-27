package m5w1d4es.products;

import javax.persistence.Entity;

import m5w1d4es.model.PizzaTopping;
import m5w1d4es.model.superclass.Pizza;

@Entity
public class ToppingOnions  extends PizzaTopping{

	public ToppingOnions(Pizza pizza) {
		super(pizza,"Onions", 0.69, 22);
	}
}
