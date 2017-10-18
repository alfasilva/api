/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.dao;

import br.com.alphasilv4.AbstractDao;
import br.com.alphasilv4.entities.Categoria;
import br.com.alphasilv4.entities.Servico;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por manipular os dados referente a Servico no banco.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class ServicoDao extends AbstractDao implements Serializable {

     /**
     * Insert a new Service into the database.
     *
     * @param servico
     * @return
     */
    public Servico create(Servico servico) {        
        
        return (Servico) super.create(servico, Servico.class);
    }

    /**
     * Delete a detached Servico from the database.
     *
     * @param servico
     */
    public void delete(Servico servico) {
        
        super.delete(servico);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param id
     * @return
     */
    public Servico find(Integer id) {
        
        return (Servico) super.find(Servico.class, id);
    }

    /**
     * Updates the state of a detached Servico.
     *
     * @param servico
     */
    public void update(Servico servico) {
        
        super.update(servico);
    }

    /**
     * Finds all Services in the database.
     *
     * @return
     */
    public List findAll() {
        
        return super.findAll(Servico.class);
    }

    /**
     * Retorna a lista de servicos do prestador , baseado na categoria possada.
     *
     * @param categoria
     * @return
     */
    public List<Servico> findByCategoria(Categoria categoria) {
        
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("Categoria", categoria);
        return super.findByParamList(Servico.class, "Categoria", mapa);
    }

    public List<Servico> findActiveService() {
        
        return super.findByNamedQuery(Servico.class, "findTodosOsAtivo");
    }

    /**
     * Find an Profile by its name.
     *
     * @param nome
     * @return
     */
    public Servico findByNome(String nome) {
        
        List<Servico> ret = super.findAllByString(Servico.class, "Nome", nome);
        return ret != null ? ret.get(0) : null;
    }
}
