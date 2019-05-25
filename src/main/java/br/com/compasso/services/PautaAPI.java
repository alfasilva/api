/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compasso.services;

import br.com.compasso.dao.PautaDao;
import br.com.compasso.dao.VotacaoDao;
import br.com.compasso.entities.Pauta;
import br.com.compasso.entities.Votacao;
import br.com.compasso.vo.RetornoPauta;
import java.io.Serializable;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Servico Rest responsavel por retornar informacoes para o front-end.
 *
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@Path("/pauta")
public class PautaAPI implements Serializable {
    
    /**
     * Cria objeto pauta no Banco de Dados.
     *
     * @param pauta
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pauta create(Pauta pauta) {

        System.out.println("pauta POST -> create");
        Pauta retoro = pauta;
        try {
            PautaDao dao = new PautaDao();
            dao.create(pauta);
        } catch (Exception e) {
            System.out.println("Error:" + e);
            throw new BadRequestException();
        }

        return retoro;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RetornoPauta getByPauta(Pauta pauta) {

        RetornoPauta retorno = new RetornoPauta();

        try {
            int qtdSim = 0;
            int qtdNao = 0;            
            VotacaoDao dao = new VotacaoDao();                                
            // Busca todas as votações daquela pauta
            List<Votacao> votacoes = dao.findByPauta(pauta);                        
            for (Votacao v : votacoes) {
                if("S".contains(v.getVoto())){
                    qtdSim++;
                }
                if("N".contains(v.getVoto())){
                    qtdNao++;
                }
            }
            retorno.setPauta(pauta);
            retorno.setQtdSim(qtdSim);
            retorno.setQtdNao(qtdNao);

        } catch (Exception e) {
            throw new BadRequestException();
        }

        return retorno;
    }

}
