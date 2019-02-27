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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aernst
 */
@Entity
@Table(name = "Linie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linie.findAll", query = "SELECT l FROM Linie l")})
public class Linie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "l_id")
    private Integer lId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "linie")
    private List<Flug> flugList;
    @JoinColumn(name = "Fluggesellschaft_Fg_Id", referencedColumnName = "fg_id")
    @ManyToOne(optional = false)
    private Fluggesellschaft fluggesellschaft;
    @JoinColumn(name = "abflug_flh", referencedColumnName = "flh_name")
    @ManyToOne(optional = false)
    private Flughafen flughafen;
    @JoinColumn(name = "ankuft_flh", referencedColumnName = "flh_name")
    @ManyToOne(optional = false)
    private Flughafen flughafen1;

    public Linie() {
    }

    public Linie(Integer lId) {
        this.lId = lId;
    }

    public Integer getLId() {
        return lId;
    }

    public void setLId(Integer lId) {
        this.lId = lId;
    }

    @XmlTransient
    public List<Flug> getFlugList() {
        return flugList;
    }

    public void setFlugList(List<Flug> flugList) {
        this.flugList = flugList;
    }

    public Fluggesellschaft getFluggesellschaft() {
        return fluggesellschaft;
    }

    public void setFluggesellschaft(Fluggesellschaft fluggesellschaft) {
        this.fluggesellschaft = fluggesellschaft;
    }

    public Flughafen getFlughafen() {
        return flughafen;
    }

    public void setFlughafen(Flughafen flughafen) {
        this.flughafen = flughafen;
    }

    public Flughafen getFlughafen1() {
        return flughafen1;
    }

    public void setFlughafen1(Flughafen flughafen1) {
        this.flughafen1 = flughafen1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lId != null ? lId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linie)) {
            return false;
        }
        Linie other = (Linie) object;
        if ((this.lId == null && other.lId != null) || (this.lId != null && !this.lId.equals(other.lId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fly.entities.Linie[ lId=" + lId + " ]";
    }
    
}
