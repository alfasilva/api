/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.dao;

import br.com.alphasilv4.AbstractDao;
import br.com.alphasilv4.entities.ServicoPrestador;
import br.com.alphasilv4.entities.ServicoQualificacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por manipular os dados referente a ServicoQualificacao no
 * banco.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class ServicoQualificacaoDao extends AbstractDao implements Serializable {

    public ServicoQualificacaoDao() {}

    /**
     * Insert a new Service into the database.
     *
     * @param servicoQualificacao
     * @return
     */
    public ServicoQualificacao create(ServicoQualificacao servicoQualificacao) {
        return (ServicoQualificacao) super.create(servicoQualificacao, ServicoQualificacao.class);
    }

    /**
     * Delete a detached ServicoQualificacao from the database.
     *
     * @param servicoQualificacao
     */
    public void delete(ServicoQualificacao servicoQualificacao) {
        super.delete(servicoQualificacao);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param id
     * @return
     */
    public ServicoQualificacao find(Integer id) {
        return (ServicoQualificacao) super.find(ServicoQualificacao.class, id);
    }

    /**
     * Updates the state of a detached ServicoQualificacao.
     *
     * @param servicoQualificacao
     */
    public void update(ServicoQualificacao servicoQualificacao) {
        super.update(servicoQualificacao);
    }

    /**
     * Finds all ServicoQualificacao in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(ServicoQualificacao.class);
    }

    /**
     * Find all good qualification services.
     *
     * @return
     */
    public ServicoQualificacao findByBom() {
        return (ServicoQualificacao) super.findByParam(ServicoQualificacao.class, "Bom", true);
    }

    /**
     * Find all bad qualification services.
     *
     * @return
     */
    public ServicoQualificacao findRuim() {
        return (ServicoQualificacao) super.findByParam(ServicoQualificacao.class, "Bom", false);
    }

    public List<ServicoQualificacao> findAllByServicoPrestador(ServicoPrestador servicoPrestador) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("ServicoPrestador", servicoPrestador);
        List retorno = super.findByParamList(ServicoQualificacao.class, "ServicoPrestador", mapa);
        if(retorno!=null){
            return retorno;
        } 
        return new ArrayList<ServicoQualificacao>();
    }
}
