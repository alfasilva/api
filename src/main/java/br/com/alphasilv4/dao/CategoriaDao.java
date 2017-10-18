/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.dao;

import br.com.alphasilv4.AbstractDao;
import br.com.alphasilv4.entities.Categoria;
import java.io.Serializable;
import java.util.List;

/**
 * Classe responsavel por manipular os dados referente a Categoria no banco.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class CategoriaDao extends AbstractDao implements Serializable {

    public CategoriaDao() {
    }

    /**
     * Insert a new Service into the database.
     *
     * @param categoria
     * @return
     */
    public Categoria create(Categoria categoria) {
        return (Categoria) super.create(categoria, Categoria.class);
    }

    /**
     * Delete a detached Categoria from the database.
     *
     * @param categoria
     */
    public void delete(Categoria categoria) {
        super.delete(categoria);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param id
     * @return
     */
    public Categoria find(Integer id) {
        return (Categoria) super.find(Categoria.class, id);
    }

    /**
     * Updates the state of a detached Categoria.
     *
     * @param categoria
     */
    public void update(Categoria categoria) {
        super.update(categoria);
    }

    /**
     * Finds all Services in the database.
     *
     * @return
     */
    public List<Categoria> findAll() {
        return super.findAll(Categoria.class);
    }
}
