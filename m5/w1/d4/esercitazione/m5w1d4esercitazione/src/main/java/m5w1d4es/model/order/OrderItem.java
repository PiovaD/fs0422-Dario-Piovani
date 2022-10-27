package m5w1d4es.model.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import m5w1d4es.model.superclass.IMenuItem;

@Getter
@Setter
@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	IMenuItem item;

	String note;

	public OrderItem(IMenuItem item, String note) {
		this.item = item;
		this.note = note;
	}

	String getOrdineItemLine() {
		return "\n" + this.item + " - Note: " + this.note;
	}

	Double getPrice() {
		return this.item.getPrice();
	}

}
