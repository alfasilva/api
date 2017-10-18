/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.dao;

import br.com.alphasilv4.AbstractDao;
import br.com.alphasilv4.entities.Profile;
import br.com.alphasilv4.entities.Servico;
import br.com.alphasilv4.entities.ServicoPrestador;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por manipular os dados referente a Categoria do Prestador
 * no banco.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class ServicoPrestadorDao extends AbstractDao implements Serializable {

    public ServicoPrestadorDao() {}

    /**
     * Insert a new Service into the database.
     *
     * @param servicoPrestador
     * @return
     */
    public ServicoPrestador create(ServicoPrestador servicoPrestador) {
        return (ServicoPrestador) super.create(servicoPrestador, ServicoPrestador.class);
    }

    /**
     * Delete a detached ServicoPrestador from the database.
     *
     * @param servicoPrestador
     */
    public void delete(ServicoPrestador servicoPrestador) {
        super.delete(servicoPrestador);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param id
     * @return
     */
    public ServicoPrestador find(Integer id) {
        return (ServicoPrestador) super.find(ServicoPrestador.class, id);
    }

    /**
     * Updates the state of a detached ServicoPrestador.
     *
     * @param servicoPrestador
     */
    public void update(ServicoPrestador servicoPrestador) {
        super.update(servicoPrestador);
    }

    /**
     * Finds all Services in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(ServicoPrestador.class);
    }

    public ServicoPrestador findById(Integer id) {
        return (ServicoPrestador) super.findById(ServicoPrestador.class, id);
    }

    public List<ServicoPrestador> findByProfile(Profile prestador) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("Prestador", prestador);
        return super.findByParamList(ServicoPrestador.class, "Prestador", mapa);
    }

    public List<ServicoPrestador> findByServico(Servico servico) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("Servico", servico);
        return super.findByParamList(ServicoPrestador.class, "Servico", mapa);
    }

    /**
     * Localiza o Servico do Prestador pelo Servico e Prestador
     *
     * @param servico
     * @param prestador
     * @return
     */
    public ServicoPrestador findByServicoPrestador(Servico servico, Profile prestador) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("Servico", servico);
        mapa.put("Prestador", prestador);        
        List<ServicoPrestador> retorno = super.findByParamList(ServicoPrestador.class, "ServicoAndPrestador", mapa);
        return retorno.isEmpty() ? null : retorno.get(0);               
    }
}
