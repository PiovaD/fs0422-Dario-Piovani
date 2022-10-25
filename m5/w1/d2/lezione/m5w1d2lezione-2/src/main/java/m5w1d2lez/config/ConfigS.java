package m5w1d2lez.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import m5w1d2lez.classes.Address;
import m5w1d2lez.classes.Gender;
import m5w1d2lez.classes.JavaStudent;
import m5w1d2lez.classes.ReactStudent;
import m5w1d2lez.classes.Topic;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigS {

	@Bean
	@Scope("prototype")
	public JavaStudent getJavaStudent() {
		return new JavaStudent("Mario", Gender.M, Arrays.asList( topicJPA()), getAddress(), 9.5);
	}
	
	@Bean
	@Scope("prototype")
	public ReactStudent getReactStudent() {
		return new ReactStudent("Maria", Gender.F, Arrays.asList( topicHooks()), getAddress(), 9.5);
	}
	
	@Bean
	@Scope("prototype")
	public Topic getTopic(String t) {
		return new Topic(t);
	}
	
	@Bean
	public Topic topicSpring() {Topic t = new Topic(); t.setName("Spring"); return t;}

	@Bean
	public Topic topicJPA() {return new Topic("JPA");}

	@Bean
	public Topic topicHooks() {return new Topic("Hooks");}
	
	@Bean
	@Scope("prototype")
	public Address getAddress() {
		return new Address("Via Miano", "Roma");
	}
}
