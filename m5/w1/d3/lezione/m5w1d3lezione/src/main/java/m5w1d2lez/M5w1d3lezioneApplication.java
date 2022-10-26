package m5w1d2lez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import m5w1d2lez.beans.Dog;
import m5w1d2lez.classes.Person;
import m5w1d2lez.components.School;
import m5w1d2lez.config.Conf2;

@SpringBootApplication
public class M5w1d3lezioneApplication {

	public static void main(String[] args) {
		SpringApplication.run(M5w1d3lezioneApplication.class, args);

		//config1();
		
		//config2();
		//---------------
		//el1();
		
		//el2();
		
		//el3();
		//---------------
		config3();
		
	}

	public static void config1() {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.scan("m5w1d2lez.components");
		ctx.refresh();

		School s = ctx.getBean("sc", School.class);

		System.out.println(s);

		ctx.close();
	}

	public static void config2() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Conf2.class);

		Dog d1 = ctx.getBean("dog1", Dog.class);
		
		System.out.println(d1);
		
		ctx.close();
	}
	
	public static void el1() {
		ExpressionParser parser = new SpelExpressionParser();
		
		Expression e1 = parser.parseExpression("'Ciao sono un corso java'.toUpperCase()");
		
		String s1 = (String) e1.getValue();
		System.out.println(s1);
	}
	
	public static void el2() {
		ExpressionParser parser = new SpelExpressionParser();
		
		Expression e1 = parser.parseExpression("10*5");
		
		int s1 = (int) e1.getValue();
		System.out.println(s1);
	}
	
	public static void el3() {
		ExpressionParser parser = new SpelExpressionParser();
		
		Expression e1 = parser.parseExpression("'JavaScript'.length() == 10");
		
		boolean s1 = (boolean) e1.getValue();
		System.out.println(s1);
	}
	
	public static void config3() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Person p1 = ctx.getBean("person1", Person.class);
		
		System.out.println(p1);
		
		ctx.close();
	}
}
