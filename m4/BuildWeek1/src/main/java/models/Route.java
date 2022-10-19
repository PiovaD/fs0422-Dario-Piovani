package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "routes")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String start;
	private String finish;
	private int travelTime;

	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
	private Set<Voyage> voyage;

	public Route() {
	}

	public Route(String start, String finish, int travelTime) {
		this.start = start;
		this.finish = finish;
		this.travelTime = travelTime;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String s) {
		this.start = s;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String f) {
		this.finish = f;
	}
	
	public int getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(int tt) {
		this.travelTime = tt;
	}

	
	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Route: [Start: " + start + " | Finish: " + finish + " | Travel time: " + travelTime + " ]";
	}

}
