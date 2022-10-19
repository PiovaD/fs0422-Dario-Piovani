package models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voyage")
public class Voyage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "route_id")
	private Route route;

	@OneToMany(fetch = FetchType.EAGER)
	private Set<Ticket> ticketSet; //TODO verificare se serve
	
	private int travelTime;
	
	public Voyage() {
	}

	public Voyage(Vehicle vehicle, Route route, int travelTime) {
		this.vehicle = vehicle;
		this.route = route;
		this.travelTime = travelTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Set<Ticket> getTicketSet() {
		return ticketSet;
	}

	public void setTicketSet(Set<Ticket> ticketSet) {
		this.ticketSet = ticketSet;
	}
	
	public void addTicketSet(Ticket ticket) {
		this.ticketSet.add(ticket);
	}

	public int getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(int averageTime) {
		this.travelTime = averageTime;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Voyage [id=" + id + ", vehicle=" + vehicle + ", route=" + route + ", ticketSet=" + ticketSet
				+ ", averageTime=" + travelTime + "]";
	}
	
	
	

}
