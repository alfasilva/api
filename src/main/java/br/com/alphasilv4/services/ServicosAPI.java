/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.services;

import br.com.alphasilv4.dao.ServicoDao;
import br.com.alphasilv4.entities.Categoria;
import br.com.alphasilv4.entities.Servico;
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
@Path("/servico")
public class ServicosAPI implements Serializable {

    /**
     * Retorna todos os objetos do banco.
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Servico> getAll() {
        System.out.println("Servicos GET -> getALL");
        List<Servico> retorno = new ArrayList<Servico>();
        try {
            ServicoDao dao = new ServicoDao();
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
    public Servico getById(@PathParam("id") Integer id) {
        System.out.println("Servicos GET -> findById:" + id);
        Servico retorno = new Servico();
        try {
            ServicoDao dao = new ServicoDao();
            retorno = dao.find(id);
        } catch (Exception e) {
            System.err.println(e);
            throw new BadRequestException();
        }
        return retorno;
    }

    /**
     * Retorna objeto do banco de acordo com o ID da Categoria informada.
     *
     * @param id
     * @return
     */
    @GET
    @Path("categoria/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Servico> getByIdCategoria(@PathParam("id") Integer id) {

        System.out.println("Servicos GET -> ByIdCategoria:" + id);
        List<Servico> retorno = new ArrayList<Servico>();
        try {
            ServicoDao dao = new ServicoDao();
            retorno = dao.findByCategoria(new Categoria(id));
        } catch (Exception e) {
            System.err.println(e);
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
    public List<Servico> getByName(@PathParam("name") String name) {
        System.out.println("servicos GET -> findByName:" + name);
        List<Servico> retorno = new ArrayList<Servico>();
        try {
            ServicoDao dao = new ServicoDao();
            retorno.add(dao.findByNome(name));
        } catch (Exception e) {
            System.err.println(e);
            throw new BadRequestException();
        }
        return retorno;
    }

    /**
     * Atualiza objeto servico no Banco de Dados.
     *
     * @param servico
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Servico servico) {
        System.out.println("servicoes PUT -> update");
        try {
            System.out.println("Mock Nome:" + servico.getNome());
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }
    }

    /**
     * Cria objeto servico no Banco de Dados.
     *
     * @param servico
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Servico create(Servico servico) {

        System.out.println("Serviços POST -> create");
        try {
            System.out.println("Mock Nome:" + servico.getNome());
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

        return servico;
    }

    /**
     * Remove objeto servico do Banco de Dados.
     *
     * @param id
     */
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        try {
            System.out.println("Servico DELETE -> delete");
            System.out.println("ID: " + id);
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }
    }
}
