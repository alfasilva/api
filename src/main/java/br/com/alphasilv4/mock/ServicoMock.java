/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.mock;

import java.io.Serializable;

/**
 * Objeto utilizado para agrupar as informacoes referentes as Serviços prestados.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class ServicoMock implements Serializable {
        
    private Integer id;
    private String name;
    private String icon;
    private String about;
    private Integer categorie;

    public ServicoMock() {
    }

    public ServicoMock(Integer id, String name, String icon, String about, Integer categorie) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.about = about;
        this.categorie = categorie;
    }
            
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getCategorie() {
        return categorie;
    }

    public void setCategorie(Integer categorie) {
        this.categorie = categorie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
