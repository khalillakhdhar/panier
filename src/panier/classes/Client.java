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
@Table(name = "client")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numCli")
    private Integer numCli;
    @Column(name = "nomCli")
    private String nomCli;
    @Column(name = "prenomCli")
    private String prenomCli;
    @Column(name = "adrCli")
    private String adrCli;
    @OneToMany(mappedBy = "numcli")
    private List<Commande> commandeList;

    public Client() {
    }

    public Client(Integer numCli) {
        this.numCli = numCli;
    }

    public Integer getNumCli() {
        return numCli;
    }

    public void setNumCli(Integer numCli) {
        this.numCli = numCli;
    }

    public String getNomCli() {
        return nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public String getPrenomCli() {
        return prenomCli;
    }

    public void setPrenomCli(String prenomCli) {
        this.prenomCli = prenomCli;
    }

    public String getAdrCli() {
        return adrCli;
    }

    public void setAdrCli(String adrCli) {
        this.adrCli = adrCli;
    }

    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCli != null ? numCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.numCli == null && other.numCli != null) || (this.numCli != null && !this.numCli.equals(other.numCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Client[ numCli=" + numCli + " ]";
    }
    
}