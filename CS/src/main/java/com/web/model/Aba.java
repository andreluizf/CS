package com.web.model;

import java.io.Serializable;


public class Aba implements Serializable{
    private String titulo;
    private String pagina;
    private int posicao;

    public Aba(String pagina, String titulo, int pos) {
        this.titulo = titulo;
        this.pagina = pagina;
        posicao = pos;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
}
