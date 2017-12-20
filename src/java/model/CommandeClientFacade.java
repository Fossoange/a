/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.CommandeClient;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FOSSO
 */
@Stateless
public class CommandeClientFacade extends AbstractFacade<CommandeClient> {

    @PersistenceContext(unitName = "SharlesShoppingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeClientFacade() {
        super(CommandeClient.class);
    }
    
}
