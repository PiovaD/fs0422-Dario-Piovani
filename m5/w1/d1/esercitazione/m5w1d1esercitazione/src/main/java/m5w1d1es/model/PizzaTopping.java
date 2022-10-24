package m5w1d1es.model;

import m5w1d1es.model.enumerable.PizzaSize;
import m5w1d1es.utils.LogColor;

public class PizzaTopping extends Pizza{
	
	private Pizza pizza;
	private String name;
	private Double price;
	private int calories;	

	public PizzaTopping(Pizza pizza, String name, Double price,int calories) {
		super(pizza != null? pizza.getSize() : PizzaSize.STANDARD);
		this.pizza = pizza;
		this. name = name;
		this.price = price;
		this.calories = calories;	
	}

	@Override
	public String getName() {
		return this.pizza.getName() + " + " + this.name;
	}

	@Override
	public Double getPrice() {
		return this.pizza.getPrice() + this.price;
	}

	@Override
	public int getCalories() {
		return this.pizza.getCalories() + this.calories;
	}
	
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}

	@Override
	public String toString() {
		return "Prodotto: " + LogColor.GREEN(getName()) +  LogColor.YELLOW(" (" +getSize() + ")" ) 
		+ " | ====> Calorie: " + LogColor.GREEN(getCalories() + "")
		+ " | ====> Prezzo: " + LogColor.GREEN(getPrice()+ "");
	}
}
