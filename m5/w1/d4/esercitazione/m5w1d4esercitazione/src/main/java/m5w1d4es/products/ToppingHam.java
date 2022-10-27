package m5w1d4es.products;

import javax.persistence.Entity;

import m5w1d4es.model.PizzaTopping;
import m5w1d4es.model.superclass.Pizza;

@Entity
public class ToppingHam extends PizzaTopping{

	public ToppingHam(Pizza pizza) {
		super(pizza,"Ham", 0.99, 35);
	}


}
