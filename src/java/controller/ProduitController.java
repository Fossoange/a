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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import model.ProduitFacade;
import model.StockFacade;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author FOSSO
 */
@Named(value = "produitController")
@SessionScoped
public class ProduitController implements Serializable {

    @EJB
    private ProduitFacade produitFacade;
    @EJB
    private StockFacade stockFacade;
    
    private String[] nomproduit=new String[30];
    private String designation;
    private int pu;
    private String categorie;
    private String famille;
    private String sousfamille;
    private String description;
    private int code;
    private Date dateexpiration;
    private String labelImage;
    
    
    private final String annulation="non";
    /**
     * Creates a new instance of ProduitController
     */
    public ProduitController() {
    }

    public String getLabelImage() {
        return labelImage;
    }

    public void setLabelImage(String labelImage) {
        this.labelImage = labelImage;
    }

    
    public String[] getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String[] nomproduit) {
        this.nomproduit = nomproduit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getPu() {
        return pu;
    }

    public void setPu(int pu) {
        this.pu = pu;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getSousfamille() {
        return sousfamille;
    }

    public void setSousfamille(String sousfamille) {
        this.sousfamille = sousfamille;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(Date dateexpiration) {
        this.dateexpiration = dateexpiration;
    }
    public Produit getProduit(Integer id) {
        return produitFacade.find(id);
    }
    public void createProduct(){
        Produit p=new Produit();
        Stock stock=new Stock();
        p.setDesignation(designation);
        p.setPrixunitaire(pu);
        p.setCategorie(categorie);
        p.setFamille(famille);
        p.setSousFamille(sousfamille);
        p.setCode(code);
        p.setDescription(description);
        p.setAnnuler(annulation);
        p.setLabelImage(labelImage);
        
        SimpleDateFormat newdate=new SimpleDateFormat("YYYY/MM/dd");
        //stock
        //gestion de date
        stock.setAnnuler(annulation);
        stock.setDateexpiration(dateexpiration);
        stock.setQuantite(0);
        
        this.produitFacade.create(p);
        this.stockFacade.create(stock);
        
    }
    
    public List<String> nomImages(){
       List<String> image=new ArrayList<>();
        image.add("imagesps.jpg");
        image.add("imagesps.jpg");
        image.add("imagesps.jpg");
        image.add("imagesps.jpg");
        return image;
    }
    
    public String[] marqueOrdinateurs() throws Exception{
        int i=0;
        XMLInputFactory xmlFile=XMLInputFactory.newInstance();
        XMLStreamReader xmlstr= xmlFile.createXMLStreamReader(new FileReader("C:\\Users\\FOSSO\\Documents\\NetBeansProjects\\SharlesShopping\\XML\\data.xml"));
        int type;
        boolean agains=xmlstr.hasNext();
        while(agains){
            type=xmlstr.next();
            if(type == XMLEvent.START_ELEMENT){
                if(xmlstr.getLocalName().startsWith("MARQUE_LAPTOP_")){
                    this.nomproduit[i] = xmlstr.getLocalName().substring(14);         
                }
            }
            if(!xmlstr.hasNext()){
                agains=false;
            }
            i++;
        }
        return this.nomproduit;
    }
}
