package br.com.petshop.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


@ManagedBean
@SessionScoped
public class TesteBean implements Serializable{
    
    private static Integer numeroDeInstancia = 0;

    public TesteBean() {
        numeroDeInstancia++;
    }
    
    public Integer getNumeroDeInstancia(){
        return numeroDeInstancia;
    }
    
}
