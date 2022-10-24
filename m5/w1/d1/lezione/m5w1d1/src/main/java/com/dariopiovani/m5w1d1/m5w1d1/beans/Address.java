package com.dariopiovani.m5w1d1.m5w1d1.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Address {
	private String road;
	private City city;	
	
	public Address(String road) {
		this.road = road;
	}
		
}
