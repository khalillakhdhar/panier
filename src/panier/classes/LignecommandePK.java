package panier.classes;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author khali
 */
@Embeddable
public class LignecommandePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "numCde")
    private int numCde;
    @Basic(optional = false)
    @Column(name = "numPro")
    private int numPro;

    public LignecommandePK() {
    }

    public LignecommandePK(int numCde, int numPro) {
        this.numCde = numCde;
        this.numPro = numPro;
    }

    public int getNumCde() {
        return numCde;
    }

    public void setNumCde(int numCde) {
        this.numCde = numCde;
    }

    public int getNumPro() {
        return numPro;
    }

    public void setNumPro(int numPro) {
        this.numPro = numPro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numCde;
        hash += (int) numPro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LignecommandePK)) {
            return false;
        }
        LignecommandePK other = (LignecommandePK) object;
        if (this.numCde != other.numCde) {
            return false;
        }
        if (this.numPro != other.numPro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.LignecommandePK[ numCde=" + numCde + ", numPro=" + numPro + " ]";
    }
}
