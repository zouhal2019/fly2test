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
@Table(name = "Land")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Land.findAll", query = "SELECT l FROM Land l")})
public class Land implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "l_name")
    private String lName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "land")
    private List<Stadt> stadtList;

    public Land() {
    }

    public Land(String lName) {
        this.lName = lName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    @XmlTransient
    public List<Stadt> getStadtList() {
        return stadtList;
    }

    public void setStadtList(List<Stadt> stadtList) {
        this.stadtList = stadtList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lName != null ? lName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Land)) {
            return false;
        }
        Land other = (Land) object;
        if ((this.lName == null && other.lName != null) || (this.lName != null && !this.lName.equals(other.lName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fly.entities.Land[ lName=" + lName + " ]";
    }
    
}
