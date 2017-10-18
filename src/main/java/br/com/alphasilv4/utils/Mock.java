/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alphasilv4.utils;

import br.com.alphasilv4.mock.ServicoMock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilizada para ...
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class Mock implements Serializable {

    public static List<ServicoMock> servicos() {

        List<ServicoMock> servicos = new ArrayList<>();

        ServicoMock srv01 = new ServicoMock(1, "Cozinheiro", "fa fa-cutlery", "Cook", 7);
        ServicoMock srv02 = new ServicoMock(2, "Manutenção", "fa fa-wrench", "chave inglesa", 7);
        ServicoMock srv03 = new ServicoMock(3, "Conserto Bicicleta", "fa fa-bicycle", "Conserto Bicicleta", 7);
        ServicoMock srv04 = new ServicoMock(4, "Conserto Carro", "fa fa-car", "Conserto Carro", 7);
        ServicoMock srv05 = new ServicoMock(5, "Limpeza em geral", "fa fa-shower", "Limpeza em geral", 7);
        ServicoMock srv06 = new ServicoMock(6, "Manutenção computador", "fa fa-laptop", "Manutenção computador", 7);
        ServicoMock srv07 = new ServicoMock(7, "Fotógrafo", "fa fa-camera-retro", "Fotógrafo", 7);
        ServicoMock srv08 = new ServicoMock(8, "Cozinheiro", "fa fa-cutlery", "Cook", 7);
        ServicoMock srv09 = new ServicoMock(9, "Manutenção", "fa fa-wrench", "chave inglesa", 7);
        ServicoMock srv10 = new ServicoMock(10, "Conserto Bicicleta", "fa fa-bicycle", "Conserto Bicicleta", 7);
        ServicoMock srv11 = new ServicoMock(11, "Conserto Carro", "fa fa-car", "Conserto Carro", 7);
        ServicoMock srv12 = new ServicoMock(12, "Limpeza em geral", "fa fa-shower", "Limpeza em geral", 7);
        ServicoMock srv13 = new ServicoMock(13, "Manutenção computador", "fa fa-laptop", "Manutenção computador", 7);
        ServicoMock srv14 = new ServicoMock(14, "Fotógrafo", "fa fa-camera-retro", "Fotógrafo", 7);
        ServicoMock srv15 = new ServicoMock(15, "Cozinheiro", "fa fa-cutlery", "Cook", 7);
        ServicoMock srv16 = new ServicoMock(16, "Manutenção", "fa fa-wrench", "chave inglesa", 7);
        ServicoMock srv17 = new ServicoMock(17, "Conserto Bicicleta", "fa fa-bicycle", "Conserto Bicicleta", 7);
        ServicoMock srv18 = new ServicoMock(18, "Conserto Carro", "fa fa-car", "Conserto Carro", 7);
        ServicoMock srv19 = new ServicoMock(19, "Limpeza em geral", "fa fa-shower", "Limpeza em geral", 7);
        ServicoMock srv20 = new ServicoMock(20, "Manutenção computador", "fa fa-laptop", "Manutenção computador", 7);
        ServicoMock srv21 = new ServicoMock(21, "Fotógrafo", "fa fa-camera-retro", "Fotógrafo", 7);        
        ServicoMock srv22 = new ServicoMock(22, "Bandeira", "fa fa-flag", "Bandeira", 7);
        ServicoMock srv23 = new ServicoMock(23, "Frasco", "fa fa-flask", "Frasco", 7);
        ServicoMock srv24 = new ServicoMock(24, "Aperto de Mão", "fa fa-handshake-o", "Aperto de Mão", 7);
        ServicoMock srv25 = new ServicoMock(25, "Coração", "fa fa-heart", "Coração", 7);
        ServicoMock srv26 = new ServicoMock(26, "Envelope aberto", "fa fa-envelope-open-o", "Envelope aberto", 7);
        ServicoMock srv27 = new ServicoMock(27, "Bola de futbol", "fa fa-futbol-o", "Bola de futbol", 7);
        ServicoMock srv28 = new ServicoMock(28, "Arquivo Zip", "fa fa-file-archive-o", "Arquivo Zipl", 7);
        ServicoMock srv29 = new ServicoMock(29, "Taça de vinho", "fa fa-glass", "Taça de vinho", 7);
        ServicoMock srv30 = new ServicoMock(30, "Presente", "fa fa-gift ", "Presente", 7);        
        ServicoMock srv31 = new ServicoMock(31, "Bandeira", "fa fa-flag", "Bandeira", 7);
        ServicoMock srv32 = new ServicoMock(32, "Bandeira", "fa fa-flag", "Bandeira", 7);
        ServicoMock srv33 = new ServicoMock(33, "Frasco", "fa fa-flask", "Frasco", 7);
        ServicoMock srv34 = new ServicoMock(34, "Aperto de Mão", "fa fa-handshake-o", "Aperto de Mão", 7);
        ServicoMock srv35 = new ServicoMock(35, "Coração", "fa fa-heart", "Coração", 7);
        ServicoMock srv36 = new ServicoMock(36, "Envelope aberto", "fa fa-envelope-open-o", "Envelope aberto", 7);
        ServicoMock srv37 = new ServicoMock(37, "Bola de futbol", "fa fa-futbol-o", "Bola de futbol", 7);
        ServicoMock srv38 = new ServicoMock(38, "Arquivo Zip", "fa fa-file-archive-o", "Arquivo Zipl", 7);
        ServicoMock srv39 = new ServicoMock(39, "Taça de vinho", "fa fa-glass", "Taça de vinho", 7);
        ServicoMock srv40 = new ServicoMock(40, "Presente", "fa fa-gift ", "Presente", 7);
        
        servicos.add(srv01);
        servicos.add(srv02);
        servicos.add(srv03);
        servicos.add(srv04);
        servicos.add(srv05);
        servicos.add(srv06);
        servicos.add(srv07);
        servicos.add(srv08);
        servicos.add(srv09);
        servicos.add(srv11);
        servicos.add(srv12);
        servicos.add(srv13);
        servicos.add(srv14);
        servicos.add(srv15);
        servicos.add(srv16);
        servicos.add(srv17);
        servicos.add(srv18);
        servicos.add(srv19);
        servicos.add(srv11);
        servicos.add(srv12);
        servicos.add(srv13);
        servicos.add(srv14);
        servicos.add(srv15);
        servicos.add(srv16);
        servicos.add(srv17);
        servicos.add(srv18);
        servicos.add(srv19);
        servicos.add(srv21);
        servicos.add(srv22);
        servicos.add(srv23);
        servicos.add(srv24);
        servicos.add(srv25);
        servicos.add(srv26);
        servicos.add(srv27);
        servicos.add(srv28);
        servicos.add(srv29);
        servicos.add(srv30);
        servicos.add(srv31);
        servicos.add(srv32);
        servicos.add(srv33);
        servicos.add(srv34);
        servicos.add(srv35);
        servicos.add(srv36);
        servicos.add(srv37);
        servicos.add(srv38);
        servicos.add(srv39);
        servicos.add(srv40);                
        
        return servicos;
    }

    public static ServicoMock servicoById(Integer id) {

        ServicoMock servico = new ServicoMock();

        for (ServicoMock s : servicos()) {
            if (s.getId().compareTo(id) == 0) {
                servico = s;
            }
        }

        return servico;
    }

    public static ServicoMock servicoByName(String name) {

        ServicoMock servico = new ServicoMock();

        for (ServicoMock s : servicos()) {
            if (s.getName().toLowerCase().contains(name.toLowerCase())) {
                servico = s;
            }
        }

        return servico;
    }

}
