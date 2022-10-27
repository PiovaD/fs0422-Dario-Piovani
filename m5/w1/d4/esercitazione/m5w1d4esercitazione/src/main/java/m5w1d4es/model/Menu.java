package m5w1d4es.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import m5w1d4es.model.superclass.Pizza;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToMany
	private final List<Pizza> menuPizza = new ArrayList<>();

	@ManyToMany
	private final List<PizzaTopping> menuTopping = new ArrayList<>();

	@ManyToMany
	private final List<Drink> menuDrink = new ArrayList<>();

	@ManyToMany
	private final List<Souvenir> menuSouvenir = new ArrayList<>();

}
