package models;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_tessera", nullable = false)
    private Long numeroTessera;
    private String name;
    private String lastName;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return numeroTessera;
    }

    public void setId(Long numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    @Override
    public String toString() {
        return " Utente" +
                " | N. TESSERA= '" + numeroTessera +
                "' | NOME= '" + name + '\'' +
                " | COGNOME= '" + lastName +
                "' ";
    }
}