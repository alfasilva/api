/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entidade Java utilizada para mapear os atributos da tabela no Banco de dados.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@Entity
@Table(name = "hero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hero.findAll", query = "SELECT h FROM Hero h"),
    @NamedQuery(name = "Hero.findById", query = "SELECT h FROM Hero h WHERE h.id = :id"),
    @NamedQuery(name = "Hero.findByName", query = "SELECT h FROM Hero h WHERE h.name = :name"),
    @NamedQuery(name = "Hero.findByProfilePic", query = "SELECT h FROM Hero h WHERE h.profilePic = :profilePic"),
    @NamedQuery(name = "Hero.findByAbout", query = "SELECT h FROM Hero h WHERE h.about = :about")})
public class Hero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)    
    @Size(min = 1, max = 35)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)    
    @Size(min = 1, max = 100)
    @Column(name = "profilePic")
    private String profilePic;
    @Size(max = 200)
    @Column(name = "about")
    private String about;

    public Hero() {
    }

    public Hero(Integer id) {
        this.id = id;
    }

    public Hero(Integer id, String name, String profilePic) {
        this.id = id;
        this.name = name;
        this.profilePic = profilePic;
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

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
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
        if (!(object instanceof Hero)) {
            return false;
        }
        Hero other = (Hero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.alphasilv4.entities.Hero[ id=" + id + " ]";
    }

}
