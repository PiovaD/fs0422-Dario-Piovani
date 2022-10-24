package m5w1d1es.model;

import lombok.Getter;
import lombok.Setter;
import m5w1d1es.model.enumerable.PizzaSize;
import m5w1d1es.utils.LogColor;

@Getter
@Setter
public class PizzaBase extends Pizza {

	private String name;
	private Double price;
	private int calories;

	public PizzaBase(PizzaSize size, String name, Double price, int calories) {
		super(size);
		this.name = name;
		this.price = price;
		this.calories = calories;
		
		if(size == PizzaSize.FAMILY) {
			this.price= price + 4.15;
			this.calories= calories * 2;
		}
	}

	@Override
	public String toString() {
		return "Prodotto: " + LogColor.GREEN(getName()) +  LogColor.YELLOW(" (" +getSize() + ")" ) 
		+ " | ====> Calorie: " + LogColor.GREEN(getCalories() + "")
		+ " | ====> Prezzo: " + LogColor.GREEN(getPrice()+ "");
	}

}
