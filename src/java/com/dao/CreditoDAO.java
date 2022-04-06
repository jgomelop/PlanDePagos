/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import javax.ejb.Stateless;
import com.modelo.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Pablo Gómez López
 */
@Stateless
public class CreditoDAO implements CreditoDAOLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addCredito(Credito credito) {
        em.persist(credito);
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void editCredito(Credito credito) {
        em.merge(credito);
    }
    @Override
    public void deleteCredito(int creditoId) {
        em.remove(getCredito(creditoId));
    }

    @Override
    public Credito getCredito(int creditoId) {
        return em.find(Credito.class, creditoId);
    }

    @Override
    public List<Credito> getAllCreditos() {
        return em.createNamedQuery("Credito.getAll").getResultList();
    }

    
}
