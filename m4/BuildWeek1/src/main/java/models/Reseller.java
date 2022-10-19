package models;


import models.dao.SeasonTicketDAO;
import models.dao.TicketDAO;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Reseller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    public Reseller() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Reseller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void makeTiket(Reseller reseller) {
        Ticket ticket = new Ticket();
        ticket.setReseller(reseller);
        TicketDAO.save(ticket);
    }

    public void makeSeasonTiket(Reseller reseller, User user, Periodicity periodicity) {
        SeasonTicket ticket = new SeasonTicket();
        ticket.setReseller(reseller);
        ticket.setUser(user);
        ticket.setPeriodicity(periodicity);
        SeasonTicketDAO.save(ticket);
    }
}
