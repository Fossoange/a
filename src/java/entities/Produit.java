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
import javax.persistence.Lob;
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
@Table(name = "produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p")
    , @NamedQuery(name = "Produit.findByIdproduit", query = "SELECT p FROM Produit p WHERE p.idproduit = :idproduit")
    , @NamedQuery(name = "Produit.findByDesignation", query = "SELECT p FROM Produit p WHERE p.designation = :designation")
    , @NamedQuery(name = "Produit.findByPrixunitaire", query = "SELECT p FROM Produit p WHERE p.prixunitaire = :prixunitaire")
    , @NamedQuery(name = "Produit.findByCategorie", query = "SELECT p FROM Produit p WHERE p.categorie = :categorie")
    , @NamedQuery(name = "Produit.findByFamille", query = "SELECT p FROM Produit p WHERE p.famille = :famille")
    , @NamedQuery(name = "Produit.findBySousFamille", query = "SELECT p FROM Produit p WHERE p.sousFamille = :sousFamille")
    , @NamedQuery(name = "Produit.findByCode", query = "SELECT p FROM Produit p WHERE p.code = :code")
    , @NamedQuery(name = "Produit.findByAnnuler", query = "SELECT p FROM Produit p WHERE p.annuler = :annuler")
    , @NamedQuery(name = "Produit.findBylabelImage", query = "SELECT p FROM Produit p WHERE p.labelImage = :labelImage")})
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPRODUIT")
    private Integer idproduit;
    @Size(max = 128)
    @Column(name = "DESIGNATION")
    private String designation;
    @Column(name = "PRIXUNITAIRE")
    private Integer prixunitaire;
    @Size(max = 128)
    @Column(name = "CATEGORIE")
    private String categorie;
    @Size(max = 128)
    @Column(name = "FAMILLE")
    private String famille;
    @Size(max = 128)
    @Column(name = "SOUS_FAMILLE")
    private String sousFamille;
    @Lob
    @Size(max = 65535)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CODE")
    private Integer code;
    @Size(max = 32)
    @Column(name = "ANNULER")
    private String annuler;

    @Size(max = 32)
    @Column(name = "labelImage")
    private String labelImage;
    public Produit() {
    }

    public Produit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public Integer getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public String getLabelImage() {
        return labelImage;
    }

    public void setLabelImage(String labelImage) {
        this.labelImage = labelImage;
    }

    
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(Integer prixunitaire) {
        this.prixunitaire = prixunitaire;
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

    public String getSousFamille() {
        return sousFamille;
    }

    public void setSousFamille(String sousFamille) {
        this.sousFamille = sousFamille;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
        hash += (idproduit != null ? idproduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.idproduit == null && other.idproduit != null) || (this.idproduit != null && !this.idproduit.equals(other.idproduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Produit[ idproduit=" + idproduit + " ]";
    }
    
}
