package com.web.sistema.controller;

import com.google.common.collect.Lists;
import com.web.model.Aba;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.component.tabview.TabView;

@ManagedBean(name = "abaController")
@SessionScoped
public class AbaController implements Serializable {

    private List<Aba> aba = Lists.newArrayList();
    private int posicao;
    private String paginaAtual;

    public String getPaginaAtual() {
        if (!aba.isEmpty()) {
            paginaAtual = aba.get(this.posicao).getPagina();
        }
        return paginaAtual;
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

//    public void onTabClose(int posicao) {
//        int x = 0;
//        if (aba.size() == 1) {
//            x = posicao;
//        } else {
//            x = posicao + 1;
//        }
//        aba.remove(x);
//        cont--;
//
//    }
    public void onTabClose(AjaxBehaviorEvent event) {
        TabView tab = (TabView) event.getComponent();
        aba.remove(tab.getActiveIndex());
        posicao = tab.getActiveIndex() - 1;

    }

    public void addAba(String pagina, String tituloPg) {
        boolean reg = false;
        for (int x = 0; x < aba.size(); x++) {
            if (tituloPg.equals(aba.get(x).getTitulo())) {
                reg = true;
                posicao = x;
            }
        }
        if (!reg) {
            aba.add(new Aba(pagina, tituloPg));
            posicao = aba.size() - 1;
        }
    }
}
