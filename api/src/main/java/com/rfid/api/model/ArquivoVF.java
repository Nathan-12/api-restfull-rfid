package com.rfid.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ArquivoVF {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nomeVideo;
    private String nomeImg;
    private Integer codigoTeste;
    private String caminho;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeVideo() {
        return nomeVideo;
    }

    public void setNomeVideo(String nomeVideo) {
        this.nomeVideo = nomeVideo;
    }

    public String getNomeImg() {
        return nomeImg;
    }

    public void setNomeImg(String nomeImg) {
        this.nomeImg = nomeImg;
    }

    public Integer getCodigoTeste() {
        return codigoTeste;
    }

    public void setCodigoTeste(Integer codigoTeste) {
        this.codigoTeste = codigoTeste;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}
