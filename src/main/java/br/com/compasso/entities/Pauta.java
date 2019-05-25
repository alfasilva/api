/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compasso.entities;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entidade Java utilizada para mapear os atributos da tabela no Banco de dados.
 * 
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@Entity
@Table(name = "pauta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pauta.findAll", query = "SELECT h FROM Pauta h"),
    @NamedQuery(name = "Pauta.findById", query = "SELECT h FROM Pauta h WHERE h.id = :id"),
    @NamedQuery(name = "Pauta.findByName", query = "SELECT h FROM Pauta h WHERE h.name = :name")
    })
public class Pauta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)    
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "sessaoDeAbertura")
    private Time sessaoDeAbertura;

  
    public Pauta() {
    }

    public Pauta(Integer id) {
        this.id = id;
    }

    public Pauta(Integer id, String name, String profilePic) {
        this.id = id;
        this.name = name;  
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
       
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pauta)) {
            return false;
        }
        Pauta other = (Pauta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.alphasilv4.entities.Pauta[ id=" + id + " ]";
    }

    public Time getSessaoDeAbertura() {
        return sessaoDeAbertura;
    }

    public void setSessaoDeAbertura(Time sessaoDeAbertura) {
        this.sessaoDeAbertura = sessaoDeAbertura;
    }

}
