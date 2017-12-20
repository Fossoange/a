/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author FOSSO
 */
@Named(value = "stockController")
@SessionScoped
public class StockController implements Serializable {

    /**
     * Creates a new instance of StockController
     */
    public StockController() {
    }
    
}
