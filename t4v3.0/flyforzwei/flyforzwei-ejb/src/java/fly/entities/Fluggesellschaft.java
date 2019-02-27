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
@Table(name = "Fluggesellschaft")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fluggesellschaft.findAll", query = "SELECT f FROM Fluggesellschaft f")})
public class Fluggesellschaft implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "fg_id")
    private String fgId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "fg_name")
    private String fgName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fluggesellschaft")
    private List<Buchung> buchungList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fluggesellschaft")
    private List<Linie> linieList;

    public Fluggesellschaft() {
    }

    public Fluggesellschaft(String fgId) {
        this.fgId = fgId;
    }

    public Fluggesellschaft(String fgId, String fgName) {
        this.fgId = fgId;
        this.fgName = fgName;
    }

    public String getFgId() {
        return fgId;
    }

    public void setFgId(String fgId) {
        this.fgId = fgId;
    }

    public String getFgName() {
        return fgName;
    }

    public void setFgName(String fgName) {
        this.fgName = fgName;
    }

    @XmlTransient
    public List<Buchung> getBuchungList() {
        return buchungList;
    }

    public void setBuchungList(List<Buchung> buchungList) {
        this.buchungList = buchungList;
    }

    @XmlTransient
    public List<Linie> getLinieList() {
        return linieList;
    }

    public void setLinieList(List<Linie> linieList) {
        this.linieList = linieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fgId != null ? fgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fluggesellschaft)) {
            return false;
        }
        Fluggesellschaft other = (Fluggesellschaft) object;
        if ((this.fgId == null && other.fgId != null) || (this.fgId != null && !this.fgId.equals(other.fgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fly.entities.Fluggesellschaft[ fgId=" + fgId + " ]";
    }
    
}
