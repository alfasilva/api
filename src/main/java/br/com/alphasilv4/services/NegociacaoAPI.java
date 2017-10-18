/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.services;

import br.com.alphasilv4.dao.NegociacaoDao;
import br.com.alphasilv4.entities.Negociacao;
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
 * Profile Rest responsavel por retornar informacoes para o front-end.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@Path("/negociacao")
public class NegociacaoAPI implements Serializable {

    /**
     * Retorna todos os objetos do banco.
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Negociacao> getAll() {

        System.out.println("Negociacao GET -> getALL");
        List<Negociacao> retorno = new ArrayList<Negociacao>();
        try {
            NegociacaoDao dao = new NegociacaoDao();
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
    public Negociacao getById(@PathParam("id") Integer id) {
        System.out.println("Negociacao GET -> findById:" + id);
        Negociacao retorno = new Negociacao();
        try {
            NegociacaoDao dao = new NegociacaoDao();
            retorno = dao.find(id);
        } catch (Exception e) {
            System.err.println(e);
            throw new BadRequestException();
        }
        return retorno;
    }

    /**
     * Cria objeto hero no Banco de Dados.
     *
     * @param negociacao
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Negociacao create(Negociacao negociacao) {

        System.out.println("Negociacao POST -> create");
        Negociacao retoro = negociacao;
        try {
            System.out.println("negociacao:" + negociacao.getId());
            System.out.println("Cliente:" + negociacao.getCliente().getNome());
            System.out.println("Prestador:" + negociacao.getPrestador().getNome());
            System.out.println("Servicoprestador:" + negociacao.getServicoprestador().getId());
            NegociacaoDao dao = new NegociacaoDao();
            dao.create(retoro);
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

        return retoro;
    }

    /**
     * Atualiza objeto hero no Banco de Dados.
     *
     * @param negociacao
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Negociacao negociacao) {
        System.out.println("Negociacao PUT -> update");
        try {
            NegociacaoDao dao = new NegociacaoDao();
            dao.update(negociacao);
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }
    }
}
