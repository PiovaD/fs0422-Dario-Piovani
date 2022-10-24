package m5w1d1es.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import m5w1d1es.model.enumerable.PizzaSize;
import m5w1d1es.model.interfaces.IMenuItem;
import m5w1d1es.model.superclass.NutritionalValue;

@Getter
@Setter
@AllArgsConstructor
public abstract class Pizza  implements IMenuItem, NutritionalValue{

	private PizzaSize size;

	@Override
	public abstract String toString();

}
