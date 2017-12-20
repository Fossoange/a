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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vente.findAll", query = "SELECT v FROM Vente v")
    , @NamedQuery(name = "Vente.findByIdvente", query = "SELECT v FROM Vente v WHERE v.idvente = :idvente")
    , @NamedQuery(name = "Vente.findByIdproduit", query = "SELECT v FROM Vente v WHERE v.idproduit = :idproduit")
    , @NamedQuery(name = "Vente.findByQuantite", query = "SELECT v FROM Vente v WHERE v.quantite = :quantite")
    , @NamedQuery(name = "Vente.findByPrixunitaire", query = "SELECT v FROM Vente v WHERE v.prixunitaire = :prixunitaire")
    , @NamedQuery(name = "Vente.findByDatevente", query = "SELECT v FROM Vente v WHERE v.datevente = :datevente")
    , @NamedQuery(name = "Vente.findByStatut", query = "SELECT v FROM Vente v WHERE v.statut = :statut")
    , @NamedQuery(name = "Vente.findByAnnuler", query = "SELECT v FROM Vente v WHERE v.annuler = :annuler")})
public class Vente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVENTE")
    private Long idvente;
    @Column(name = "IDPRODUIT")
    private Integer idproduit;
    @Column(name = "QUANTITE")
    private BigInteger quantite;
    @Column(name = "PRIXUNITAIRE")
    private Integer prixunitaire;
    @Column(name = "DATEVENTE")
    @Temporal(TemporalType.DATE)
    private Date datevente;
    @Size(max = 32)
    @Column(name = "STATUT")
    private String statut;
    @Size(max = 32)
    @Column(name = "ANNULER")
    private String annuler;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne
    private Users iduser;
    @JoinColumn(name = "IDCLIENT", referencedColumnName = "IDCLIENT")
    @ManyToOne
    private Client idclient;

    public Vente() {
    }

    public Vente(Long idvente) {
        this.idvente = idvente;
    }

    public Long getIdvente() {
        return idvente;
    }

    public void setIdvente(Long idvente) {
        this.idvente = idvente;
    }

    public Integer getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public BigInteger getQuantite() {
        return quantite;
    }

    public void setQuantite(BigInteger quantite) {
        this.quantite = quantite;
    }

    public Integer getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(Integer prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public Date getDatevente() {
        return datevente;
    }

    public void setDatevente(Date datevente) {
        this.datevente = datevente;
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

    public Users getIduser() {
        return iduser;
    }

    public void setIduser(Users iduser) {
        this.iduser = iduser;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvente != null ? idvente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vente)) {
            return false;
        }
        Vente other = (Vente) object;
        if ((this.idvente == null && other.idvente != null) || (this.idvente != null && !this.idvente.equals(other.idvente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vente[ idvente=" + idvente + " ]";
    }
    
}
