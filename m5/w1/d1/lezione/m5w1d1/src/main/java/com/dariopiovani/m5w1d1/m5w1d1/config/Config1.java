package com.dariopiovani.m5w1d1.m5w1d1.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.dariopiovani.m5w1d1.m5w1d1.components.Address;
import com.dariopiovani.m5w1d1.m5w1d1.components.Carpenter;
import com.dariopiovani.m5w1d1.m5w1d1.components.Student;
import com.dariopiovani.m5w1d1.m5w1d1.components.WebDev;
import com.dariopiovani.m5w1d1.m5w1d1.components.Work;

@Configuration
@PropertySource("classpath:application.properties")
public class Config1 {

	@Bean
	@Scope("prototype")
	public Student getStudent() {
		return new Student();
	}

	@Value("${student2.name}")
	private String student2Name;
	
	@Bean
	public Student getStudent2() {
		return new Student(student2Name , new int[] { 1, 2, 6, 8, 10 });
	}

	@Bean
	public Address getAddress3() {
		return new Address("Via Como");
	}

	@Bean
	public Student getStudent3() {
		return new Student("Paolo", new int[] { 1, 2, 6, 8, 10 }, getAddress3());
	}
	
	@Bean
	public Student getStudent4(Address getAddress4) {
		return new Student(student2Name, getAddress4 );
	}
	
	@Bean
	public Address getAddress4() {
		return new Address("Via Col Di Lana");
	}
	
	@Bean
	public Student getStudent5(@Qualifier("ga5") Address address) {
		return new Student(student2Name, address );
	}
	
	@Bean
	@Qualifier("ga5")
	public Address getAddress5() {
		return new Address("Via Roma");
	}
	
	@Bean
	public Student getStudent6(@Qualifier("web") Work w) {
		return new Student("Carlo", w);
	}
	
	@Bean("web")
	public Work getWork6() {
		return new WebDev();
	}
	
	@Bean("carp")
	public Work getWork7() {
		return new Carpenter();
	}

	

}
