package m5w1d4es.model.order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import m5w1d4es.model.enumerable.OrderStatus;
import m5w1d4es.utils.LogColor;

@Getter
@Setter
@Entity
@javax.persistence.Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Table table;

	@ManyToMany
	private List<OrderItem> list = new ArrayList<OrderItem>();

	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	private int coveredNumber;
	private double coveredPrice;

	public Order(Table table, List<OrderItem> list, int coveredNumber) {
		table.setBusy(true);
		this.table = table;
		this.list = list;
		this.status = OrderStatus.IN_PROGRESS;
		this.coveredNumber = coveredNumber;
	}

	public Order() {
		this.status = OrderStatus.IN_PROGRESS;
	}

	public void addMenuItem(OrderItem item) {
		list.add(item);
	}

	public void removeMenuItem(OrderItem item) {
		int index = list.indexOf(item);
		if (index >= 0)
			list.remove(index);
	}

	public double getBill() {
		double totale = 0d;

		for (OrderItem item : list) {
			totale += item.getPrice();
		}

		totale += (coveredNumber * getCoveredPrice());

		return totale;
	}

	@Override
	public String toString() {
		return "Ordine: " + LogColor.GREEN(getId() + "") + LogColor.YELLOW(" (" + getTable() + ")") + " | Lista: "
				+ LogColor.GREEN(getList().toString()) + " | Status: " + LogColor.GREEN(status + "");
	}

}
