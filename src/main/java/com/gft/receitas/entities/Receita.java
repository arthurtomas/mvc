package com.gft.receitas.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome da receita não pode ser vazio.")
    private String nome;

    private String tempoPreparo;

    @Lob
    private String itensString;

    @Lob
    @NotEmpty(message = "Você precisa preencher o modo de preparo.")
    private String modoPreparo;

    private String rendimento;

    private String url;



//    Getters ans Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(String tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public String getItensString() {
        return itensString;
    }

    public void setItensString(String itensString) {
        this.itensString = itensString;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public String getRendimento() {
        return rendimento;
    }

    public void setRendimento(String rendimento) {
        this.rendimento = rendimento;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {

        if (url.contains("v=")) {
            url = url.split("v=")[1];
            url = "https://www.youtube.com/embed/"+url;
        }else {
            url = url.split("embed/")[1];
            url = "https://www.youtube.com/embed/"+url;
        }

        this.url = url;
    }
}
