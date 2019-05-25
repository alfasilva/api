/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compasso.services;

import br.com.compasso.dao.VotacaoDao;
import br.com.compasso.entities.Pauta;
import br.com.compasso.entities.Votacao;
import java.io.Serializable;
import java.sql.Time;
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
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@Path("/votacao")
public class VotacaoAPI implements Serializable {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Votacao create(Votacao votacao) {

        try {
            if (votacao.getAssociado() != null && votacao.getAssociado() != null) {
                VotacaoDao dao = new VotacaoDao();
                // Busca todas as votações daquela pauta
                List<Votacao> votacoes = dao.findByPauta(votacao.getPauta());
                int count = 0;
                for (Votacao v : votacoes) {
                    //Valida se já foi votato pelo associado
                    if (v.getAssociado().getId() == votacao.getAssociado().getId()) {
                        count++;
                    }
                }
                Time t = new Time(0, 1, 0);
                //Garante que ainda não houve votação pelo associado
                if (count == 0) {
                    /**
                     * Abrir uma sessão de votação em uma pauta (a sessão de
                     * votação deve ficar aberta por um tempo determinado na
                     * chamada de abertura ou 1 minuto por default)
                     */
                    if (votacao.getPauta().getSessaoDeAbertura().before(t)) {
                        dao.create(votacao);
                    }
                }
            }

        } catch (Exception e) {
            throw new BadRequestException();
        }

        return votacao;
    }

}
