/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import model.CommandeClientFacade;

/**
 *
 * @author FOSSO
 */
@Named(value = "commandeClientController")
@SessionScoped
public class CommandeClientController implements Serializable {
    
@EJB
private CommandeClientFacade ccf;

    /**
     * Creates a new instance of CommandeClientController
     */
    public CommandeClientController() {
    }
    
}
