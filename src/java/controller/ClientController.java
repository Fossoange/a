/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Client;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.ClientFacade;

/**
 *
 * @author FOSSO
 */
@Named(value = "clientController")
@SessionScoped
public class ClientController implements Serializable {

    @EJB
    private ClientFacade clientFacade;
    
    private String nom;
    private String adresse;
    private int telephone;
    private String login;
    private String passeword;
    private static String annuler = "non";
    private Client client = new Client();
    private String confirpassword;

    /**
     * Creates a new instance of ClientController
     */
    public ClientController() {
        
    }

    public String getAnnuler() {
        return annuler;
    }

    public void setAnnuler(String annuler) {
        this.annuler = annuler;
    }

    public String getConfirpassword() {
        return confirpassword;
    }

    public void setConfirpassword(String confirpassword) {
        this.confirpassword = confirpassword;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasseword() {
        return passeword;
    }

    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public void newCostumer(){
        Client clien=new Client();
        if(!"".equals(nom) && !"".equals(adresse) && !"".equals(telephone) && !"".equals(login) && !"".equals(passeword)){
            if(passeword.equals(confirpassword)){    
                try{
                    Client  verifycutum = this.clientFacade.findByName(login);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Redondence d'identification : ", "cet addresse existe déjà."));
                }catch(Exception ex){
                        clien.setAnnuler(annuler);
                        clien.setLogin(login);
                        clien.setNom(nom);
                        clien.setPasseword(passeword);
                        clien.setTelephone(telephone);
                        
                        this.clientFacade.create(clien);
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Welcome", "Mr "+nom));
            
                }
                
                }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR," :","Les 2 mot de passe ne sont pas identique."));
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Erreur","Certains champs son vide."));
        } 
    }
    
}
