package m5w1d4es.products;

import javax.persistence.Entity;

import m5w1d4es.model.Drink;

@Entity
public class Wine extends Drink{

	public Wine() {
		super("Wine(0.75l, 13%)", 7.49, 607);
	}
}
