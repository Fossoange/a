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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FOSSO
 */
@Entity
@Table(name = "commande_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommandeClient.findAll", query = "SELECT c FROM CommandeClient c")
    , @NamedQuery(name = "CommandeClient.findByIdcommande", query = "SELECT c FROM CommandeClient c WHERE c.idcommande = :idcommande")
    , @NamedQuery(name = "CommandeClient.findByIdproduit", query = "SELECT c FROM CommandeClient c WHERE c.idproduit = :idproduit")
    , @NamedQuery(name = "CommandeClient.findByDatecommande", query = "SELECT c FROM CommandeClient c WHERE c.datecommande = :datecommande")
    , @NamedQuery(name = "CommandeClient.findByMontant", query = "SELECT c FROM CommandeClient c WHERE c.montant = :montant")
    , @NamedQuery(name = "CommandeClient.findByAnnuler", query = "SELECT c FROM CommandeClient c WHERE c.annuler = :annuler")})
public class CommandeClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOMMANDE")
    private Long idcommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproduit")
    private int idproduit;
    @Column(name = "DATECOMMANDE")
    @Temporal(TemporalType.DATE)
    private Date datecommande;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTANT")
    private Double montant;
    @Size(max = 32)
    @Column(name = "ANNULER")
    private String annuler;
    @JoinColumn(name = "IDCLIENT", referencedColumnName = "IDCLIENT")
    @ManyToOne
    private Client idclient;

    public CommandeClient() {
    }

    public CommandeClient(Long idcommande) {
        this.idcommande = idcommande;
    }

    public CommandeClient(Long idcommande, int idproduit) {
        this.idcommande = idcommande;
        this.idproduit = idproduit;
    }

    public Long getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Long idcommande) {
        this.idcommande = idcommande;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getAnnuler() {
        return annuler;
    }

    public void setAnnuler(String annuler) {
        this.annuler = annuler;
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
        hash += (idcommande != null ? idcommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandeClient)) {
            return false;
        }
        CommandeClient other = (CommandeClient) object;
        if ((this.idcommande == null && other.idcommande != null) || (this.idcommande != null && !this.idcommande.equals(other.idcommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CommandeClient[ idcommande=" + idcommande + " ]";
    }
    
}
