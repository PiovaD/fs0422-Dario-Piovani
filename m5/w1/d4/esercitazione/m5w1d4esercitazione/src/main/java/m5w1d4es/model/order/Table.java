package m5w1d4es.model.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@javax.persistence.Table(name = "tables")
public class Table {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int maxPeople;
	private Boolean busy;

	public Table(int maxPeople, Boolean busy) {
		this.maxPeople = maxPeople;
		this.busy = busy;
	}

	public Table() {
	}

}
