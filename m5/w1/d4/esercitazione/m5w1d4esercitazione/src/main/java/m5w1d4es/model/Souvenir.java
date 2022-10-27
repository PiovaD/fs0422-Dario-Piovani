package m5w1d4es.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import m5w1d4es.model.superclass.IMenuItem;
import m5w1d4es.utils.LogColor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "souvenires")
public abstract class Souvenir extends IMenuItem{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private double price;
	
	@Override
	public String toString() {
		return "Prodotto: " + LogColor.GREEN(getName())
		+ " | ====> Prezzo: " + LogColor.GREEN(getPrice()+ "");
	}

}
