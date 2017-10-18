/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.vo;

import br.com.alphasilv4.entities.Profile;
import java.io.Serializable;
import java.util.List;

/**
 * VO
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class ChatVo implements Serializable  {
    
    private Profile cliente;
    private Profile prestador;
    private List<MensagemVo> mensagens;

    public ChatVo() {}      

    public ChatVo(Profile cliente, Profile prestador, List<MensagemVo> mensagens) {
        this.cliente = cliente;
        this.prestador = prestador;
        this.mensagens = mensagens;
    }
        
    public Profile getCliente() {
        return cliente;
    }

    public void setCliente(Profile cliente) {
        this.cliente = cliente;
    }

    public Profile getPrestador() {
        return prestador;
    }

    public void setPrestador(Profile prestador) {
        this.prestador = prestador;
    }

    public List<MensagemVo> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<MensagemVo> mensagens) {
        this.mensagens = mensagens;
    }        
}
