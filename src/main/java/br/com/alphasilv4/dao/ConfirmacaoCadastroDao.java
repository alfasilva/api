/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.dao;

import br.com.alphasilv4.AbstractDao;
import br.com.alphasilv4.entities.ConfirmacaoCadastro;
import br.com.alphasilv4.entities.Profile;
import java.io.Serializable;
import java.util.List;

/**
 * Classe responsavel por manipular os dados referente a Confirmacao do Cadastro
 * no banco.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class ConfirmacaoCadastroDao extends AbstractDao implements Serializable {

    public ConfirmacaoCadastroDao() {}

    /**
     * Insert a new Service into the database.
     *
     * @param confirmacaoCadastro
     * @return
     */
    public ConfirmacaoCadastro create(ConfirmacaoCadastro confirmacaoCadastro) {
        return (ConfirmacaoCadastro) super.create(confirmacaoCadastro, ConfirmacaoCadastro.class);
    }

    /**
     * Delete a detached ConfirmacaoCadastro from the database.
     *
     * @param confirmacaoCadastro
     */
    public void delete(ConfirmacaoCadastro confirmacaoCadastro) {
        super.delete(confirmacaoCadastro);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param id
     * @return
     */
    public ConfirmacaoCadastro find(Integer id) {
        return (ConfirmacaoCadastro) super.find(ConfirmacaoCadastro.class, id);
    }

    /**
     * Updates the state of a detached ConfirmacaoCadastro.
     *
     * @param confirmacaoCadastro
     */
    public void update(ConfirmacaoCadastro confirmacaoCadastro) {
        super.update(confirmacaoCadastro);
    }

    /**
     * Finds all Services in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(ConfirmacaoCadastro.class);
    }

    /**
     * Find an ConfirmacaoCadastro by its primary key.
     *
     * @param token
     * @return
     */
    public ConfirmacaoCadastro findByToken(String token) {
        return (ConfirmacaoCadastro) super.findByParam(ConfirmacaoCadastro.class, "Token", token);
    }

    /**
     * Find an ConfirmacaoCadastro by its profile key.
     * 
     * @param profile
     * @return
     */
    public ConfirmacaoCadastro findByProfile(Profile profile) {
        return (ConfirmacaoCadastro) super.findByParam(ConfirmacaoCadastro.class, "Profile", profile);
    }
}
