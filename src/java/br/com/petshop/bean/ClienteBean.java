
package br.com.petshop.bean;

import br.com.petshop.dao.DAO;
import br.com.petshop.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable{
    
    public List<Cliente> getClientes(){
        return new DAO<>(Cliente.class).listaTodos();
    }
}
