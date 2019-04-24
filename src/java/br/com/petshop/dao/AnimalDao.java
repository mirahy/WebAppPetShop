package br.com.petshop.dao;

import br.com.petshop.model.Animal;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AnimalDao implements Serializable{
    
    private EntityManager em;

    public AnimalDao() {
    }

    public AnimalDao(EntityManager em) {
        this.em = em;
    }
    
    public Animal porId (Integer id){
        return em.find(Animal.class, id);
    }
    
    public List<Animal> consultarProNome(String nome){
        String jpql = "from Animal where nome like :nome";
        TypedQuery<Animal> query = em.createQuery(jpql, Animal.class);
        query.setParameter("nome", nome+"%");
        return query.getResultList();
    }
    
    public void salvar(Animal animal){
        EntityManager em = new JPAUtil().getEntityManager();
         
         em.getTransaction().begin();
         em.persist(animal);
         em.getTransaction().commit();
         em.close();
    }
    
  
     public void alterar (Animal animal){
        EntityManager em = new JPAUtil().getEntityManager();
         
         em.getTransaction().begin();
         em.merge(animal);
         em.getTransaction().commit();
         em.close();
    }
      public void excluir(Animal animal){
        EntityManager em = new JPAUtil().getEntityManager();
         
         em.getTransaction().begin();
        
         em.remove( em.merge(animal));
         em.getTransaction().commit();
         em.close();
    }
    
}
