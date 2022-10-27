package m5w1d4es.model.superclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class IMenuItem {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
	
	public abstract String getName();
	
	public abstract double getPrice();
}
