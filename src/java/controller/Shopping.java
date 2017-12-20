/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Produit;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.ProduitFacade;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author FOSSO
 */
@Named(value = "shopping")
@SessionScoped
public class Shopping implements Serializable {

    @EJB
    private ProduitFacade produitFacade;
    
    private int nbredeproduitselectionné;
    private int i=0;
    private Produit produitselectionner;
    private List<Produit> panier;
    private String str;
    public Shopping() {
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNbredeproduitselectionné() {
        return nbredeproduitselectionné;
    }

    public void setNbredeproduitselectionné(int nbredeproduitselectionné) {
        this.nbredeproduitselectionné = nbredeproduitselectionné;
    }

    
    public Produit getProduitselectionner() {
        return produitselectionner;
    }

    public void setProduitselectionner(Produit produitselectionner) {
        this.produitselectionner = produitselectionner;
    }

    public List<Produit> getPanier() {
        return panier;
    }

    public void setPanier(List<Produit> panier) {
        this.panier = panier;
    }
    
    public List<Produit> chargerProduit(){
        return this.produitFacade.findAll();
    }
    
    public void onrowSlected(SelectEvent event){ 
        for(Produit p1:panier){
            if(p1 != null){
                i=i+1;
                System.out.println(p1.getDesignation());
            }
        }
        this.nbredeproduitselectionné=i;
        
        str=String.valueOf(this.nbredeproduitselectionné);
        FacesMessage msg=new FacesMessage("produit selectionner",str);
        FacesContext.getCurrentInstance().addMessage("Vue", msg);
    }
    
}
