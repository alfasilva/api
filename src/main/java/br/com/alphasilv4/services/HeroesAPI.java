/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.services;

import br.com.alphasilv4.dao.HeroDao;
import br.com.alphasilv4.entities.Hero;
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
@Path("/heroes")
public class HeroesAPI implements Serializable {

    /**
     * Retorna todos os objetos do banco.
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hero> getAll() {
        System.out.println("heroes GET -> getALL");
        List<Hero> retorno = new ArrayList<>();
        try {
            HeroDao dao = new HeroDao();
            retorno = dao.findAll();
        } catch (Exception e) {
            System.err.println(e);
            throw new BadRequestException();
        }
        return retorno;
    }

    /**
     * Retorna objeto do banco de acordo com o ID informado.
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hero getById(@PathParam("id") Integer id) {

        System.out.println("heroes GET -> findById:" + id);
        Hero retorno = new Hero();

        try {
            HeroDao dao = new HeroDao();
            retorno = dao.findById(id);
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

        return retorno;
    }

    /**
     * Retorna objeto do banco de acordo com o ID informado.
     *
     * @param name
     * @return
     */
    @GET
    @Path("name/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hero> getByName(@PathParam("name") String name) {
        System.out.println("heroes GET -> findByName:" + name);
        List<Hero> retorno = new ArrayList<Hero>();
        try {
            HeroDao dao = new HeroDao();
            retorno = dao.findByNameRetList(name);
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }
        return retorno;
    }

    /**
     * Atualiza objeto hero no Banco de Dados.
     *
     * @param hero
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Hero hero) {

        System.out.println("heroes PUT -> update");
        try {
            HeroDao dao = new HeroDao();
            dao.update(hero);
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

    }

    /**
     * Cria objeto hero no Banco de Dados.
     *
     * @param hero
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Hero create(Hero hero) {

        System.out.println("heroes POST -> create");
        Hero retoro = hero;
        try {
            HeroDao dao = new HeroDao();
            dao.create(hero);
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

        return retoro;
    }

    /**
     * Remove objeto hero do Banco de Dados.
     *
     * @param id
     */
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
