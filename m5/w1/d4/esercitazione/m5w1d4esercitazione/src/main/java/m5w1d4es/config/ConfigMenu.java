package m5w1d4es.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import m5w1d4es.model.Drink;
import m5w1d4es.model.Menu;
import m5w1d4es.model.PizzaTopping;
import m5w1d4es.model.Souvenir;
import m5w1d4es.model.enumerable.PizzaSize;
import m5w1d4es.model.order.Order;
import m5w1d4es.model.order.Table;
import m5w1d4es.model.superclass.Pizza;
import m5w1d4es.products.*;

@Configuration
public class ConfigMenu {

	@Autowired
	private ApplicationContext ctx;
	
	@Bean(name = "menuSettimanale")
	@Scope("singleton")
	public Menu menu() {

		Menu menu = new Menu();

		menu.getMenuPizza().add(ctx.getBean("margherita", Pizza.class));
		menu.getMenuPizza().add(ctx.getBean("diavola", Pizza.class));

		menu.getMenuTopping().add(ctx.getBean("topOnion", PizzaTopping.class));
		menu.getMenuTopping().add(ctx.getBean("topHam", PizzaTopping.class));

		menu.getMenuDrink().add(ctx.getBean("water", Drink.class));
		
		menu.getMenuSouvenir().add(ctx.getBean("mug", Souvenir.class));
					
		return menu;

	}

	@Bean(name = "margherita")
	@Scope("prototype")
	@Primary
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita(PizzaSize.STANDARD);
	}

	@Bean(name = "diavola")
	@Scope("prototype")
	public Diavola pizzaSalami() {	
		return new Diavola(PizzaSize.STANDARD);
	}
	
	@Bean(name = "topOnion")
	@Scope("singleton")
	public PizzaTopping toppingOnions(Pizza pizza) {
		return new ToppingOnions(pizza);
	}

	@Bean(name = "topHam")
	@Scope("singleton")
	public PizzaTopping toppingHam(Pizza pizza) {
		return new ToppingHam(pizza);
	}

	@Bean(name = "water")
	@Scope("singleton")
	public Drink water() {
		return new Water();
	}
	
	@Bean(name = "wine")
	@Scope("singleton")
	public Drink wine() {
		return new Wine();
	}
	
	@Bean(name = "mug")
	@Scope("singleton")
	public Souvenir souvenirMug() {
		return new Mug();
	}
	
	@Bean(name = "oreder")
	@Scope("prototype")
	public Order order() {
		return new Order();
	}
	
	
	@Bean
	@Scope("prototype")
	public Table tavolo( int numeroMassimoCoperti, Boolean occupato) {
		return new Table(numeroMassimoCoperti, occupato);
	}
}
