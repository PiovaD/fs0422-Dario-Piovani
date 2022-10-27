package m5w1d4es.model.superclass;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import m5w1d4es.model.enumerable.PizzaSize;
import m5w1d4es.model.interfaces.NutritionalValue;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "pizzas")
public abstract class Pizza extends IMenuItem implements NutritionalValue {

	@Id
	private int id;

	@Enumerated(EnumType.STRING)
	private PizzaSize size;

	public Pizza(PizzaSize size) {
		this.size = size;
	}

	@Override
	public abstract String toString();

}
