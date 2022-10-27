package m5w1d4es.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import m5w1d4es.model.interfaces.NutritionalValue;
import m5w1d4es.model.superclass.IMenuItem;
import m5w1d4es.utils.LogColor;

@Getter
@Setter
@Entity
@Table(name = "drinks")
public abstract class Drink extends IMenuItem implements NutritionalValue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

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
