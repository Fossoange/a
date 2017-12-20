/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FOSSO
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByIduser", query = "SELECT u FROM Users u WHERE u.iduser = :iduser")
    , @NamedQuery(name = "Users.findByNom", query = "SELECT u FROM Users u WHERE u.nom = :nom")
    , @NamedQuery(name = "Users.findByPrenom", query = "SELECT u FROM Users u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "Users.findByMatricule", query = "SELECT u FROM Users u WHERE u.matricule = :matricule")
    , @NamedQuery(name = "Users.findByTelephone", query = "SELECT u FROM Users u WHERE u.telephone = :telephone")
    , @NamedQuery(name = "Users.findByFonction", query = "SELECT u FROM Users u WHERE u.fonction = :fonction")
    , @NamedQuery(name = "Users.findByAnnuler", query = "SELECT u FROM Users u WHERE u.annuler = :annuler")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUSER")
    private Long iduser;
    @Size(max = 32)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 32)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 128)
    @Column(name = "MATRICULE")
    private String matricule;
    @Column(name = "TELEPHONE")
    private Integer telephone;
    @Size(max = 128)
    @Column(name = "FONCTION")
    private String fonction;
    @Size(max = 32)
    @Column(name = "ANNULER")
    private String annuler;
    @OneToMany(mappedBy = "iduser")
    private List<Vente> venteList;

    public Users() {
    }

    public Users(Long iduser) {
        this.iduser = iduser;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
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

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getAnnuler() {
        return annuler;
    }

    public void setAnnuler(String annuler) {
        this.annuler = annuler;
    }

    @XmlTransient
    public List<Vente> getVenteList() {
        return venteList;
    }

    public void setVenteList(List<Vente> venteList) {
        this.venteList = venteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Users[ iduser=" + iduser + " ]";
    }
    
}
