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
@Table(name = "Flughafen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flughafen.findAll", query = "SELECT f FROM Flughafen f")})
public class Flughafen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "flh_name")
    private String flhName;
    @JoinColumn(name = "Stadt_s_name", referencedColumnName = "s_name")
    @ManyToOne(optional = false)
    private Stadt stadt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flughafen")
    private List<Linie> linieList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flughafen1")
    private List<Linie> linieList1;

    public Flughafen() {
    }

    public Flughafen(String flhName) {
        this.flhName = flhName;
    }

    public String getFlhName() {
        return flhName;
    }

    public void setFlhName(String flhName) {
        this.flhName = flhName;
    }

    public Stadt getStadt() {
        return stadt;
    }

    public void setStadt(Stadt stadt) {
        this.stadt = stadt;
    }

    @XmlTransient
    public List<Linie> getLinieList() {
        return linieList;
    }

    public void setLinieList(List<Linie> linieList) {
        this.linieList = linieList;
    }

    @XmlTransient
    public List<Linie> getLinieList1() {
        return linieList1;
    }

    public void setLinieList1(List<Linie> linieList1) {
        this.linieList1 = linieList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flhName != null ? flhName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flughafen)) {
            return false;
        }
        Flughafen other = (Flughafen) object;
        if ((this.flhName == null && other.flhName != null) || (this.flhName != null && !this.flhName.equals(other.flhName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fly.entities.Flughafen[ flhName=" + flhName + " ]";
    }
    
}
