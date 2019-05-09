package br.com.petshop.bean;

import br.com.petshop.dao.DAO;
import br.com.petshop.model.Animal;
import br.com.petshop.model.Cliente;
import br.com.petshop.model.Raca;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AnimalBean {
    
    private Animal animal;
    private Integer racaId;
    private Integer proprietarioId;
 
    public void prepararSalvar(){
        animal = new Animal();
    }
    
    public void salvar() {
        Raca raca = new DAO<Raca>(Raca.class).porId(this.racaId);
        Cliente proprietario = new DAO<Cliente>(Cliente.class).porId(this.proprietarioId);
        animal.setRaca(raca);
        animal.setProprietario(proprietario);
        
        DAO daoAnimal = new DAO(Animal.class);
        daoAnimal.salvar(animal);
        
        System.out.println("***************************************");
        System.out.println("Animal....:"+animal.getNome());
        System.out.println("Raça....:"+animal.getRaca().getRaca());
        System.out.println("Cliente....:"+animal.getProprietario().getNome());
    }
    
    public List<Raca> getRacas(){
        return new DAO(Raca.class).listaTodos();
    }
    
    public List<Cliente> getClientes(){
        return new DAO(Cliente.class).listaTodos();
    }
    

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Integer getRacaId() {
        return racaId;
    }

    public void setRacaId(Integer racaId) {
        this.racaId = racaId;
    }

    public Integer getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(Integer proprietarioId) {
        this.proprietarioId = proprietarioId;
    }
    
}
