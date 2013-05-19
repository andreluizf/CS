/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.model.cliente;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andre
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cliente")
    private Integer codCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nome")
    private Serializable nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpf_cnpj")
    private int cpfCnpj;
    @Column(name = "email")
    private Serializable email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_pessoa")
    private char tipoPessoa;
    @Column(name = "telefone1")
    private Integer telefone1;
    @Column(name = "telefone2")
    private Integer telefone2;
    @Column(name = "celular")
    private Integer celular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "logradouro")
    private Serializable logradouro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Column(name = "bairro")
    private Serializable bairro;
    @Column(name = "complemento")
    private Serializable complemento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cep")
    private int cep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cidade")
    private Serializable cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro=new Date();
    @Column(name = "data_alteracao")
    @Temporal(TemporalType.DATE)
    private Date dataAlteracao;

    public Cliente() {
    }

    public Cliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Cliente(Integer codCliente, Serializable nome, int cpfCnpj, char tipoPessoa, Serializable logradouro, int numero, int cep, Serializable cidade, String estado) {
        this.codCliente = codCliente;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.tipoPessoa = tipoPessoa;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Serializable getNome() {
        return nome;
    }

    public void setNome(Serializable nome) {
        this.nome = nome;
    }

    public int getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(int cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Serializable getEmail() {
        return email;
    }

    public void setEmail(Serializable email) {
        this.email = email;
    }

    public char getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(char tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Integer getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(Integer telefone1) {
        this.telefone1 = telefone1;
    }

    public Integer getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(Integer telefone2) {
        this.telefone2 = telefone2;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Serializable getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Serializable logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Serializable getBairro() {
        return bairro;
    }

    public void setBairro(Serializable bairro) {
        this.bairro = bairro;
    }

    public Serializable getComplemento() {
        return complemento;
    }

    public void setComplemento(Serializable complemento) {
        this.complemento = complemento;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public Serializable getCidade() {
        return cidade;
    }

    public void setCidade(Serializable cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.model.cliente.Cliente[ codCliente=" + codCliente + " ]";
    }
    
}
