package com.rfid.api.model.enums;

public enum Midia {
    IMAGEM("Imagem"),
    VIDEO("Video"),
    IMAGEM_E_VIDEO("Imagem-e-Video");
    private String descricao;

    Midia (String valor){
        descricao = valor;
    }

    public String getDescricao(){
        return descricao;
    }
}
