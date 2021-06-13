package panier.classes;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author khali
 */
@Entity
@Table(name = "famille")
@NamedQueries({
    @NamedQuery(name = "Famille.findAll", query = "SELECT f FROM Famille f")})
public class Famille implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numFam")
    private Integer numFam;
    @Column(name = "nomFam")
    private String nomFam;
    @OneToMany(mappedBy = "famPro")
    private List<Produit> produitList;

    public Famille() {
    }

    public Famille(Integer numFam) {
        this.numFam = numFam;
    }

    public Integer getNumFam() {
        return numFam;
    }

    public void setNumFam(Integer numFam) {
        this.numFam = numFam;
    }

    public String getNomFam() {
        return nomFam;
    }

    public void setNomFam(String nomFam) {
        this.nomFam = nomFam;
    }

    public List<Produit> getProduitList() {
        return produitList;
    }

    public void setProduitList(List<Produit> produitList) {
        this.produitList = produitList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numFam != null ? numFam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Famille)) {
            return false;
        }
        Famille other = (Famille) object;
        if ((this.numFam == null && other.numFam != null) || (this.numFam != null && !this.numFam.equals(other.numFam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Famille[ numFam=" + numFam + " ]";
    }
}
