/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Client;
import entities.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FOSSO
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "SharlesShoppingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    public Client findByName(String name){
        return (Client) this.em.createNamedQuery("Client.findByLogin").setParameter("login", name).getSingleResult();
       //this.em.createQuery("SELECT u FROM Users u WHERE u.nom=:name").setParameter("name", name).getResultList();findByMatricule
    }
    /*public Client findByMatricule(String matriculetofine){
        return (Client) this.em.createNamedQuery("Users.findByMatricule").setParameter("matricule", matriculetofine).getSingleResult();
       //this.em.createQuery("SELECT u FROM Users u WHERE u.nom=:name").setParameter("name", name).getResultList();findByMatricule
    }*/
}
