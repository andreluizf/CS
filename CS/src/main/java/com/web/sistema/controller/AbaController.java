package com.web.sistema.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "abaController")
@ViewScoped
public class AbaController implements Serializable {

    private String titulo;
    private String pagina;

    @PostConstruct
    public void abaController() {
        
    }

    public String getTitulo() {
        System.out.println("titulo1" + titulo);
        return titulo;
    }

    public void setTitulo(String titulo) {
        System.out.println("titulo2" + titulo);
        this.titulo = titulo;
    }

    public String getPagina() {
        System.out.println("pagina 2" + pagina);
        return pagina;
    }

    public void setPagina(String pagina) {
        System.out.println("pagina 1" + pagina);
        this.pagina = pagina;
    }
}
