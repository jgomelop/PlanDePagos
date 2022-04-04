/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.modelo.Credito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Pablo
 */
@Local
public interface CreditoDAOLocal {

    void addCredito(Credito credito);

    void deleteCredito(int creditoId);

    void editCredito(Credito credito);

    Credito getCredito(int creditoId);

    List<Credito> getAllCreditos();
    
}
