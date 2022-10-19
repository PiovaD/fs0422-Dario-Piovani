package models;


import javax.persistence.Entity;

@Entity
public class AutomaticDealer extends Reseller{
 private boolean active = true;

    public AutomaticDealer() {
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
