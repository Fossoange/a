/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
@Table(name = "fournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f")
    , @NamedQuery(name = "Fournisseur.findByIdfournisseur", query = "SELECT f FROM Fournisseur f WHERE f.idfournisseur = :idfournisseur")
    , @NamedQuery(name = "Fournisseur.findByNom", query = "SELECT f FROM Fournisseur f WHERE f.nom = :nom")
    , @NamedQuery(name = "Fournisseur.findByPrenom", query = "SELECT f FROM Fournisseur f WHERE f.prenom = :prenom")
    , @NamedQuery(name = "Fournisseur.findByAdresse", query = "SELECT f FROM Fournisseur f WHERE f.adresse = :adresse")
    , @NamedQuery(name = "Fournisseur.findByCodepostal", query = "SELECT f FROM Fournisseur f WHERE f.codepostal = :codepostal")
    , @NamedQuery(name = "Fournisseur.findBySociete", query = "SELECT f FROM Fournisseur f WHERE f.societe = :societe")
    , @NamedQuery(name = "Fournisseur.findByCni", query = "SELECT f FROM Fournisseur f WHERE f.cni = :cni")
    , @NamedQuery(name = "Fournisseur.findByVillePays", query = "SELECT f FROM Fournisseur f WHERE f.villePays = :villePays")
    , @NamedQuery(name = "Fournisseur.findByAnnuler", query = "SELECT f FROM Fournisseur f WHERE f.annuler = :annuler")})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFOURNISSEUR")
    private Long idfournisseur;
    @Size(max = 128)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 32)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 128)
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "CODEPOSTAL")
    private Integer codepostal;
    @Size(max = 32)
    @Column(name = "SOCIETE")
    private String societe;
    @Column(name = "CNI")
    private Integer cni;
    @Size(max = 32)
    @Column(name = "VILLE_PAYS")
    private String villePays;
    @Size(max = 32)
    @Column(name = "ANNULER")
    private String annuler;

    public Fournisseur() {
    }

    public Fournisseur(Long idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    public Long getIdfournisseur() {
        return idfournisseur;
    }

    public void setIdfournisseur(Long idfournisseur) {
        this.idfournisseur = idfournisseur;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(Integer codepostal) {
        this.codepostal = codepostal;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public Integer getCni() {
        return cni;
    }

    public void setCni(Integer cni) {
        this.cni = cni;
    }

    public String getVillePays() {
        return villePays;
    }

    public void setVillePays(String villePays) {
        this.villePays = villePays;
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
        hash += (idfournisseur != null ? idfournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.idfournisseur == null && other.idfournisseur != null) || (this.idfournisseur != null && !this.idfournisseur.equals(other.idfournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fournisseur[ idfournisseur=" + idfournisseur + " ]";
    }
    
}
