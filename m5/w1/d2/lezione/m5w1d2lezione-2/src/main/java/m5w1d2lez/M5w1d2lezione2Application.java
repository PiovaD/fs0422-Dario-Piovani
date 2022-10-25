package m5w1d2lez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import m5w1d2lez.classes.JavaStudent;
import m5w1d2lez.classes.ReactStudent;
import m5w1d2lez.config.ConfigS;

@SpringBootApplication
public class M5w1d2lezione2Application {

	public static void main(String[] args) {
		SpringApplication.run(M5w1d2lezione2Application.class, args);
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ConfigS.class);
		
		JavaStudent js1 = ac.getBean("getJavaStudent", JavaStudent.class);
		js1.hello();
		System.out.println( "js1 topics: " + js1.getTopics() );
		System.out.println( js1.getAddress() );
		
		ReactStudent rs1 = ac.getBean("getReactStudent", ReactStudent.class);
		rs1.hello();
		System.out.println( "rs1 topics: " + rs1.getTopics() );
		System.out.println( rs1.getAddress() );
		
		((AnnotationConfigApplicationContext)ac).close();
	}

}
