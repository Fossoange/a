/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import entities.*;

import java.util.*;
import javax.ejb.EJB;

import model.AchatFacade;
import model.ApprovisionnementFacade;
import model.ProduitFacade;
import model.StockFacade;
import org.primefaces.event.SelectEvent;
/**
 *
 * @author FOSSO
 */
@Named(value = "achatController")
@SessionScoped
public class AchatController implements Serializable {

    @EJB
    private ApprovisionnementFacade approvisionnementFacade;

    @EJB
    private StockFacade stockFacade;

    @EJB
    private ProduitFacade produitFacade;

    @EJB
    private AchatFacade achatFacade;

    
    private Stock stock=new Stock();
    private Produit p;
    private Integer quantite;
    private Integer prixunitaire;
    private int statut;
    private Integer total;
    private final String annuler="non";
    private Date dateapprov=new Date();
    
    private Approvisionnement numeroapprovisionnement;
    
    /**
     * Creates a new instance of AchatController
     */
    public AchatController() {
    }
    
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    
    public Date getDateapprov() {
        return dateapprov;
    }

    public void setDateapprov(Date dateapprov) {
        this.dateapprov = dateapprov;
    }
    
    public Produit getP() {
        return p;
    }

    public void setP(Produit p) {
        this.p = p;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(Integer prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public Approvisionnement getNumeroapprovisionnement() {
        return numeroapprovisionnement;
    }

    public void setNumeroapprovisionnement(Approvisionnement numeroapprovisionnement) {
        this.numeroapprovisionnement = numeroapprovisionnement;
    }
    
    public List<Produit> chargerProduit(){
        return this.produitFacade.findAll();
    }
    
    public void enregistrerAchat(){
        
        Achat achat=new Achat();
        Approvisionnement approvisionnement=new Approvisionnement();
        //creation de l'approvisionnement
        approvisionnement.setAnnuler(annuler);
        System.out.println(dateapprov);
        approvisionnement.setDateapprovisionnement(dateapprov);
        total=prixunitaire*quantite;
        approvisionnement.setPrixtotal(total);
        //this.approvisionnementFacade.create(approvisionnement);
        
        //insertion de l'achat
        achat.setAnnuler(annuler);
        achat.setIdapprovisionnement(approvisionnement.getIdapprovisionnement());
        achat.setIdproduit(p.getIdproduit());
        achat.setPrixunitaire(prixunitaire);
        achat.setQuantite(quantite);
        achat.setStatut("valider");
        //this.achatFacade.create(achat);
        System.out.println(p.getIdproduit());
        
        //ajout du produit acheté dans le stock
        stock=this.stockFacade.find(p.getIdproduit());
        if(stock != null){
            int stockquantitie = (int) stock.getQuantite();
            stock.setQuantite(stockquantitie + quantite);
            //this.stockFacade.edit(stock);
            System.out.println(p.getDesignation());
        }else{
            System.out.println("echec");
        }
        
        Date now = new  Date(1095379201L);
        System.out.println(now.toString());
    }
    
}
