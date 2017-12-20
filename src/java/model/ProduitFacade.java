/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Produit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FOSSO
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> {

    @PersistenceContext(unitName = "SharlesShoppingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }
    
    
}
