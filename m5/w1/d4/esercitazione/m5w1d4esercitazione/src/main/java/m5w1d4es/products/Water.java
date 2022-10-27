package m5w1d4es.products;

import javax.persistence.Entity;

import m5w1d4es.model.Drink;

@Entity
public class Water extends Drink{

	public Water() {
		super("Water(0.5l)", 1d, 0);
	}

}
