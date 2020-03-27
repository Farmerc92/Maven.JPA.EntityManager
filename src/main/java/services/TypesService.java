package services;

import entities.Pokemons;
import entities.Types;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TypesService {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Types");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    public Types createTypes(long id, String name){
        Types type = new Types(id, name);

        entityTransaction.begin();
        entityManager.persist(type);
        entityTransaction.commit();

        return type;
    }

    public Types createTypes(Types types){
        entityTransaction.begin();
        entityManager.persist(types);
        entityTransaction.commit();

        return types;
    }

    public Types findTypes(long id){
        return entityManager.find(Types.class, id);
    }

    public List<Types> findAllTypes(){
        CriteriaQuery<Types> criteria = entityManager.getCriteriaBuilder().createQuery(Types.class);
        criteria.select(criteria.from(Types.class));
        return entityManager.createQuery(criteria).getResultList();
    }

    public Types updateTypes(long id, String name){
        Types type = findTypes(id);
        entityTransaction.begin();
        type.setName(name);
        entityTransaction.commit();
        return type;
    }

    public Types deleteTypes(long id){
        Types types = findTypes(id);
        entityTransaction.begin();
        entityManager.remove(types);
        entityTransaction.commit();
        return types;
    }
}
