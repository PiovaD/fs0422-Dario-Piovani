package com.dariopiovani.m5w1d1.m5w1d1.components;

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
public abstract class Work {
	
	private String name;
	private double salary;
	
	public abstract void hello();
}
