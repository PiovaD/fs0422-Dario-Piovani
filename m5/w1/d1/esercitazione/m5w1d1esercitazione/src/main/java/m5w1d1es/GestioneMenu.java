package m5w1d1es;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import m5w1d1es.config.ConfigMenu;
import m5w1d1es.model.Menu;
import m5w1d1es.model.enumerable.PizzaSize;
import m5w1d1es.model.products.Diavola;
import m5w1d1es.model.products.PizzaMargherita;
import m5w1d1es.model.products.ToppingHam;
import m5w1d1es.model.products.ToppingOnions;
import m5w1d1es.utils.LogColor;

public class GestioneMenu {

	private Menu menu;
	private AnnotationConfigApplicationContext ctx;

	public GestioneMenu() {
		ctx = new AnnotationConfigApplicationContext(ConfigMenu.class);
		this.menu = (Menu) ctx.getBean("menu");

	}

	public void stampaMenu() {
		System.out.println(LogColor.CYAN("******* Menu *******"));
		System.out.println(LogColor.YELLOW("PIZZA"));
		menu.getMenuPizza().forEach(p -> System.out.println(p));
		System.out.println();

		System.out.println(LogColor.YELLOW("DRINK"));
		menu.getMenuDrink().forEach(p -> System.out.println(p));

		System.out.println();

		System.out.println(LogColor.YELLOW("FRANCHISE"));
		menu.getMenuSouvenir().forEach(p -> System.out.println(p));

	}

	public void testTopping() {

		PizzaMargherita pizza = ctx.getBean(PizzaMargherita.class);
		
		
		ToppingOnions topping1 = new ToppingOnions(pizza);

		System.out.println(topping1);
		
		ToppingHam topping2 = new ToppingHam(topping1);

		System.out.println(topping2);
		
		Diavola toppingBig = new Diavola(PizzaSize.FAMILY);
		System.out.println(toppingBig);

		
	}
}
