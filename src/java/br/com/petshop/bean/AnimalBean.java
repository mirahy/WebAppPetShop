
package br.com.petshop.bean;

import br.com.petshop.dao.AnimalDao;
import br.com.petshop.dao.DAO;
import br.com.petshop.dao.JPAUtil;
import br.com.petshop.model.Animal;
import br.com.petshop.model.Cliente;
import br.com.petshop.model.Raca;
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
public class AnimalBean implements Serializable{
    private EntityManager em = new JPAUtil().getEntityManager();
    private FacesMessages message = new FacesMessages();
    
    private AnimalDao animalDao = new AnimalDao(em);
    private Animal animal;
    
    private Animal animalselecionado;
 
    public void prepararSalvar(){
        animal = new Animal();
        
    }
    
    public List<Raca> getRacas(){
        return new DAO(Raca.class).listaTodos();
    }
    
    public List<Cliente> getClientes(){
        return new DAO(Cliente.class).listaTodos();
    }
    
    public void excluir(){
    animalDao.excluir(this.animalselecionado);
    this.animalselecionado = null;
    
    getAnimais();
    message.info("Animal excluido com sucesso!");
    
    
    }
    
    public void salvar(){
        Integer id = this.animal.getId();
        String operacao= "";
        if(id == 0){
         animalDao.salvar(this.animal);
       operacao = " salvo";
        }else{
        
         animalDao.alterar(this.animal);
       operacao=" alterado";
        }
        
       
        message.info("Animal "+operacao+"  com Sucesso!");
        
        PrimeFaces.current().ajax().update(
                Arrays.asList("frm:msgs" , "frm:animal-tabela")
        
        
        );
        

//        clienteDao.salvar(this.cliente);
//        System.out.println(this.cliente.getNome());
//        message.info("Cliente salvo com Sucesso!");
//        
//        RequestContext.getCurrentInstance().update(
//                Arrays.asList("frm:msgs", "frm:cliente-tabela")
//        );

    }
    
    
    public List<Animal> getAnimais(){
        List<Animal> listaAnimais = animalDao.consultarProNome("");
        return listaAnimais;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimalselecionado() {
        return animalselecionado;
    }

    public void setAnimalselecionado(Animal animalselecionado) {
        this.animalselecionado = animalselecionado;
    }

    
    
    
}
