package m5w1d4es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import m5w1d4es.model.Drink;
import m5w1d4es.model.order.Order;
import m5w1d4es.model.order.OrderItem;
import m5w1d4es.model.order.Table;
import m5w1d4es.model.superclass.Pizza;
import m5w1d4es.products.*;
import m5w1d4es.repositories.DrinkRepository;
import m5w1d4es.repositories.OrderItemRepo;
import m5w1d4es.repositories.OrderRepository;
import m5w1d4es.repositories.PizzaRepository;
//import m5w1d4es.repositories.PizzaToppingRepository;
import m5w1d4es.repositories.TableRepository;

@Component
@Slf4j
public class MenuRunner implements CommandLineRunner {
	
	@Autowired
	private TableRepository TableRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private PizzaRepository pizzaRepo;
	
	@Autowired
	private DrinkRepository drinkRepo;
	
	//@Autowired
	//private PizzaToppingRepository topRepo;
	
	@Autowired
	private OrderItemRepo oiRep;
	
	@Autowired
	private ApplicationContext ctx;

	@Value("${pizza.coverageprice}")
	private Double coveredPrice;

	@Override
	public void run(String... args) throws Exception {

		Table tavolo = new Table(5, true);
		
		TableRepo.save(tavolo);

		Order ordine = addOrder(tavolo, 3);		

		valorizzaOrdine(ordine);

		orderRepo.save(ordine);

		stampaOrdine(ordine);

	}

	private void valorizzaOrdine(Order order) {

		for (int i = 0; i < 3; i++) {
			Pizza pizza = ctx.getBean(PizzaMargherita.class);
			pizzaRepo.save(pizza);
			OrderItem oi = new OrderItem(pizza, "");
			oiRep.save(oi);
			order.addMenuItem(oi);
		}

//		Pizza pizza =ctx.getBean("margherita", PizzaMargherita.class);
//		pizzaRepo.save(pizza);				
//		PizzaTopping pizzaTopping1 = (PizzaTopping) ctx.getBean("topOnion", pizza);	
//		topRepo.save(pizzaTopping1);//		
//		OrderItem oi1 = new OrderItem(pizzaTopping1, "");
//		oiRep.save(oi1);		
//		order.addMenuItem(oi1);

		Drink drink = ctx.getBean("wine", Drink.class);
		drinkRepo.save(drink);
		OrderItem oi3 = new OrderItem(drink, "");
		oiRep.save(oi3);		
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
		log.info("Numero ordine: {}", order.getId());
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
