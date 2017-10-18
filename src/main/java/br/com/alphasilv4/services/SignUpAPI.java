/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.services;

import br.com.alphasilv4.mock.Account;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Servico Rest responsavel por retornar informacoes para o front-end.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@Path("/signup")
public class SignUpAPI implements Serializable {

    //private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikings_PU");
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAll() {

        System.out.println("signup GET -> getALL");

        List<Account> list = new ArrayList<>();

        try {

            Account login1 = new Account("joao", "joao@marte.com.br", "12343");
            Account login2 = new Account("maria", "maria@jupter.com.br", "12344");
            Account login3 = new Account("jose", "jose@saturno.com.br", "12345");
            list.add(login1);
            list.add(login2);
            list.add(login3);

        } catch (Exception e) {
            System.err.println("ERRO: " + e);
            throw new BadRequestException();
        }

        return list;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account findById(@PathParam("id") Long id) {

        System.out.println("signup GET -> findById");

        Account login1 = null;
        try {
            login1 = new Account("joao", "joao@marte.com.br", "12343");
            System.out.println("profiles:" + id);
            System.out.println("name: " + login1.getName());
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

        return login1;
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account findByEmail(@PathParam("email") String email) {

        System.out.println("signup GET -> findByEmail");

        Account login1 = null;
        try {
            login1 = new Account("joao", "joao@marte.com.br", "12343");
            System.out.println("profiles:" + email);
            System.out.println("name: " + login1.getName());
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

        return login1;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Long id, Account login) {

        System.out.println("signup PUT -> update");

        try {
            System.out.println("id: " + id);
            System.out.println("name: " + login.getName());
            System.out.println("Email: " + login.getEmail());
            System.out.println("Password: " + login.getPassword());
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account create(Account login) {

        System.out.println("signup POST -> create");

        Account login1 = login;
        try {
            System.out.println("name: " + login1.getName());
            System.out.println("Email: " + login1.getEmail());
            System.out.println("Password: " + login1.getPassword());
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

        return login1;
    }

}
