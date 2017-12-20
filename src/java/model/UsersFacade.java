/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FOSSO
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "SharlesShoppingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    public Users findByName(String name){
        return (Users) this.em.createNamedQuery("Users.findByNom").setParameter("nom", name).getSingleResult();
       //this.em.createQuery("SELECT u FROM Users u WHERE u.nom=:name").setParameter("name", name).getResultList();findByMatricule
    }
    public Users findByMatricule(String matriculetofine){
        return (Users) this.em.createNamedQuery("Users.findByMatricule").setParameter("matricule", matriculetofine).getSingleResult();
       //this.em.createQuery("SELECT u FROM Users u WHERE u.nom=:name").setParameter("name", name).getResultList();findByMatricule
    }
    
}
