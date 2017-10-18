/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.dao;

import br.com.alphasilv4.AbstractDao;
import br.com.alphasilv4.entities.Hero;
import br.com.alphasilv4.erro.DataAccessLayerException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por manipular Heros no banco de Dados.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class HeroDao extends AbstractDao implements Serializable {

    public HeroDao() {}

    /**
     * Insert a new Hero into the database.
     *
     * @param hero
     */
    public void create(Hero hero) throws DataAccessLayerException {
        super.create(hero, Hero.class);
    }

    /**
     * Delete a detached Hero from the database.
     *
     * @param hero
     */
    public void delete(Hero hero) throws DataAccessLayerException {
        super.delete(hero);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param id
     * @return
     */
    public Hero findById(Integer id) throws DataAccessLayerException {
        return (Hero) super.findById(Hero.class, id);
    }

    /**
     * Find an Service by its name key.
     *
     * @param name
     * @return
     */
    public Hero findByName(String name) throws DataAccessLayerException {
        return (Hero) super.findByParam(Hero.class, "Name", name);
    }

    /**
     * Find all Service by its name key.
     *
     * @param name
     * @return
     */
    public List<Hero> findByNameRetList(String name) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("Name", name);
        return super.findByParamList(Hero.class, "Name", mapa);
    }

    /**
     * Updates the state of a detached Hero.
     *
     * @param hero
     */
    public void update(Hero hero) throws DataAccessLayerException {
        super.update(hero);
    }

    /**
     * Finds all Services in the database.
     *
     * @return
     */
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Hero.class);
    }

}
