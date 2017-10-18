/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.services;

import br.com.alphasilv4.dao.CategoriaDao;
import br.com.alphasilv4.entities.Categoria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Categoria Rest responsavel por retornar informacoes para o front-end.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@Path("/categoria")
public class CategoriaAPI implements Serializable {

    /**
     * Retorna todos os objetos do banco.
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> getAll() {
        System.out.println("Categoria GET -> getALL");
        List<Categoria> retorno = new ArrayList<Categoria>();
        try {
            CategoriaDao dao = new CategoriaDao();
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
    public Categoria getById(@PathParam("id") Integer id) {
        System.out.println("Categoria GET -> findById:" + id);
        Categoria retorno = new Categoria();
        try {
            CategoriaDao dao = new CategoriaDao();
            retorno = dao.find(id);
        } catch (Exception e) {
            System.err.println(e);
            throw new BadRequestException();
        }
        return retorno;
    }
}
