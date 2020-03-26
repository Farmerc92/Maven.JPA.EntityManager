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
}
