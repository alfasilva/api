/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.dao;

import br.com.alphasilv4.AbstractDao;
import br.com.alphasilv4.entities.Categoria;
import br.com.alphasilv4.entities.CategoriaPrestador;
import br.com.alphasilv4.entities.Profile;
import java.io.Serializable;
import java.util.List;

/**
 * Classe responsavel por manipular os dados referente a Categoria do Prestador
 * no banco.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class CategoriaPrestadorDao extends AbstractDao implements Serializable {

    public CategoriaPrestadorDao() {}

    /**
     * Insert a new Service into the database.
     *
     * @param categoriaPrestador
     * @return
     */
    public CategoriaPrestador create(CategoriaPrestador categoriaPrestador) {
        return (CategoriaPrestador) super.create(categoriaPrestador, CategoriaPrestador.class);
    }

    /**
     * Delete a detached CategoriaPrestador from the database.
     *
     * @param categoriaPrestador
     */
    public void delete(CategoriaPrestador categoriaPrestador) {
        super.delete(categoriaPrestador);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param id
     * @return
     */
    public CategoriaPrestador find(Integer id) {
        return (CategoriaPrestador) super.find(CategoriaPrestador.class, id);
    }

    /**
     * Updates the state of a detached CategoriaPrestador.
     *
     * @param categoriaPrestador
     */
    public void update(CategoriaPrestador categoriaPrestador) {
        super.update(categoriaPrestador);
    }

    /**
     * Finds all Services in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CategoriaPrestador.class);
    }

    /**
     * Find an Categoria do Prestador by its profile.
     *
     * @param profile
     * @return
     */
    public CategoriaPrestador findByProfile(Profile profile) {
        return (CategoriaPrestador) super.findByParam(CategoriaPrestador.class, "Profile", profile);
    }

    /**
     * Find an Categoria do Prestador by its categoria.
     *
     * @param categoria
     * @return
     */
    public CategoriaPrestador findByCategoria(Categoria categoria) {
        return (CategoriaPrestador) super.findByParam(CategoriaPrestador.class, "Categoria", categoria);
    }
}
