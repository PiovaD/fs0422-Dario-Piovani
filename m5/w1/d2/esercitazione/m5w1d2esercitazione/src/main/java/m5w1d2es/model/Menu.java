package m5w1d2es.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import m5w1d2es.model.superclass.Pizza;

@Getter
@Setter
public class Menu {

	private final List<Pizza> menuPizza = new ArrayList<>();
	private final List<PizzaTopping> menuTopping = new ArrayList<>();
	private final List<Drink> menuDrink = new ArrayList<>();
	private final List<Souvenir> menuSouvenir = new ArrayList<>();
}
