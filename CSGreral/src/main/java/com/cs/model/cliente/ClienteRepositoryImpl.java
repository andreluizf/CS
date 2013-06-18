package com.cs.model.cliente;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "ClienteRepositoryImp", mappedName = "ejb/ClienteRepositoryImp")
@Remote(ClienteRepository.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClienteRepositoryImpl implements ClienteRepository {

    @PersistenceContext(unitName = "CS")
    EntityManager em;

    @Override
    public void saveOrUpdate(Cliente modelo) {
        em.merge(modelo);
    }

    @Override
    public void delete(Cliente modelo) {
    }

    @Override
    public List<Cliente> findAll() {
        return em.createQuery("select c from Cliente c ").getResultList();
    }

    @Override
    public Cliente findById(Long id) {
        return null;
    }
}
