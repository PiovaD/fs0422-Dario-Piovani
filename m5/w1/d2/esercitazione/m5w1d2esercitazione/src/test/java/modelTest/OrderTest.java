package modelTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import m5w1d2es.model.enumerable.PizzaSize;
import m5w1d2es.model.order.Order;
import m5w1d2es.model.order.OrderItem;
import m5w1d2es.model.order.Table;
import m5w1d2es.products.PizzaMargherita;

public class OrderTest {

	private Order testOrder = new Order();
	private final int coveredNumber = 4;

	@Before
	public void setUp() {
		Table tavolo = new Table(5, true);

		testOrder.setTable(tavolo);
		testOrder.setCoveredNumber(coveredNumber);
		testOrder.setCoveredPrice(1d);
		
	}

	@Test
	public void addOrderItem() {
		int startSize = testOrder.getList()
				.size();

		PizzaMargherita pizza = new PizzaMargherita(PizzaSize.STANDARD);
		OrderItem oi = new OrderItem(pizza, "");

		testOrder.addMenuItem(oi);
		assertEquals(testOrder.getList()
				.size(), startSize + 1);
	}

	@Test
	public void removeOrderItem() {
		PizzaMargherita pizza = new PizzaMargherita(PizzaSize.STANDARD);
		OrderItem oi = new OrderItem(pizza, "");
		OrderItem oi1 = new OrderItem(pizza, "");
		
		testOrder.addMenuItem(oi);
		testOrder.addMenuItem(oi1);

		int startSize = testOrder.getList()
				.size();

		testOrder.removeMenuItem(oi);
		assertEquals(testOrder.getList()
				.size(), startSize - 1);
	}

	@Test
	public void billTest() {
		
		PizzaMargherita pizza = new PizzaMargherita(PizzaSize.STANDARD);
		OrderItem oi = new OrderItem(pizza, "");
		testOrder.addMenuItem(oi);
		testOrder.addMenuItem(oi);
		
		assertEquals(pizza.getPrice() * 2 + coveredNumber, testOrder.getBill());
		

	}

}
