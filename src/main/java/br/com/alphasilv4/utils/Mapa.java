/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.utils;

import br.com.alphasilv4.dao.CategoriaDao;
import br.com.alphasilv4.dao.ProfileDao;
import br.com.alphasilv4.dao.ServicoDao;
import br.com.alphasilv4.entities.Categoria;
import br.com.alphasilv4.entities.Profile;
import br.com.alphasilv4.entities.Servico;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe Utilitaria responsavel por prover informações para o auto-complete.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class Mapa implements Serializable {

    private static List<Servico> servicos = null;
    private static List<Profile> profiles = null;
    private static List<Categoria> categorias = null;

    /**
     * Metodo Utilizado para retornar a descricao dos Servicos;
     *
     * @return
     */
    public static Map<Integer, Servico> servicos() {
        Map<Integer, Servico> mapa = new HashMap<Integer, Servico>();
        for (Servico s : buscarServicos()) {
            mapa.put(s.getId().intValue(), s);
        }
        return mapa;
    }

    /**
     * Metodo utilizadado para tentar trasforma a paralavra digitada em um
     * objeto do tipo servico.
     *
     * @param nome
     * @return
     */
    public static Servico findServico(String nome) {
        for (Servico s : servicos) {
            if (s.getNome().equalsIgnoreCase(nome)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Metodo utilizadado para tentar trasforma a paralavra digitada em um
     * objeto do tipo Profile.
     *
     * @param nome
     * @return
     */
    public static Profile findProfile(String nome) {
        for (Profile s : profiles) {
            if (s.getNome().equalsIgnoreCase(nome)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Metodo utilizadado para tentar trasforma a paralavra digitada em um
     * objeto do tipo Categoria.
     *
     * @param nome
     * @return
     */
    public static Categoria findCategoria(String nome) {
        for (Categoria s : categorias) {
            if (s.getNome().equalsIgnoreCase(nome)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Metodo Utilizado para retornar a descricao dos Profiles;
     *
     * @return
     */
    public static Map<Integer, Profile> profiles() {
        Map<Integer, Profile> mapa = new HashMap<Integer, Profile>();
        for (Profile p : buscarProfiles()) {
            mapa.put(p.getId().intValue(), p);
        }
        return mapa;
    }

    /**
     * Metodo Utilizado para retornar a descricao das Categorias;
     *
     * @return
     */
    public static Map<Integer, Categoria> categorias() {
        Map<Integer, Categoria> mapa = new HashMap<Integer, Categoria>();
        for (Categoria p : buscarCategorias()) {
            mapa.put(p.getId(), p);
        }
        return mapa;
    }

    protected static List<Servico> buscarServicos() {
        try {
            if (servicos == null) {                
                ServicoDao dao = new ServicoDao();
                servicos = dao.findActiveService();
            }
            return servicos;
        } catch (Exception e) {
            System.err.println("Erro ao carregar lista de Servicos."+e);
        }
        return null;
    }

    protected static List<Profile> buscarProfiles() {
        try {
            if (profiles == null) {
                ProfileDao dao = new ProfileDao();
                profiles = dao.findPrestadoresAtivos();
            }
            return profiles;
        } catch (Exception e) {
            System.err.println("Erro ao carregar lista de Profiles.");
        }
        return null;
    }

    protected static List<Categoria> buscarCategorias() {
        try {
            if (categorias == null) {
                CategoriaDao dao = new CategoriaDao();
                categorias = dao.findAll();
            }
            return categorias;
        } catch (Exception e) {
            System.err.println("Erro ao carregar lista de Profiles.");
        }
        return null;
    }
}
