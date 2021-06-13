package panier.classes;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author khali
 */
@Entity
@Table(name = "commande")
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numCom")
    private Integer numCom;
    @Column(name = "dateCde")
    @Temporal(TemporalType.DATE)
    private Date dateCde;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private List<Lignecommande> lignecommandeList;
    @JoinColumn(name = "numcli", referencedColumnName = "numCli")
    @ManyToOne
    private Client numcli;

    public Commande() {
    }

    public Commande(Integer numCom) {
        this.numCom = numCom;
    }

    public Integer getNumCom() {
        return numCom;
    }

    public void setNumCom(Integer numCom) {
        this.numCom = numCom;
    }

    public Date getDateCde() {
        return dateCde;
    }

    public void setDateCde(Date dateCde) {
        this.dateCde = dateCde;
    }

    public List<Lignecommande> getLignecommandeList() {
        return lignecommandeList;
    }

    public void setLignecommandeList(List<Lignecommande> lignecommandeList) {
        this.lignecommandeList = lignecommandeList;
    }

    public Client getNumcli() {
        return numcli;
    }

    public void setNumcli(Client numcli) {
        this.numcli = numcli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCom != null ? numCom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.numCom == null && other.numCom != null) || (this.numCom != null && !this.numCom.equals(other.numCom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Commande[ numCom=" + numCom + " ]";
    }
}
