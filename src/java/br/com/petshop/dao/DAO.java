
package br.com.petshop.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Criteria;

public class DAO<T> {
    private final JPAUtil factoty = new JPAUtil();
    private final Class<T> classe;

    public DAO(Class<T> classe) {
        this.classe = classe;
    }
    
    public  List<T> listaTodos(){
        //EntityManager em = factoty.getEntityManager();
        EntityManager em = new JPAUtil().getEntityManager();
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));
        
        List<T> lista = em.createQuery(query).getResultList();
        em.close();
        return lista;
    }
    
}
