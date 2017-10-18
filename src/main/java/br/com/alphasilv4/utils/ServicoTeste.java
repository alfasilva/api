/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.utils;

import br.com.alphasilv4.dao.NegociacaoDao;
import br.com.alphasilv4.dao.ProfileDao;
import br.com.alphasilv4.dao.ServicoDao;
import br.com.alphasilv4.dao.ServicoPrestadorDao;
import br.com.alphasilv4.dao.ServicoQualificacaoDao;
import br.com.alphasilv4.entities.Categoria;
import br.com.alphasilv4.entities.Profile;
import br.com.alphasilv4.entities.Servico;
import br.com.alphasilv4.entities.ServicoPrestador;
import br.com.alphasilv4.entities.ServicoQualificacao;
import br.com.alphasilv4.utils.Mapa;
import br.com.alphasilv4.vo.RetornoPesquisa;
import br.com.alphasilv4.vo.RetornoServico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * TESTE
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class ServicoTeste implements Serializable {

    private List<RetornoPesquisa> resultado;
    private List<RetornoServico> retorno;

    protected List<RetornoServico> carregarServicos(Profile u, Servico srv) {

        List<RetornoServico> lista = new ArrayList<RetornoServico>();
        ServicoQualificacaoDao qualificacaoDao = new ServicoQualificacaoDao();
        ServicoPrestadorDao servPresDao = new ServicoPrestadorDao();
        for (ServicoPrestador s : servPresDao.findByServico(srv)) {
            Integer bom = 0;
            Integer ruim = 0;
            for (ServicoQualificacao sv : qualificacaoDao.findAllByServicoPrestador(s)) {
                if (sv.getBom()) {
                    bom++;
                } else {
                    ruim++;
                }
            }
            RetornoServico resposta = new RetornoServico(s);
            resposta.setBom(bom);
            resposta.setRuim(ruim);
            lista.add(resposta);
        }

        return lista;
    }

    /**
     * Carrefa Lista de Servicos de um determinado prestador
     *
     * @param p
     * @return
     */
    protected List<RetornoServico> carregarServicos(Profile p) {

        List<RetornoServico> lista = new ArrayList<RetornoServico>();
        ServicoQualificacaoDao qualificacaoDao = new ServicoQualificacaoDao();
        ServicoPrestadorDao servPresDao = new ServicoPrestadorDao();
        for (ServicoPrestador s : servPresDao.findByProfile(p)) {
            Integer bom = 0;
            Integer ruim = 0;
            for (ServicoQualificacao sv : qualificacaoDao.findAllByServicoPrestador(s)) {
                if (sv.getBom()) {
                    bom++;
                } else {
                    ruim++;
                }
            }
            RetornoServico resposta = new RetornoServico(s);
            resposta.setBom(bom);
            resposta.setRuim(ruim);
            lista.add(resposta);
        }
        return lista;
    }

    /**
     * Metodo buscar as informacoes na base de dados.
     *
     * @param palavra
     */
    public void buscar(String palavra) {
        try {
            if (StringUtils.isNotBlank(palavra)) {
                Servico srvObj = Mapa.findServico(palavra);
                Categoria catObj = Mapa.findCategoria(palavra);
                resultado = new ArrayList<RetornoPesquisa>();

                if (srvObj != null && srvObj.getAtivo()) {

                    ServicoQualificacaoDao qualificacaoDao = new ServicoQualificacaoDao();
                    ServicoPrestadorDao servPresDao = new ServicoPrestadorDao();
                    for (ServicoPrestador s : servPresDao.findByServico(srvObj)) {
                        Integer bom = 0;
                        Integer ruim = 0;
                        for (ServicoQualificacao sv : qualificacaoDao.findAllByServicoPrestador(s)) {
                            if (sv.getBom()) {
                                bom++;
                            } else {
                                ruim++;
                            }
                        }
                        RetornoPesquisa resposta = new RetornoPesquisa(s);
                        resposta.setBom(bom);
                        resposta.setRuim(ruim);
                        NegociacaoDao negDao = new NegociacaoDao();
                        resposta.setNegociacao(negDao.findByServicoPrestador(s));
                        resultado.add(resposta);
                    }
                } else if (catObj != null) {
                    ServicoQualificacaoDao qualificacaoDao = new ServicoQualificacaoDao();
                    ServicoPrestadorDao servPresDao = new ServicoPrestadorDao();
                    ServicoDao srvDao = new ServicoDao();
                    for (Servico s : srvDao.findByCategoria(catObj)) {
                        for (ServicoPrestador sp : servPresDao.findByServico(s)) {
                            Integer bom = 0;
                            Integer ruim = 0;
                            for (ServicoQualificacao sv : qualificacaoDao.findAllByServicoPrestador(sp)) {
                                if (sv.getBom()) {
                                    bom++;
                                } else {
                                    ruim++;
                                }
                            }
                            RetornoPesquisa resposta = new RetornoPesquisa(sp);
                            resposta.setBom(bom);
                            resposta.setRuim(ruim);
                            NegociacaoDao negDao = new NegociacaoDao();
                            resposta.setNegociacao(negDao.findByServicoPrestador(sp));
                            resultado.add(resposta);
                        }
                    }
                }

                if (resultado == null || resultado.isEmpty()) {
                    ServicoQualificacaoDao qualificacaoDao = new ServicoQualificacaoDao();
                    ServicoPrestadorDao servPresDao = new ServicoPrestadorDao();
                    ServicoPrestador s = servPresDao.findById(7);
                    Integer bom = 0;
                    Integer ruim = 0;
                    for (ServicoQualificacao sv : qualificacaoDao.findAllByServicoPrestador(s)) {
                        if (sv.getBom()) {
                            bom++;
                        } else {
                            ruim++;
                        }
                    }
                    RetornoPesquisa resposta = new RetornoPesquisa(s);
                    resposta.setBom(bom);
                    resposta.setRuim(ruim);
                    NegociacaoDao negDao = new NegociacaoDao();
                    resposta.setNegociacao(negDao.findByServicoPrestador(s));
                    resultado.add(resposta);
                }
            }
        } catch (Exception e) {
            System.err.println("ERRO Pesquisa: " + e);
        }

    }

    /**
     *
     * @param id
     * @param business
     * @param voto
     */
    public void carregarByUidAndBusiness(String id, String business, String voto) {
        System.out.println("Invocando PostConstruct do Servico");
        try {
            if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(business)) {
                Long uid = Long.parseLong(id);
                Long bs = uid = Long.parseLong(business);
                ProfileDao proDao = new ProfileDao();
                ServicoPrestadorDao srvPresDao = new ServicoPrestadorDao();
                Profile prestador = proDao.find(uid.intValue());
                ServicoPrestador preServico = srvPresDao.find(bs.intValue());
                if (prestador != null && preServico != null && StringUtils.isNotBlank(voto)) {
                    ServicoQualificacaoDao sqDao = new ServicoQualificacaoDao();
                    sqDao.create(new ServicoQualificacao(Boolean.parseBoolean(voto), "descricao", new Date(), new Profile(), prestador, preServico));
                    List<RetornoServico> lista = new ArrayList<RetornoServico>();
                    Integer bom = 0;
                    Integer ruim = 0;
                    for (ServicoQualificacao sv : sqDao.findAllByServicoPrestador(preServico)) {
                        if (sv.getBom()) {
                            bom++;
                        } else {
                            ruim++;
                        }
                    }
                    RetornoServico resposta = new RetornoServico(preServico);
                    resposta.setBom(bom);
                    resposta.setRuim(ruim);
                    lista.add(resposta);
                    retorno = lista;
                } else {
                    retorno = carregarServicos(prestador);
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao carregar servico " + e);
        }
    }

    public List<String> buscaPrincipal(String texto) {
        List<String> a = new ArrayList<String>();
        if (StringUtils.isNotBlank(texto)) {
            Map<Integer, Servico> servicos = Mapa.servicos();
            Map<Integer, Categoria> categorias = Mapa.categorias();
            if (texto.length() > 2) {
                for (Map.Entry<Integer, Servico> entry : servicos.entrySet()) {
                    if (entry.getValue().getNome().toLowerCase().contains(texto.toLowerCase())) {
                        a.add(entry.getValue().getNome());
                    }
                }
                for (Map.Entry<Integer, Categoria> entry : categorias.entrySet()) {
                    if (entry.getValue().getNome().toLowerCase().contains(texto.toLowerCase())) {
                        a.add(entry.getValue().getNome());
                    }
                }
            } else {
                for (Map.Entry<Integer, Servico> entry : servicos.entrySet()) {
                    if (entry.getValue().getNome().toLowerCase().startsWith(texto.toLowerCase())) {
                        a.add(entry.getValue().getNome());
                    }
                }
                for (Map.Entry<Integer, Categoria> entry : categorias.entrySet()) {
                    if (entry.getValue().getNome().toLowerCase().startsWith(texto.toLowerCase())) {
                        a.add(entry.getValue().getNome());
                    }
                }
            }
        }
        return a;
    }
}
