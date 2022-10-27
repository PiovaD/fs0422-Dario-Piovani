package m5w1d4es.products;

import javax.persistence.Entity;

import m5w1d4es.model.Souvenir;

@Entity
public class Shirt extends Souvenir{

	{
		setName("Shirt"); 
		setPrice(21.99);
	}

}
