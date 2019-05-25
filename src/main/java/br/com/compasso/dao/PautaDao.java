/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compasso.dao;

import br.com.compasso.config.AbstractDao;
import br.com.compasso.entities.Pauta;
import java.io.Serializable;
import java.util.List;

/**
 * Classe responsavel por manipular Pautas no banco de Dados.
 *
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class PautaDao extends AbstractDao implements Serializable {

    public PautaDao() {}

    /**
     * Insert a new Pauta into the database.
     *
     * @param pauta
     */
    public void create(Pauta pauta)  {
        super.create(pauta, Pauta.class);
    }
    
    /**
     * Finds all Services in the database.
     *
     * @return
     */
    public List findAll()  {
        return super.findAll(Pauta.class);
    }

}
