package com.dariopiovani.m5w1d1.m5w1d1.components;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Component
@Builder
public class Student {
	private String name;
	private int[] vote;
	private Address address;	
	private Work work;
	
	
	public Student(String name, int[] vote) {
		this.name = name;
		this.vote = vote;
	}


	public Student(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	

	public Student(String name, Work work) {
		this.name = name;
		this.work = work;
	}


	public Student(String name, int[] vote, Address address) {
		this.name = name;
		this.vote = vote;
		this.address = address;
	}
	
	
}
