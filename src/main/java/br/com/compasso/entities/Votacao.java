/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compasso.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entidade que represendo o Objeto VOTACAO na base de dados.
 *
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@Entity
@Table(name = "VOTACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Votacao.findAll", query = "SELECT p FROM Votacao p order by p.id DESC"),
    @NamedQuery(name = "Votacao.findById", query = "SELECT p FROM Votacao p WHERE p.id = :id"),
    @NamedQuery(name = "Votacao.findByNome", query = "SELECT p FROM Votacao p WHERE p.nome = :nome"),
    @NamedQuery(name = "Votacao.findByPauta", query = "SELECT p FROM Votacao p WHERE p.pauta = :pauta")
})
public class Votacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;     
    //'S' ou 'N' para Sim' ou 'Não'
    private String voto;
    @Basic(optional = false)
    @Column(name = "PAUTA")
    private Pauta pauta;
    @Basic(optional = false)
    @Column(name = "ASSOCIADO")
    private Associado associado;
    
    public Votacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
      
}
