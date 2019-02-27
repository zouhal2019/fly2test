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
@Table(name = "Passagiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passagiere.findAll", query = "SELECT p FROM Passagiere p")})
public class Passagiere implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "px_nr")
    private Integer pxNr;
    @Size(max = 10)
    @Column(name = "px_anrede")
    private String pxAnrede;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "px_name")
    private String pxName;
    @Size(max = 45)
    @Column(name = "px_strasse")
    private String pxStrasse;
    @Size(max = 15)
    @Column(name = "px_plz")
    private String pxPlz;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passagiere")
    private List<Buchung> buchungList;
    @JoinColumn(name = "Stadt_s_name", referencedColumnName = "s_name")
    @ManyToOne(optional = false)
    private Stadt stadt;

    public Passagiere() {
    }

    public Passagiere(Integer pxNr) {
        this.pxNr = pxNr;
    }

    public Passagiere(Integer pxNr, String pxName) {
        this.pxNr = pxNr;
        this.pxName = pxName;
    }

    public Integer getPxNr() {
        return pxNr;
    }

    public void setPxNr(Integer pxNr) {
        this.pxNr = pxNr;
    }

    public String getPxAnrede() {
        return pxAnrede;
    }

    public void setPxAnrede(String pxAnrede) {
        this.pxAnrede = pxAnrede;
    }

    public String getPxName() {
        return pxName;
    }

    public void setPxName(String pxName) {
        this.pxName = pxName;
    }

    public String getPxStrasse() {
        return pxStrasse;
    }

    public void setPxStrasse(String pxStrasse) {
        this.pxStrasse = pxStrasse;
    }

    public String getPxPlz() {
        return pxPlz;
    }

    public void setPxPlz(String pxPlz) {
        this.pxPlz = pxPlz;
    }

    @XmlTransient
    public List<Buchung> getBuchungList() {
        return buchungList;
    }

    public void setBuchungList(List<Buchung> buchungList) {
        this.buchungList = buchungList;
    }

    public Stadt getStadt() {
        return stadt;
    }

    public void setStadt(Stadt stadt) {
        this.stadt = stadt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pxNr != null ? pxNr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passagiere)) {
            return false;
        }
        Passagiere other = (Passagiere) object;
        if ((this.pxNr == null && other.pxNr != null) || (this.pxNr != null && !this.pxNr.equals(other.pxNr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fly.entities.Passagiere[ pxNr=" + pxNr + " ]";
    }
    
}
