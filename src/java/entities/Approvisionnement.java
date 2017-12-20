/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "approvisionnement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Approvisionnement.findAll", query = "SELECT a FROM Approvisionnement a")
    , @NamedQuery(name = "Approvisionnement.findByIdapprovisionnement", query = "SELECT a FROM Approvisionnement a WHERE a.idapprovisionnement = :idapprovisionnement")
    , @NamedQuery(name = "Approvisionnement.findByDateapprovisionnement", query = "SELECT a FROM Approvisionnement a WHERE a.dateapprovisionnement = :dateapprovisionnement")
    , @NamedQuery(name = "Approvisionnement.findByPrixtotal", query = "SELECT a FROM Approvisionnement a WHERE a.prixtotal = :prixtotal")
    , @NamedQuery(name = "Approvisionnement.findByAnnuler", query = "SELECT a FROM Approvisionnement a WHERE a.annuler = :annuler")})
public class Approvisionnement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAPPROVISIONNEMENT")
    private BigInteger idapprovisionnement;
    @Column(name = "DATEAPPROVISIONNEMENT")
    @Temporal(TemporalType.DATE)
    private Date dateapprovisionnement;
    @Column(name = "PRIXTOTAL")
    private Integer prixtotal;
    @Size(max = 32)
    @Column(name = "ANNULER")
    private String annuler;

    public Approvisionnement() {
    }

    public Approvisionnement(BigInteger idapprovisionnement) {
        this.idapprovisionnement = idapprovisionnement;
    }

    public BigInteger getIdapprovisionnement() {
        return idapprovisionnement;
    }

    public void setIdapprovisionnement(BigInteger idapprovisionnement) {
        this.idapprovisionnement = idapprovisionnement;
    }

    public Date getDateapprovisionnement() {
        return dateapprovisionnement;
    }

    public void setDateapprovisionnement(Date dateapprovisionnement) {
        this.dateapprovisionnement = dateapprovisionnement;
    }

    public Integer getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(Integer prixtotal) {
        this.prixtotal = prixtotal;
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
        hash += (idapprovisionnement != null ? idapprovisionnement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Approvisionnement)) {
            return false;
        }
        Approvisionnement other = (Approvisionnement) object;
        if ((this.idapprovisionnement == null && other.idapprovisionnement != null) || (this.idapprovisionnement != null && !this.idapprovisionnement.equals(other.idapprovisionnement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Approvisionnement[ idapprovisionnement=" + idapprovisionnement + " ]";
    }
    
}
