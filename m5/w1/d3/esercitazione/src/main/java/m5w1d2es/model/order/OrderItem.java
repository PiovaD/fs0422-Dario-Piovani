package m5w1d2es.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import m5w1d2es.model.interfaces.IMenuItem;

@Getter
@Setter
@AllArgsConstructor
public class OrderItem {
	
		IMenuItem item;
		String note;
		
		String getOrdineItemLine() {
			return "\n" + this.item + " - Note: " + this.note;
		}
		
		Double getPrice() {
			return this.item.getPrice();
		}
	
}
