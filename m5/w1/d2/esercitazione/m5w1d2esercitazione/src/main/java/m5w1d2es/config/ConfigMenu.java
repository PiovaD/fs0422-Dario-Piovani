package m5w1d2es.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import m5w1d2es.model.Drink;
import m5w1d2es.model.Menu;
import m5w1d2es.model.PizzaTopping;
import m5w1d2es.model.Souvenir;
import m5w1d2es.model.enumerable.PizzaSize;
import m5w1d2es.model.order.Order;
import m5w1d2es.model.order.Table;
import m5w1d2es.model.superclass.Pizza;
import m5w1d2es.products.*;

@Configuration
public class ConfigMenu {

	@Bean
	public Menu menu() {

		Menu menu = new Menu();

		menu.getMenuPizza().add(pizzaMargherita());
		menu.getMenuPizza().add(pizzaSalami());

		menu.getMenuTopping().add(new ToppingOnions(null));
		menu.getMenuTopping().add(new ToppingHam(null));


		menu.getMenuDrink().add(water());
		
		menu.getMenuSouvenir().add(souvenirMug());
				

		return menu;

	}

	@Bean
	@Scope("prototype")
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita(PizzaSize.STANDARD);
	}

	@Bean
	@Scope("prototype")
	public Diavola pizzaSalami() {	
		return new Diavola(PizzaSize.STANDARD);
	}
	
	@Bean
	@Scope("prototype")
	public PizzaTopping toppingOnions(Pizza pizza) {
		return new ToppingOnions(pizza);
	}

	@Bean
	@Scope("prototype")
	public PizzaTopping toppingHam(Pizza pizza) {
		return new ToppingHam(pizza);
	}

	@Bean
	@Scope("prototype")
	public Drink water() {
		return new Water();
	}
	
	@Bean
	@Scope("prototype")
	public Drink wine() {
		return new Wine();
	}
	
	@Bean
	@Scope("prototype")
	public Souvenir souvenirMug() {
		return new Mug();
	}
	
	@Bean
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
