package m5w1d4es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import m5w1d4es.config.ConfigMenu;
import m5w1d4es.model.Menu;
import m5w1d4es.repositories.MenuRepository;
import m5w1d4es.utils.LogColor;

public class GestioneMenu {
	
	@Autowired
	private MenuRepository mr;

	@Autowired
	private Menu menu;
	
	private ApplicationContext ctx;

	public GestioneMenu() {
		ctx = new AnnotationConfigApplicationContext(ConfigMenu.class);
		this.menu = (Menu) ctx.getBean("menuSettimanale");

		mr.save(this.menu);
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
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
}
