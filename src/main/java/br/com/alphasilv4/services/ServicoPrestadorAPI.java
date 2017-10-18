/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.services;

import br.com.alphasilv4.dao.ServicoPrestadorDao;
import br.com.alphasilv4.entities.Profile;
import br.com.alphasilv4.entities.Servico;
import br.com.alphasilv4.entities.ServicoPrestador;
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
 * ServicoPrestador Rest responsavel por retornar informacoes sobre PRESTADOR de
 * SERVICO para o front-end.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@Path("/servicoprestador")
public class ServicoPrestadorAPI implements Serializable {

    /**
     * Retorna todos os objetos do banco.
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ServicoPrestador> getAll() {
        System.out.println("ServicoPrestador GET -> getALL");
        List<ServicoPrestador> retorno = new ArrayList<ServicoPrestador>();
        try {
            ServicoPrestadorDao dao = new ServicoPrestadorDao();
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
    public ServicoPrestador getById(@PathParam("id") Integer id) {
        System.out.println("ServicoPrestador GET -> findById:" + id);
        ServicoPrestador retorno = new ServicoPrestador();
        try {
            ServicoPrestadorDao dao = new ServicoPrestadorDao();
            retorno = dao.find(id);
        } catch (Exception e) {
            System.err.println(e);
            throw new BadRequestException();
        }
        return retorno;
    }

    /**
     * Retorna objeto do banco de acordo com o ID do Servico informado.
     *
     * @param id
     * @return
     */
    @GET
    @Path("servico/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ServicoPrestador> getByIdServico(@PathParam("id") Integer id) {
        System.out.println("ServicoPrestador GET -> findByIdServico:" + id);
        List<ServicoPrestador> retorno = new ArrayList<ServicoPrestador>();
        try {
            ServicoPrestadorDao dao = new ServicoPrestadorDao();
            retorno = dao.findByServico(new Servico(id));            
        } catch (Exception e) {
            System.err.println(e);
            throw new BadRequestException();
        }
        return retorno;
    }

    /**
     * Retorna objeto do banco de acordo com o ID do Prestador informado.
     *
     * @param id
     * @return
     */
    @GET
    @Path("prestador/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ServicoPrestador> getByIdPrestador(@PathParam("id") Integer id) {
        System.out.println("ServicoPrestador GET -> findByIdPrestador:" + id);
        List<ServicoPrestador> retorno = new ArrayList<ServicoPrestador>();
        try {
            ServicoPrestadorDao dao = new ServicoPrestadorDao();
            retorno = dao.findByProfile(new Profile(id));            
        } catch (Exception e) {
            System.err.println(e);
            throw new BadRequestException();
        }
        return retorno;
    }
}
