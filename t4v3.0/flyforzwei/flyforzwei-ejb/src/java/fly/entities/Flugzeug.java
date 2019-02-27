/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aernst
 */
@Entity
@Table(name = "Flugzeug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flugzeug.findAll", query = "SELECT f FROM Flugzeug f")})
public class Flugzeug implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "f_type")
    private String fType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_sitzegesamt")
    private int fSitzegesamt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flugzeug")
    private List<Flug> flugList;
    @JoinColumn(name = "Fl_Hersteller_h_name", referencedColumnName = "h_name")
    @ManyToOne(optional = false)
    private FlHersteller flHersteller;

    public Flugzeug() {
    }

    public Flugzeug(String fType) {
        this.fType = fType;
    }

    public Flugzeug(String fType, int fSitzegesamt) {
        this.fType = fType;
        this.fSitzegesamt = fSitzegesamt;
    }

    public String getFType() {
        return fType;
    }

    public void setFType(String fType) {
        this.fType = fType;
    }

    public int getFSitzegesamt() {
        return fSitzegesamt;
    }

    public void setFSitzegesamt(int fSitzegesamt) {
        this.fSitzegesamt = fSitzegesamt;
    }

    @XmlTransient
    public List<Flug> getFlugList() {
        return flugList;
    }

    public void setFlugList(List<Flug> flugList) {
        this.flugList = flugList;
    }

    public FlHersteller getFlHersteller() {
        return flHersteller;
    }

    public void setFlHersteller(FlHersteller flHersteller) {
        this.flHersteller = flHersteller;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fType != null ? fType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flugzeug)) {
            return false;
        }
        Flugzeug other = (Flugzeug) object;
        if ((this.fType == null && other.fType != null) || (this.fType != null && !this.fType.equals(other.fType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fly.entities.Flugzeug[ fType=" + fType + " ]";
    }
    
}
