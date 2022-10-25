package m5w1d2es.model.order;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import m5w1d2es.model.enumerable.OrderStatus;
import m5w1d2es.utils.LogColor;

@Getter
@Setter
public class Order {

	private static int idCount = 0;
	
	private final int orderID;
	private Table table;
	private List<OrderItem> list = new ArrayList<OrderItem>();
	private OrderStatus status;
	private int coveredNumber;
	private double coveredPrice;
	
	public Order( Table table, List<OrderItem> list, int coveredNumber) {
		table.setBusy(true);
		this.orderID = idCount++;
		this.table = table;
		this.list = list;
		this.status = OrderStatus.IN_PROGRESS;
		this.coveredNumber = coveredNumber;
	}
	
	
	public Order() {
		this.orderID = idCount++;
		this.status = OrderStatus.IN_PROGRESS;
	}


	public void addMenuItem(OrderItem item) {
		list.add(item);
	}

	public void removeMenuItem(OrderItem item) {
		int index = list.indexOf(item);
		if(index >= 0) list.remove(index);
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
		return "Ordine: " + LogColor.GREEN(getOrderID()+ "") +  LogColor.YELLOW(" (" +getTable() + ")" ) 
		+ " | Lista: " + LogColor.GREEN(getList().toString()) + " | Status: " + LogColor.GREEN(status + "");
	}
	
}
