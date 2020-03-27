package services;

import entities.Pokemons;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PokemonsService {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Pokemons");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    public Pokemons createPokemons(long id, String name, int primaryType, int secondaryType){
        Pokemons pokemon = new Pokemons(id, name, primaryType, secondaryType);

        entityTransaction.begin();
        entityManager.persist(pokemon);
        entityTransaction.commit();

        return pokemon;
    }

    public Pokemons createPokemons(Pokemons pokemon){
        entityTransaction.begin();
        entityManager.persist(pokemon);
        entityTransaction.commit();

        return pokemon;
    }

    public Pokemons findCookbook(long id){
        return entityManager.find(Pokemons.class, id);
    }

    public List<Pokemons> findAllPokemons(){
        CriteriaQuery<Pokemons> criteria = entityManager.getCriteriaBuilder().createQuery(Pokemons.class);
        criteria.select(criteria.from(Pokemons.class));
        return entityManager.createQuery(criteria).getResultList();
    }


}
