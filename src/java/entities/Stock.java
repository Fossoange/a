/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FOSSO
 */
@Entity
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findByIdstock", query = "SELECT s FROM Stock s WHERE s.idstock = :idstock")
    , @NamedQuery(name = "Stock.findByQuantite", query = "SELECT s FROM Stock s WHERE s.quantite = :quantite")
    , @NamedQuery(name = "Stock.findByDateexpiration", query = "SELECT s FROM Stock s WHERE s.dateexpiration = :dateexpiration")
    , @NamedQuery(name = "Stock.findByAnnuler", query = "SELECT s FROM Stock s WHERE s.annuler = :annuler")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDSTOCK")
    private Integer idstock;
    @Column(name = "QUANTITE")
    private Integer quantite;
    @Column(name = "DATEEXPIRATION")
    @Temporal(TemporalType.DATE)
    private Date dateexpiration;
    @Size(max = 32)
    @Column(name = "ANNULER")
    private String annuler;

    public Stock() {
    }

    public Stock(Integer idstock) {
        this.idstock = idstock;
    }

    public Integer getIdstock() {
        return idstock;
    }

    public void setIdstock(Integer idstock) {
        this.idstock = idstock;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Date getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(Date dateexpiration) {
        this.dateexpiration = dateexpiration;
    }

    public String getAnnuler() {
        return annuler;
    }

    public void setAnnuler(String annuler) {
        this.annuler = annuler;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstock != null ? idstock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.idstock == null && other.idstock != null) || (this.idstock != null && !this.idstock.equals(other.idstock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Stock[ idstock=" + idstock + " ]";
    }
    
}
