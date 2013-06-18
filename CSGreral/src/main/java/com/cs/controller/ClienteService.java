package com.cs.controller;

import com.cs.helper.NumberHelper;
import com.cs.model.cliente.Cliente;
import com.cs.model.cliente.ClienteRepository;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;

public class ClienteService {

    @EJB
    ClienteRepository clienteRepository;

    public void salvar(ClienteController control) {
        if (!control.getCliente().getTelefone1().isEmpty()) {
            control.getCliente().setTelefone1(NumberHelper.getNumbers(control.getCliente().getTelefone1()));
        }
        if (!control.getCliente().getCelular().isEmpty()) {
            control.getCliente().setCelular(NumberHelper.getNumbers(control.getCliente().getCelular()));
        }

        control.getCliente().setCep(NumberHelper.getNumbers(control.getCliente().getCep()));
        control.getCliente().setCpfCnpj(NumberHelper.getNumbers(control.getCliente().getCpfCnpj()));
        control.getCliente().setStatus(Boolean.TRUE);
        clienteRepository.saveOrUpdate(control.cliente);
        RequestContext.getCurrentInstance().execute("loadDataTableCliente(),novoCliente.hide()");
        
    }

    public List<Cliente> findAllCliente() {
        return clienteRepository.findAll();
    }
}
