package panier.classes;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Client(Integer numCli, String nomCli, String prenomCli, String adrCli, List<Commande> commandeList) {
		this.numCli = numCli;
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.adrCli = adrCli;
		this.commandeList = commandeList;
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
    public void addClient()
    {
    	try {
    		// TODO add your handling code here:
    		Connexion c= new Connexion();
    		java.sql.PreparedStatement statement = c.conn.prepareStatement("INSERT INTO `client`(`numCli`, `nomCli`, `prenomCli`, `adrCli`) VALUES ('"+this.getNumCli()+"','"+this.getNomCli() +"','"+this.getPrenomCli() +"','"+this.getAdrCli() +"')");
    		statement.executeUpdate();
    		} catch (SQLException ex) {
    	
    		}
    	
    }
    public  ResultSet auth() throws SQLException
	  {
	  Connexion c=new Connexion();
	  PreparedStatement pst;
	  pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM client WHERE numCli='"+this.getNumCli()+"'");
	  pst.executeQuery();
	  ResultSet rs = (ResultSet) pst.executeQuery();
	  if(rs.next())
	  return rs;
	  else return null;
	}
}