package models;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class SeasonTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_abbonamento", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "numero_tessera")
    private User user;
    @ManyToOne
    @JoinColumn(name = "reseller_id")
    private Reseller reseller;
    private LocalDate expireDate;
    
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;
    private LocalDate releaseDate = LocalDate.now();


    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    SeasonTicket(){
        if (periodicity == Periodicity.WEEKLY){
            expireDate = LocalDate.now().plusWeeks(1);
        } else if (periodicity == Periodicity.MONTHLY) {
            expireDate = LocalDate.now().plusMonths(1);
        } else if (periodicity == Periodicity.YEARLY) {
            expireDate = LocalDate.now().minusYears(1);
        } else {
            expireDate = LocalDate.now().plusWeeks(1);
        }
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "SeasonTicket{" +
                "id=" + id +
                ", user=" + user +
                ", reseller=" + reseller +
                ", expireDate=" + expireDate +
                ", periodicity=" + periodicity +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
