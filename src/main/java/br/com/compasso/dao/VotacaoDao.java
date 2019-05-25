/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compasso.dao;

import br.com.compasso.config.AbstractDao;
import br.com.compasso.entities.Associado;
import br.com.compasso.entities.Pauta;
import br.com.compasso.entities.Votacao;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por manipular os dados referente a Votacao no banco.
 *
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class VotacaoDao extends AbstractDao implements Serializable {

    /**
     * Insert a new Service into the database.
     *
     * @param votacao
     * @return
     */
    public Votacao create(Votacao votacao) {
        return (Votacao) super.create(votacao, Votacao.class);
    }

    /**
     * Delete a detached Votacao from the database.
     *
     * @param votacao
     */
    public void delete(Votacao votacao) {
        super.delete(votacao);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param id
     * @return
     */
    public Votacao find(Integer id) {
        return (Votacao) super.find(Votacao.class, id);
    }
    
    public List<Votacao> findByPauta(Pauta pauta) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("Pauta", pauta);
        return super.findByParamList(Pauta.class, "Pauta", mapa);
    }
    
    /**
     * Localiza a votação de um associado caso exista
     */
    public List<Votacao> findByVotacao(Votacao votacao) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("Associado", votacao.getAssociado());
        mapa.put("Pauta", votacao.getPauta());
        return super.findByParamList(Associado.class, "Associado", mapa);
    }
    
    /**
     * Updates the state of a detached Votacao.
     *
     * @param votacao
     */
    public void update(Votacao votacao) {
        super.update(votacao);
    }

    /**
     * Finds all Services in the database.
     *
     * @return
     */
    public List<Votacao> findAll() {
        return super.findAll(Votacao.class);
    }
    
}
