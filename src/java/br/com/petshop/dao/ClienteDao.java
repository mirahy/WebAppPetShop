package br.com.petshop.dao;

import br.com.petshop.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ClienteDao implements Serializable{
    
    private EntityManager em;

    public ClienteDao() {
    }

    public ClienteDao(EntityManager em) {
        this.em = em;
    }
    
    public Cliente porId (Integer id){
        return em.find(Cliente.class, id);
    }
    
    public List<Cliente> consultarProNome(String nome){
        String jpql = "from Cliente where nome like :nome";
        TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
        query.setParameter("nome", nome+"%");
        return query.getResultList();
    }
    
    public Cliente salvar(Cliente cliente){
        return em.merge(cliente);
    }
    
    public void excluir(Cliente cliente){
        cliente = porId(cliente.getId());
        em.remove(cliente);
    }
}
