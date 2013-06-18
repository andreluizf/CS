package com.web.model;

import java.io.Serializable;


public class Aba implements Serializable{
    private String titulo;
    private String pagina;

    public Aba(String pagina, String titulo) {
        this.titulo = titulo;
        this.pagina = pagina;
       
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
