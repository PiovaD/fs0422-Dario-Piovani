package m5w1d4es.products;

import javax.persistence.Entity;

import m5w1d4es.model.PizzaBase;
import m5w1d4es.model.enumerable.PizzaSize;

@Entity
public class Diavola extends PizzaBase{

		public Diavola(PizzaSize size) {
			super(size, "Diavola (tomato, cheese, salame piccante)", 7.99, 1160);
		}
}
