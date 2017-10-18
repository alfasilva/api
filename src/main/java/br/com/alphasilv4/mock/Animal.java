/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.mock;

import java.io.Serializable;

/**
 * Objeto utilizado para agrupar as informacoes referentes ao Animal.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class Animal implements Serializable {

    private String name;
    private String profilePic;
    private String about;

    public Animal() {
    }

    public Animal(String name, String profilePic, String about) {
        this.name = name;
        this.profilePic = profilePic;
        this.about = about;
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

}
