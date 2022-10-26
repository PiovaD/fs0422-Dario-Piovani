package m5w1d2es.model.superclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import m5w1d2es.model.enumerable.PizzaSize;
import m5w1d2es.model.interfaces.IMenuItem;

@Getter
@Setter
@AllArgsConstructor
public abstract class Pizza  implements IMenuItem, NutritionalValue{

	private PizzaSize size;

	@Override
	public abstract String toString();

}
