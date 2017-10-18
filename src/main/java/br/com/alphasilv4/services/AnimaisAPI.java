/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.services;

import br.com.alphasilv4.mock.Animal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("/animais")
public class AnimaisAPI implements Serializable {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Animal> getAll() {

        List<Animal> list = new ArrayList<>();

        try {

            System.out.println("animais GET -> getALL");

            Animal h1 = new Animal("Burt Bear", "assets/img/speakers/bear.jpg", "Burt is a Bear.");
            Animal h2 = new Animal("Charlie Cheetah", "assets/img/speakers/cheetah.jpg", "Charlie is a Cheetah.");
            Animal h3 = new Animal("Donald Duck", "assets/img/speakers/duck.jpg", "Donald is a Duck.");
            Animal h4 = new Animal("Eva Eagle", "assets/img/speakers/eagle.jpg", "Eva is an Eagle.");
            Animal h5 = new Animal("Ellie Elephant", "assets/img/speakers/elephant.jpg", "Ellie is an Elephant.");
            Animal h6 = new Animal("Molly Mouse", "assets/img/speakers/mouse.jpg", "Molly is a Mouse.");
            Animal h7 = new Animal("Paul Puppy", "assets/img/speakers/puppy.jpg", "Paul is a Puppy.");
            Animal h8 = new Animal("Tartaruga Ninja", "assets/img/speakers/turtle.jpg", "É a tartaruga mais rápida da terra..");
            
            list.add(h1);
            list.add(h2);
            list.add(h3);
            list.add(h4);
            list.add(h5);
            list.add(h6);
            list.add(h7);
            list.add(h8);

        } catch (Exception e) {
            System.err.println("ERRO: " + e);
            throw new BadRequestException();
        }

        return list;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Animal getById(@PathParam("id") Integer id) {

        Animal hero = new Animal();
        List<Animal> list = new ArrayList<>();

        try {

            System.out.println("animais GET -> findById");

            Animal h1 = new Animal("Burt Bear", "assets/img/speakers/bear.jpg", "Burt is a Bear.");
            Animal h2 = new Animal("Charlie Cheetah", "assets/img/speakers/cheetah.jpg", "Charlie is a Cheetah.");
            Animal h3 = new Animal("Donald Duck", "assets/img/speakers/duck.jpg", "Donald is a Duck.");
            Animal h4 = new Animal("Eva Eagle", "assets/img/speakers/eagle.jpg", "Eva is an Eagle.");
            Animal h5 = new Animal("Ellie Elephant", "assets/img/speakers/elephant.jpg", "Ellie is an Elephant.");
            Animal h6 = new Animal("Molly Mouse", "assets/img/speakers/mouse.jpg", "Molly is a Mouse.");
            Animal h7 = new Animal("Paul Puppy", "assets/img/speakers/puppy.jpg", "Paul is a Puppy.");

            list.add(h1);
            list.add(h2);
            list.add(h3);
            list.add(h4);
            list.add(h5);
            list.add(h6);
            list.add(h7);

            for (Animal h : list) {
                System.out.println("Animal " + h.getName());
            }

        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

        return hero;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Animal hero) {

        try {
            System.out.println("animais PUT -> update");
            System.out.println("Animal ID: " + hero.getAbout());
            System.out.println("HERO NOME: " + hero.getName());

        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Animal create(Animal hero) {

        System.out.println("animais POST -> create");
        
        try {            
            System.out.println("Name: " + hero.getName());
            System.out.println("About: " + hero.getAbout());
            System.out.println("ProfilePic: " + hero.getProfilePic());
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

        return hero;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {

        try {
            System.out.println("animais DELETE -> delete");
            System.out.println("ID: " + id);

        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

    }

}
