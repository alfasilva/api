/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compasso.vo;

import br.com.compasso.entities.Pauta;
import java.io.Serializable;
import java.sql.Time;

/**
 * VO
 *
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class RetornoPauta implements Serializable {
    
    //'S' ou 'N' para Sim' ou 'Não'
    private Integer qtdSim;    
    private Integer qtdNao;    
    private Pauta pauta;
        
    public RetornoPauta() {}

    public Integer getQtdSim() {
        return qtdSim;
    }

    public void setQtdSim(Integer qtdSim) {
        this.qtdSim = qtdSim;
    }

    public Integer getQtdNao() {
        return qtdNao;
    }

    public void setQtdNao(Integer qtdNao) {
        this.qtdNao = qtdNao;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    
}
