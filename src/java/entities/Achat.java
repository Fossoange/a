/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FOSSO
 */
@Entity
@Table(name = "achat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Achat.findAll", query = "SELECT a FROM Achat a")
    , @NamedQuery(name = "Achat.findByIdachat", query = "SELECT a FROM Achat a WHERE a.idachat = :idachat")
    , @NamedQuery(name = "Achat.findByIdproduit", query = "SELECT a FROM Achat a WHERE a.idproduit = :idproduit")
    , @NamedQuery(name = "Achat.findByIdapprovisionnement", query = "SELECT a FROM Achat a WHERE a.idapprovisionnement = :idapprovisionnement")
    , @NamedQuery(name = "Achat.findByQuantite", query = "SELECT a FROM Achat a WHERE a.quantite = :quantite")
    , @NamedQuery(name = "Achat.findByPrixunitaire", query = "SELECT a FROM Achat a WHERE a.prixunitaire = :prixunitaire")
    , @NamedQuery(name = "Achat.findByStatut", query = "SELECT a FROM Achat a WHERE a.statut = :statut")
    , @NamedQuery(name = "Achat.findByAnnuler", query = "SELECT a FROM Achat a WHERE a.annuler = :annuler")})
public class Achat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDACHAT")
    private Integer idachat;
    @Column(name = "IDPRODUIT")
    private Integer idproduit;
    @Column(name = "IDAPPROVISIONNEMENT")
    private BigInteger idapprovisionnement;
    @Column(name = "QUANTITE")
    private Integer quantite;
    @Column(name = "PRIXUNITAIRE")
    private Integer prixunitaire;
    @Size(max = 32)
    @Column(name = "STATUT")
    private String statut;
    @Size(max = 32)
    @Column(name = "ANNULER")
    private String annuler;

    public Achat() {
    }

    public Achat(Integer idachat) {
        this.idachat = idachat;
    }

    public Integer getIdachat() {
        return idachat;
    }

    public void setIdachat(Integer idachat) {
        this.idachat = idachat;
    }

    public Integer getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public BigInteger getIdapprovisionnement() {
        return idapprovisionnement;
    }

    public void setIdapprovisionnement(BigInteger idapprovisionnement) {
        this.idapprovisionnement = idapprovisionnement;
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
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
        hash += (idachat != null ? idachat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achat)) {
            return false;
        }
        Achat other = (Achat) object;
        if ((this.idachat == null && other.idachat != null) || (this.idachat != null && !this.idachat.equals(other.idachat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Achat[ idachat=" + idachat + " ]";
    }
    
}
