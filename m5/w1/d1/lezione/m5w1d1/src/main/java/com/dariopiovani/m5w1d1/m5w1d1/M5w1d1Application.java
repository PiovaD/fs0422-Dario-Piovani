package com.dariopiovani.m5w1d1.m5w1d1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dariopiovani.m5w1d1.m5w1d1.beans.Person;
import com.dariopiovani.m5w1d1.m5w1d1.components.A;
import com.dariopiovani.m5w1d1.m5w1d1.components.Student;
import com.dariopiovani.m5w1d1.m5w1d1.config.Config1;

@SpringBootApplication
public class M5w1d1Application {

	public static void main(String[] args) {
		SpringApplication.run(M5w1d1Application.class, args);
		
		//conf1();
		//conf2();
		conf3();
	}
	
	public static void conf1() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Person p1 = ctx.getBean("p1", Person.class);
		Person p1_2 = ctx.getBean("p1", Person.class);
		
		p1.setName("Luigi");
		System.out.println(p1);
		System.out.println(p1_2);
		
		Person p2 = ctx.getBean("p2", Person.class);
		
		System.out.println(p2);
		
		Person p3 = ctx.getBean("p3", Person.class);
		
		System.out.println(p3);
		
		Person p4 = ctx.getBean("p4", Person.class);
		
		System.out.println(p4);
		
		Person p5 = ctx.getBean("p5", Person.class);
		
		System.out.println(p5);
		
		((ClassPathXmlApplicationContext)ctx).close();
		
	}

	public static void conf2() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config1.class);
		
		Student s1 = ctx.getBean("getStudent", Student.class);		
		System.out.println(s1);
		
		Student s2 = ctx.getBean("getStudent2", Student.class);		
		System.out.println(s2);
		
		Student s3 = ctx.getBean("getStudent3", Student.class);		
		System.out.println(s3);
		
		Student s1_2 = ctx.getBean("getStudent", Student.class);
		s1.setName("Francesco");
		System.out.println(s1_2.getName());
		
		Student s4 = ctx.getBean("getStudent4", Student.class);		
		System.out.println(s4);
		
		Student s5 = ctx.getBean("getStudent5", Student.class);		
		System.out.println(s5);
		
		Student s6 = ctx.getBean("getStudent6", Student.class);		
		System.out.println(s6);
		
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
	public static void conf3() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		ctx.scan(new String[]{"com.dariopiovani.m5w1d1.m5w1d1.components"});
		ctx.refresh();
		
		A a1 = (A)ctx.getBean("a", A.class);
		
		System.out.println(a1);
		
		
		ctx.close();
	}
}
