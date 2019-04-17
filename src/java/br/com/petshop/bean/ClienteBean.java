
package br.com.petshop.bean;

import br.com.petshop.dao.ClienteDao;
import br.com.petshop.dao.DAO;
import br.com.petshop.dao.JPAUtil;
import br.com.petshop.model.Cliente;
import br.com.petshop.service.FacesMessages;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable{
    private EntityManager em = new JPAUtil().getEntityManager();
    private FacesMessages message = new FacesMessages();
    
    private ClienteDao clienteDao = new ClienteDao(em);
    private Cliente cliente;
    
    public void prepararSalvar(){
        cliente = new Cliente();
        
    }
    
    
    public void salvar(){
        clienteDao.salvar(this.cliente);
//        System.out.println(this.cliente.getNome());
        message.info("Cliente salvo com Sucesso!");
        
        RequestContext.getCurrentInstance().update(
                Arrays.asList("frm:msgs", "frm:cliente-tabela")
        );
    }
    
    
    public List<Cliente> getClientes(){
        List<Cliente> listaClientes = clienteDao.consultarProNome("");
        return listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
