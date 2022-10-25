package m5w1d2es.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import m5w1d2es.model.interfaces.IMenuItem;
import m5w1d2es.utils.LogColor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Souvenir implements IMenuItem{
	
	private String name;
	private double price;
	
	@Override
	public String toString() {
		return "Prodotto: " + LogColor.GREEN(getName())
		+ " | ====> Prezzo: " + LogColor.GREEN(getPrice()+ "");
	}

}
