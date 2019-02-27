/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aernst
 */
@Entity
@Table(name = "Flug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flug.findAll", query = "SELECT f FROM Flug f")})
public class Flug implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FlugPK flugPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_dauer")
    @Temporal(TemporalType.TIME)
    private Date fDauer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_belegtesitze")
    private int fBelegtesitze;
    @JoinColumn(name = "Flugzeug_f_type", referencedColumnName = "f_type")
    @ManyToOne(optional = false)
    private Flugzeug flugzeug;
    @JoinColumn(name = "Linie_l_id", referencedColumnName = "l_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Linie linie;

    public Flug() {
    }

    public Flug(FlugPK flugPK) {
        this.flugPK = flugPK;
    }

    public Flug(FlugPK flugPK, Date fDauer, int fBelegtesitze) {
        this.flugPK = flugPK;
        this.fDauer = fDauer;
        this.fBelegtesitze = fBelegtesitze;
    }

    public Flug(Date fDate, int linielid) {
        this.flugPK = new FlugPK(fDate, linielid);
    }

    public FlugPK getFlugPK() {
        return flugPK;
    }

    public void setFlugPK(FlugPK flugPK) {
        this.flugPK = flugPK;
    }

    public Date getFDauer() {
        return fDauer;
    }

    public void setFDauer(Date fDauer) {
        this.fDauer = fDauer;
    }

    public int getFBelegtesitze() {
        return fBelegtesitze;
    }

    public void setFBelegtesitze(int fBelegtesitze) {
        this.fBelegtesitze = fBelegtesitze;
    }

    public Flugzeug getFlugzeug() {
        return flugzeug;
    }

    public void setFlugzeug(Flugzeug flugzeug) {
        this.flugzeug = flugzeug;
    }

    public Linie getLinie() {
        return linie;
    }

    public void setLinie(Linie linie) {
        this.linie = linie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flugPK != null ? flugPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flug)) {
            return false;
        }
        Flug other = (Flug) object;
        if ((this.flugPK == null && other.flugPK != null) || (this.flugPK != null && !this.flugPK.equals(other.flugPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fly.entities.Flug[ flugPK=" + flugPK + " ]";
    }
    
}
