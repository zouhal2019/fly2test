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
@Table(name = "Stadt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stadt.findAll", query = "SELECT s FROM Stadt s")})
public class Stadt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "s_name")
    private String sName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stadt")
    private List<Passagiere> passagiereList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stadt")
    private List<Flughafen> flughafenList;
    @JoinColumn(name = "Land_l_name", referencedColumnName = "l_name")
    @ManyToOne(optional = false)
    private Land land;

    public Stadt() {
    }

    public Stadt(String sName) {
        this.sName = sName;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    @XmlTransient
    public List<Passagiere> getPassagiereList() {
        return passagiereList;
    }

    public void setPassagiereList(List<Passagiere> passagiereList) {
        this.passagiereList = passagiereList;
    }

    @XmlTransient
    public List<Flughafen> getFlughafenList() {
        return flughafenList;
    }

    public void setFlughafenList(List<Flughafen> flughafenList) {
        this.flughafenList = flughafenList;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sName != null ? sName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stadt)) {
            return false;
        }
        Stadt other = (Stadt) object;
        if ((this.sName == null && other.sName != null) || (this.sName != null && !this.sName.equals(other.sName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fly.entities.Stadt[ sName=" + sName + " ]";
    }
    
}
