package m5w1d1es.model;

import lombok.Getter;
import lombok.Setter;
import m5w1d1es.model.interfaces.IMenuItem;
import m5w1d1es.model.superclass.NutritionalValue;
import m5w1d1es.utils.LogColor;

@Getter
@Setter
public abstract class Drink implements IMenuItem, NutritionalValue {

	private String name;
	private Double price;
	private int calories;

	public Drink(String name, Double price, int calories) {
		this.calories = calories;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Prodotto: " + LogColor.GREEN(getName())
		+ " | ====> Calorie: " + LogColor.GREEN(getCalories() + "")
		+ " | ====> Prezzo: " + LogColor.GREEN(getPrice()+ "");
	}

}
