package panier.classes;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

/**
 *
 * @author khali
 */
@Entity
@Table(name = "produit")
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p")})
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numPro")
    private Integer numPro;
    @Column(name = "nomPro")
    private String nomPro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "puProd")
    private int puProd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private List<Lignecommande> lignecommandeList;
    @JoinColumn(name = "famPro", referencedColumnName = "numFam")
    @ManyToOne
    private Famille famPro;

    public Produit() {
    }

    public Produit(Integer numPro) {
        this.numPro = numPro;
    }

    public Integer getNumPro() {
        return numPro;
    }

    public void setNumPro(Integer numPro) {
        this.numPro = numPro;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public int getPuProd() {
        return puProd;
    }

    public void setPuProd(int puProd) {
        this.puProd = puProd;
    }

    public List<Lignecommande> getLignecommandeList() {
        return lignecommandeList;
    }

    public void setLignecommandeList(List<Lignecommande> lignecommandeList) {
        this.lignecommandeList = lignecommandeList;
    }

    public Famille getFamPro() {
        return famPro;
    }

    public void setFamPro(Famille famPro) {
        this.famPro = famPro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numPro != null ? numPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.numPro == null && other.numPro != null) || (this.numPro != null && !this.numPro.equals(other.numPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Produit[ numPro=" + numPro + " ]";
    }
    
  public Produit(Integer numPro, String nomPro, int puProd, Famille famPro) {
		this.numPro = numPro;
		this.nomPro = nomPro;
		this.puProd = puProd;
		this.famPro = famPro;
	}

public void addproduit()
  {
	  try {
	    	// TODO add your handling code here:
	    	Connexion c= new Connexion();
	    	java.sql.PreparedStatement statement = c.conn.prepareStatement("INSERT INTO `produit`(`numPro`, `nomPro`, `puProd`, `famPro`) VALUES ('"+this.getNumPro()+"','"+ this.getNomPro()+"','"+this.getPuProd()+"','"+this.getFamPro().getNumFam()+"')");
	    	statement.executeUpdate();

	    	} catch (SQLException ex) {
	    		System.out.println(ex);
	    	 }
  }
	 public  ResultSet aff() throws SQLException
	  {
	  Connexion c=new Connexion();
	  PreparedStatement pst;
	  pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM produit");
	  pst.executeQuery();
	  ResultSet rs = (ResultSet) pst.executeQuery();
	  return rs;
	}
  }
    
