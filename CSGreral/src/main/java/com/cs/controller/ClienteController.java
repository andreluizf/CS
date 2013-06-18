package com.cs.controller;

import com.cs.helper.CepHelper;
import com.cs.model.cliente.Cliente;
import com.google.common.base.CharMatcher;
import com.cs.helper.TelefoneHelper;
import com.cs.helper.ValidaCpfCnpj;
import com.cs.model.consulta.cep.RetornoCep;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {

    @Inject
    ClienteService clienteService;
    @Inject
    Cliente cliente;
    @Inject
    CepHelper cepHelper;
    private List<Cliente> listCliente = Lists.newArrayList();
    private TelefoneHelper maskTel = new TelefoneHelper();
    private ValidaCpfCnpj valida = new ValidaCpfCnpj();
    private String busca;
    private String buscaCep;
    private boolean validado = false;

    @PostConstruct
    public void init() {
        listCliente = clienteService.findAllCliente();

    }

    public void valida(String valida) {
        validado = cliente.getTipoPessoa() == 'J' ? this.valida.setValidCNPJ(valida) : this.valida.setValidCPF(valida);
        if (validado == false) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CNPJ/CPF : Inválido!!!", ""));
        }
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public TelefoneHelper getMaskTel() {
        return maskTel;
    }

    public void setMaskTel(TelefoneHelper maskTel) {
        this.maskTel = maskTel;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        System.out.println("cli+cliente"+cliente.getNome());
        this.cliente = cliente;
    }

    public String getBuscaCep() {
        return buscaCep;
    }

    public void setBuscaCep(String buscaCep) {
        RetornoCep retCep = null;
        if (buscaCep != null) {
            this.buscaCep = buscaCep;
            buscaCep = CharMatcher.DIGIT.retainFrom(buscaCep);
            retCep = cepHelper.findCEP(buscaCep);
            cliente.setCidade(retCep.getCidade());
            cliente.setEstado(retCep.getUf());
            cliente.setLogradouro(retCep.getLogradouro());
            cliente.setBairro(retCep.getBairro());
            cliente.setCep(buscaCep);
        }
        if (buscaCep == null || retCep == null || retCep.getResultado().equals("0")) {
            System.out.println("nao encontrador");
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CNPJ/CPF : Inválido!!!", ""));
           
//            RequestContext.getCurrentInstance().execute("loadMsg()");
        }
    }

    public void atualizar() {
        System.out.println("atualizar");
        listCliente = clienteService.findAllCliente();
    }
}
