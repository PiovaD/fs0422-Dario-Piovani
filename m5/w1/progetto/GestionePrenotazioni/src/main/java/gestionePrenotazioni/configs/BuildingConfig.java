package gestionePrenotazioni.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import gestionePrenotazioni.models.Building;
import gestionePrenotazioni.models.Workstation;

@Configuration
public class BuildingConfig {

	@Autowired 
	@Qualifier("ws1") 
	Workstation w1;
	
	@Autowired
	@Qualifier("ws2") 
	Workstation w2;
	
	@Autowired
	@Qualifier("ws3") 
	Workstation w3;
	
	@Autowired
	@Qualifier("ws4")
	Workstation w4;

	@Bean(name = "b1")
	@Scope("singleton")
	public Building newBuilding1() {
		Building b1 = new Building("Epicode", "Via dei Magazzini Generali, 16", "Roma");
		b1.getWorkstationSet().add(w1);
		b1.getWorkstationSet().add(w2);
		return b1;
	}
	
	@Bean(name = "b2")
	@Scope("singleton")
	public Building newBuilding2() {
		Building b2 = new Building("Deloitte", "Via Tortona, 25", "Milano");
		b2.getWorkstationSet().add(w3);
		b2.getWorkstationSet().add(w4);
		return b2;
	}
}
