package com.rfid.api.model;

import com.rfid.api.model.enums.Midia;
import com.rfid.api.model.enums.TipoAtividade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoAtividade tipoAtividade;

    @Enumerated(EnumType.STRING)
    private Midia midia;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Arquivo> arquivos;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<ArquivoVF> arquivoVFS;

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

    public TipoAtividade getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(TipoAtividade tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public Midia getMidia() {
        return midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public List<ArquivoVF> getArquivoVFS() {
        return arquivoVFS;
    }

    public void setArquivoVFS(List<ArquivoVF> arquivoVFS) {
        this.arquivoVFS = arquivoVFS;
    }
}
