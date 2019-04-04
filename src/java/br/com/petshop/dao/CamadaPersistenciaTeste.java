package br.com.petshop.dao;

import br.com.petshop.model.Animal;
import br.com.petshop.model.Cliente;
import br.com.petshop.model.Raca;
import java.util.List;
import javax.persistence.EntityManager;

public class CamadaPersistenciaTeste {
    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        ClienteDao clienteDao = new ClienteDao(em);
        
        //salver
        Cliente c = new Cliente();
        c.setNome("Tyrion Lennister");
        clienteDao.salvar(c);
        
        //consultar
        List<Cliente> listaClientes = clienteDao.consultarProNome("");
        System.out.println(listaClientes);
        
        em.getTransaction().commit();
        em.close();
        
    }
}
