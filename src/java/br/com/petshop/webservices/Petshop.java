/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.webservices;

import br.com.petshop.model.Cliente;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Estudante
 */
@Path("petshop")
public class Petshop {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Petshop
     */
    public Petshop() {
    }

    /**
     * Retrieves representation of an instance of br.com.petshop.webservices.Petshop
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cliente/get")
    public String getCliente() {
        
        Cliente c = new Cliente();
        c.setNome("Jon Snow");
        c.setEndereco("Castle Black");
        
        Gson g = new Gson();
        return g.toJson(c);
    }

    /**
     * PUT method for updating or creating an instance of Petshop
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
