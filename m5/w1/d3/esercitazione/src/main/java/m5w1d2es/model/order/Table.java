package m5w1d2es.model.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Table {
	private static int idCount = 0;
	
	private final int id;
	private int maxPeople;
	private Boolean busy;

	public Table(int maxPeople, Boolean busy) {
		this.id = idCount++;
		this.maxPeople = maxPeople;
		this.busy = busy;
	}

	public Table() {
		this.id = idCount++;
	}
	
}
