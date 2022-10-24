package m5w1d1es.model.products;

import m5w1d1es.model.PizzaBase;
import m5w1d1es.model.enumerable.PizzaSize;

public class Diavola extends PizzaBase{

		public Diavola(PizzaSize size) {
			super(size, "Diavola (tomato, cheese, salame piccante)", 7.99, 1160);
		}
}
