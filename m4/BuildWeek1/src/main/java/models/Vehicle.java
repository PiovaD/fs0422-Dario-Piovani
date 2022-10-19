package models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private VehicleType type;

	@OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private Voyage voyage;

	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private Set<Ticket> ticket;

	private boolean isService;
	private LocalDate maintenance;
	private short capacity;

	public Vehicle() {
	}

	public Vehicle(VehicleType type) {
		this.type = type;
		this.setMaintenance();
		this.setCapacity(type);
		setService();
	}

	private void setCapacity(VehicleType type) {
		if (type == VehicleType.BUS)

			this.capacity = 50;
		else if (type == VehicleType.TRAM)

			this.capacity = 100;
		else
			System.err.println("Unexpected value: " + type);

	}

	public void setType(VehicleType type) {
		this.type = type;
		this.setCapacity(type);
	}

	public void setMaintenance() {
		this.maintenance = LocalDate.now()
				.plusYears(1);
	}

	public void setMaintenance(LocalDate maintenance) {
		this.maintenance = maintenance;
	}

	public short getCapacity() {
		return capacity;
	}

	public VehicleType getType() {
		return type;
	}

	public LocalDate getMaintenance() {
		return maintenance;
	}

	public Long getId() {
		return id;
	}

	public boolean getIsService() {
		if (this.isService == true) {
			this.setService();
		}

		return isService;
	}

	public void setService() {
		this.isService = (LocalDate.now()).isBefore(this.maintenance);
	}

	public void setService(boolean service) {
		boolean s = (LocalDate.now()).isBefore(this.maintenance);

		if (s && service)
			this.isService = true;
		else
			this.isService = false;

	}

	@Override
	public String toString() {
		return "Vehicle [id: " + id + " | Capacity: " + capacity + " | Type=" + type + " | Maintance=" + maintenance
				+ " | Service: " + isService + "]";
	}
}
