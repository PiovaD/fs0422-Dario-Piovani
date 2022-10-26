package m5w1d2es;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import m5w1d2es.config.ConfigMenu;
import m5w1d2es.model.Menu;
import m5w1d2es.utils.LogColor;

public class GestioneMenu {

	private Menu menu;
	private AnnotationConfigApplicationContext ctx;

	public GestioneMenu() {
		ctx = new AnnotationConfigApplicationContext(ConfigMenu.class);
		this.menu = (Menu) ctx.getBean("menuSettimanale");

	}

	public void stampaMenu() {
		System.out.println(LogColor.CYAN("******* Menu *******"));
		System.out.println(LogColor.YELLOW("PIZZA"));
		menu.getMenuPizza().forEach(p -> System.out.println(p));
		System.out.println();

		System.out.println(LogColor.YELLOW("DRINK"));
		menu.getMenuDrink().forEach(p -> System.out.println(p));

		System.out.println();

		System.out.println(LogColor.YELLOW("SOUVENIR"));
		menu.getMenuSouvenir().forEach(p -> System.out.println(p));

	}
	
	public void closeCtx() {
		ctx.close();
	}
	
}
