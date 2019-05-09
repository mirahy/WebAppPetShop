
package br.com.petshop.bean;

import br.com.petshop.dao.ClienteDao;
import br.com.petshop.dao.JPAUtil;
import br.com.petshop.model.Cliente;
import br.com.petshop.service.FacesMessages;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import org.primefaces.PrimeFaces;


@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable{
    private EntityManager em = new JPAUtil().getEntityManager();
    private FacesMessages message = new FacesMessages();
    
    private ClienteDao clienteDao = new ClienteDao(em);
    private Cliente cliente;
    private Cliente clienteselecionado;
 
    public void prepararSalvar(){
        cliente = new Cliente();
        
    }
    
    public void salvar(){
        Integer id = this.cliente.getId();
        String operacao= "";
        if(id == 0){
         clienteDao.salvar(this.cliente);
       operacao = " salvo";
        }else{
        
         clienteDao.alterar(this.cliente);
       operacao=" alterado";
        }
        
       
        message.info("Cliente "+operacao+"  com Sucesso!");
        
        PrimeFaces.current().ajax().update(
                Arrays.asList("frm:msgs" , "frm:cliente-tabela")
        );

    }
    
    
    public void excluir(){
    clienteDao.excluir(this.clienteselecionado);
    this.clienteselecionado = null;
    
    getClientes();
    message.info("Cliente excluido com sucesso!");
    
    
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

    public Cliente getClienteselecionado() {
        return clienteselecionado;
    }

    public void setClienteselecionado(Cliente clienteselecionado) {
        this.clienteselecionado = clienteselecionado;
    }
    
    
}
