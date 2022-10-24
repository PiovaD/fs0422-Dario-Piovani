package m5w1d1es.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import m5w1d1es.model.Drink;
import m5w1d1es.model.Menu;
import m5w1d1es.model.Souvenir;
import m5w1d1es.model.enumerable.PizzaSize;
import m5w1d1es.model.products.*;

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
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita(PizzaSize.STANDARD);
	}

	@Bean
	public Diavola pizzaSalami() {	
		return new Diavola(PizzaSize.STANDARD);
	}

	@Bean
	public Drink water() {
		return new Water();
	}
	
	@Bean
	public Souvenir souvenirMug() {
		return new Mug();
	}
}
