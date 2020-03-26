package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "types")
public class Types {
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    private Set<Pokemons> types = new HashSet<>();

    public Types(){}

    public Types(long id, String name){
        this.id = id;
        this.name = name;
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

    public Set<Pokemons> getTypes() {
        return types;
    }

    public void setTypes(Set<Pokemons> types) {
        this.types = types;
    }

    @Override
    public String toString(){
        return "ID: " + getId() + " Type: " + getName();
    }
}
