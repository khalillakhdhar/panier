package panier.classes;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author khali
 */
@Entity
@Table(name = "lignecommande")
@NamedQueries({
    @NamedQuery(name = "Lignecommande.findAll", query = "SELECT l FROM Lignecommande l")})
public class Lignecommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LignecommandePK lignecommandePK;
    @Column(name = "qteCde")
    private Integer qteCde;
    @JoinColumn(name = "numCde", referencedColumnName = "numCom", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;
    @JoinColumn(name = "numPro", referencedColumnName = "numPro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;

    public Lignecommande() {
    }

    public Lignecommande(LignecommandePK lignecommandePK) {
        this.lignecommandePK = lignecommandePK;
    }

    public Lignecommande(int numCde, int numPro) {
        this.lignecommandePK = new LignecommandePK(numCde, numPro);
    }

    public LignecommandePK getLignecommandePK() {
        return lignecommandePK;
    }

    public void setLignecommandePK(LignecommandePK lignecommandePK) {
        this.lignecommandePK = lignecommandePK;
    }

    public Integer getQteCde() {
        return qteCde;
    }

    public void setQteCde(Integer qteCde) {
        this.qteCde = qteCde;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lignecommandePK != null ? lignecommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lignecommande)) {
            return false;
        }
        Lignecommande other = (Lignecommande) object;
        if ((this.lignecommandePK == null && other.lignecommandePK != null) || (this.lignecommandePK != null && !this.lignecommandePK.equals(other.lignecommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Lignecommande[ lignecommandePK=" + lignecommandePK + " ]";
    }
}
