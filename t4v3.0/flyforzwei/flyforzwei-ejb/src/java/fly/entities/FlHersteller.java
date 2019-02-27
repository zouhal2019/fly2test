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
@Table(name = "Fl_Hersteller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FlHersteller.findAll", query = "SELECT f FROM FlHersteller f")})
public class FlHersteller implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "h_name")
    private String hName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flHersteller")
    private List<Flugzeug> flugzeugList;

    public FlHersteller() {
    }

    public FlHersteller(String hName) {
        this.hName = hName;
    }

    public String getHName() {
        return hName;
    }

    public void setHName(String hName) {
        this.hName = hName;
    }

    @XmlTransient
    public List<Flugzeug> getFlugzeugList() {
        return flugzeugList;
    }

    public void setFlugzeugList(List<Flugzeug> flugzeugList) {
        this.flugzeugList = flugzeugList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hName != null ? hName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FlHersteller)) {
            return false;
        }
        FlHersteller other = (FlHersteller) object;
        if ((this.hName == null && other.hName != null) || (this.hName != null && !this.hName.equals(other.hName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fly.entities.FlHersteller[ hName=" + hName + " ]";
    }
    
}
