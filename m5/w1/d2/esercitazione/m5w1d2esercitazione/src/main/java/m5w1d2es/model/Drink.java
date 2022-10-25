package m5w1d2es.model;

import lombok.Getter;
import lombok.Setter;
import m5w1d2es.model.interfaces.IMenuItem;
import m5w1d2es.model.superclass.NutritionalValue;
import m5w1d2es.utils.LogColor;

@Getter
@Setter
public abstract class Drink implements IMenuItem, NutritionalValue {

	private String name;
	private double price;
	private int calories;

	public Drink(String name, double price, int calories) {
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
