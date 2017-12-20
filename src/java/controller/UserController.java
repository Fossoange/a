/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.UsersFacade;

/**
 *
 * @author FOSSO
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {
@EJB
private UsersFacade usersFacade;
private List<Users> users = new ArrayList<>();
private Users u;
private String confirmmatricule;
private String login;
private String passeword;
private String nom;
private String prenom;
private String matricule;
private String fonction;
private String logsuperuser;
private String passsuperuser;
private int telephone;
private final String nannuler="non";
private String gestionboutons;

    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }

    public String getGestionboutons() {
        return gestionboutons;
    }

    public void setGestionboutons(String gestionboutons) {
        this.gestionboutons = gestionboutons;
    }

    public String getLogsuperuser() {
        return logsuperuser;
    }

    public void setLogsuperuser(String logsuperuser) {
        this.logsuperuser = logsuperuser;
    }

    public String getPasssuperuser() {
        return passsuperuser;
    }

    public void setPasssuperuser(String passsuperuser) {
        this.passsuperuser = passsuperuser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getConfirmmatricule() {
        return confirmmatricule;
    }

    public void setConfirmmatricule(String confirmmatricule) {
        this.confirmmatricule = confirmmatricule;
    }

    
    public String getPasseword() {
        return passeword;
    }

    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }

    
    public Users getU() {
        return u;
    }

    public void setU(Users u) {
        this.u = u;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    public void createUser(){
        Users use=new Users();
        if(!"".equals(nom) && !"".equals(prenom) && !"".equals(telephone) && !"".equals(fonction) && !"".equals(matricule)){
            if(matricule.equals(confirmmatricule)){
                
                try{
                    Users  verifyuser = this.usersFacade.findByName(nom);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Redondence d'identification : ", "cet addresse existe déjà."));
                }catch(Exception ex){
                        use.setAnnuler(nannuler);
                        use.setFonction(fonction);
                        use.setMatricule(matricule);
                        use.setNom(nom);
                        use.setPrenom(prenom);
                        use.setTelephone(telephone);
                        this.usersFacade.create(use);
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Welcome", "Mr "+prenom));
            
                }
                
                }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR," :","Les 2 matricules ne sont pas identique."));
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Erreur","Certains champs son vide."));
        } 
    }
    
    public List<Users> showUsers(){
        return this.usersFacade.findAll();
    }
    public Users getUsers(Integer id) {
        return usersFacade.find(id);
    }
    public String connexion(){
        try{
                u=this.usersFacade.findByName(login);
                if(u !=null){
                    if(u.getMatricule().equals(this.passeword)){
                        if("admin".equals(u.getFonction())){
                            return "toadmin";
                        }else{
                            System.out.println("connecté");
                            FacesMessage msg=new FacesMessage("Connecté !", "connecté !");
                            FacesContext.getCurrentInstance().addMessage("vue", msg);
                        }
                    }else{
                        System.out.println("Login ou mot de passe incorret !");
                        FacesMessage msg=new FacesMessage("Error", "Mot de passe innexistant");
                        FacesContext.getCurrentInstance().addMessage("vue", msg);
                    }
                 }else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Mot de passe incorrect."));
                 }
                
            }catch(Exception e){
                FacesMessage msg=new FacesMessage("Error !","veuillez bien renseigné tout vos champ");
                        FacesContext.getCurrentInstance().addMessage("vue", msg);
            }
         return null;
          
    }
    public String superUtilisateur(){
        Users superuser = new Users();
        try{
            superuser = this.usersFacade.findByName(logsuperuser);
            if(passsuperuser.equals(superuser.getMatricule())){
                if("superuser".equals(superuser.getFonction())){
                    FacesMessage msg=new FacesMessage("Ok !","cool !");
                    FacesContext.getCurrentInstance().addMessage("vue", msg);
                    return "gestionUser";
                }
            }else{
                FacesMessage msg=new FacesMessage("Error !","Login ou mot de passe incorret !");
                FacesContext.getCurrentInstance().addMessage("vue", msg);
                return null;
            }
        }catch(Exception ex){
            FacesMessage msg=new FacesMessage("Error !","Login ou mot de passe incorret !");
            FacesContext.getCurrentInstance().addMessage("vue", msg);
            
        }
        return null;
    }
}
