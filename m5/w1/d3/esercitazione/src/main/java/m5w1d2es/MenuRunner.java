package m5w1d2es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import m5w1d2es.model.Drink;
import m5w1d2es.model.order.Order;
import m5w1d2es.model.order.OrderItem;
import m5w1d2es.model.order.Table;
import m5w1d2es.model.superclass.Pizza;
import m5w1d2es.products.*;

@Component
@Slf4j
public class MenuRunner implements CommandLineRunner {

	@Autowired
	private ApplicationContext ctx;

	@Value("${pizza.coverageprice}")
	private Double coveredPrice;

	@Override
	public void run(String... args) throws Exception {

		Table tavolo = new Table(5, true);

		Order ordine = addOrder(tavolo, 3);

		valorizzaOrdine(ordine);

		stampaOrdine(ordine);

	}

	private void valorizzaOrdine(Order order) {

		for (int i = 0; i < 3; i++) {
			Pizza pizza = ctx.getBean(PizzaMargherita.class);
			OrderItem oi = new OrderItem(pizza, "");
			order.addMenuItem(oi);
		}

		Pizza pizza = ctx.getBean("margherita", PizzaMargherita.class);
		Pizza pizzaTopping1 = (Pizza) ctx.getBean("topOnion", pizza);
		pizzaTopping1 = (Pizza) ctx.getBean("topHam", pizzaTopping1);
		OrderItem oi1 = new OrderItem(pizzaTopping1, "");
		order.addMenuItem(oi1);

		Pizza pizza2 = ctx.getBean("diavola", Diavola.class);
		Pizza pizzaTopping2 = new ToppingOnions(pizza2);
		OrderItem oi2 = new OrderItem(pizzaTopping2, "");
		order.addMenuItem(oi2);

		Drink drink = ctx.getBean("wine", Drink.class);
		OrderItem oi3 = new OrderItem(drink, "");
		order.addMenuItem(oi3);
	}

	public Order addOrder(Table table, int coveredNumber) {
		Order ordine = ctx.getBean(Order.class);
		ordine.setTable(table);
		ordine.setCoveredNumber(coveredNumber);
		ordine.setCoveredPrice(coveredPrice);
		return ordine;
	}

	public void stampaOrdine(Order order) {
		log.info("****** ORDINE ******");
		log.info("Numero ordine: {}", order.getOrderID());
		log.info("Numero coperti: {}", order.getCoveredNumber());
		log.info("Numero Tavolo: {}", order.getTable()
				.getId());
		log.info("Stato ordine: {}", order.getStatus());
		log.info("");
		for (OrderItem item : order.getList()) {
			log.info("{} |-> Prezzo: {}", item.getItem()
					.getName(),
					item.getItem()
							.getPrice());
		}
		log.info("");
		log.info("Totale €: {}", order.getBill());
	}

}
