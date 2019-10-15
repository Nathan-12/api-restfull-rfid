package com.rfid.api.model.enums;

public enum TipoAtividade {
    ASSOCIACAO("Associacao"),
    V_OU_F("V-ou-F");
    private String descricao;

    TipoAtividade (String valor){
        descricao = valor;
    }

    public String getDescricao(){
        return descricao;
    }
}
