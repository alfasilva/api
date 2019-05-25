/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compasso.dao;

import br.com.compasso.config.AbstractDao;
import br.com.compasso.entities.Associado;
import java.io.Serializable;
import java.util.List;

/**
 * Classe responsavel por manipular os dados referente a Associado no banco.
 *
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class AssociadoDao extends AbstractDao implements Serializable {

    public AssociadoDao() {}

    /**
     * Insert a new Service into the database.
     *
     * @param associado
     * @return
     */
    public Associado create(Associado associado) {
        return (Associado) super.create(associado, Associado.class);
    }

    /**
     * Delete a detached Associado from the database.
     *
     * @param associado
     */
    public void delete(Associado associado) {
        super.delete(associado);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param id
     * @return
     */
    public Associado find(Integer id) {
        return (Associado) super.find(Associado.class, id);
    }

    /**
     * Updates the state of a detached Associado.
     *
     * @param associado
     */
    public void update(Associado associado) {
        super.update(associado);
    }

    /**
     * Finds all Associado in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(Associado.class);
    }
}
