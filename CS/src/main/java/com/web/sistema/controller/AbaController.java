package com.web.sistema.controller;

import com.google.common.collect.Lists;
import com.web.model.Aba;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

@ManagedBean(name = "abaController")
@ViewScoped
public class AbaController implements Serializable {

    private List<Aba> aba = Lists.newArrayList();
    private int cont = 0;
    private int posicao;
    private String paginaAtual;

    public int getCont() {
        return cont;
    }

    public String getPaginaAtual() {
        if (!aba.isEmpty()) {
            paginaAtual = aba.get(this.posicao).getPagina();
        }
        return paginaAtual;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public List<Aba> getAba() {
        return aba;
    }

    public void setAba(List<Aba> aba) {
        this.aba = aba;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String action() {
        return "1"
                + "";
    }

    public void onTabClose(TabCloseEvent event) {
        System.out.println("remove");
        TabView tb = (TabView) event.getComponent();
        Aba ab = (Aba) event.getData();
        for (int x = 0; x < aba.size(); x++) {
            if (aba.get(x).getTitulo().equals(ab.getTitulo())) {
                aba.remove(x);
                cont--;
            }
        }
        FacesMessage msg = new FacesMessage("Tab Fechada", "Fechada Tab: " + ab.getTitulo());
        FacesContext.getCurrentInstance().addMessage("growl", msg);
    }

    public void onTabChange(TabChangeEvent event) {
        TabView tb = (TabView) event.getComponent();
        Aba ab = (Aba) event.getData();
        aba.get(tb.getActiveIndex()).getPagina();
        FacesMessage msg = new FacesMessage("Alterar Tab", "Alterar Tab: " + tb.getActiveIndex());
        FacesContext.getCurrentInstance().addMessage("growl", msg);
    }

    public void addAba(String pagina, String tituloPg) {
        int reg = 0;

        for (int x = 0; x < aba.size(); x++) {
            if (tituloPg.equals(aba.get(x).getTitulo())) {
                reg++;
                posicao = x;
            }
        }
        if (reg == 0) {
            posicao = cont;
            aba.add(new Aba(pagina, tituloPg,cont));
            cont++;
        }
    }
}
