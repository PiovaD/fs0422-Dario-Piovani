package models;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    
    private LocalDate releaseDate;
    private LocalDate punch;
    
    @ManyToOne
    @JoinColumn(name = "reseller_id")
    private Reseller reseller;

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public Ticket() {
		this.releaseDate = LocalDate.now();
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPunch() {
        return punch;
    }

    public void setPunch(LocalDate punch) {
        this.punch = punch;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
        @Override
        public String toString() {
            return "Ticket{" +
                    "id=" + id +
                    ", releaseDate=" + releaseDate +
                    ", punch=" + punch +
                    ", reseller=" + reseller +
                    '}';
        }
    
}