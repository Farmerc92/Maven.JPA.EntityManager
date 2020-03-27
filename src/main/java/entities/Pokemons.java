package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokemons")
public class Pokemons {
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "Primary_Type")
    private int primaryType;

    @Column(name = "Secondary_Type")
    private int secondaryType;

    @OneToMany
    private Set<Types> pokemons = new HashSet<>();

    public Pokemons() {
    }

    public Pokemons(long id, String name, int primaryType, int secondaryType){
        this.id = id;
        this.name = name;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(int primaryType) {
        this.primaryType = primaryType;
    }

    public int getSecondaryType() {
        return secondaryType;
    }

    public void setSecondaryType(int secondaryType) {
        this.secondaryType = secondaryType;
    }

    @Override
    public String toString(){
        return "ID: " + getId() + " Name: " + getName() + " Primary Type: "+ getPrimaryType()
                + " Secondary Type: "+getSecondaryType();
    }
}
