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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author aernst
 */
@Embeddable
public class BuchungPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_nummer")
    private int bNummer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_date")
    @Temporal(TemporalType.DATE)
    private Date fDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Linie_l_id")
    private int linielid;

    public BuchungPK() {
    }

    public BuchungPK(int bNummer, Date fDate, int linielid) {
        this.bNummer = bNummer;
        this.fDate = fDate;
        this.linielid = linielid;
    }

    public int getBNummer() {
        return bNummer;
    }

    public void setBNummer(int bNummer) {
        this.bNummer = bNummer;
    }

    public Date getFDate() {
        return fDate;
    }

    public void setFDate(Date fDate) {
        this.fDate = fDate;
    }

    public int getLinielid() {
        return linielid;
    }

    public void setLinielid(int linielid) {
        this.linielid = linielid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) bNummer;
        hash += (fDate != null ? fDate.hashCode() : 0);
        hash += (int) linielid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuchungPK)) {
            return false;
        }
        BuchungPK other = (BuchungPK) object;
        if (this.bNummer != other.bNummer) {
            return false;
        }
        if ((this.fDate == null && other.fDate != null) || (this.fDate != null && !this.fDate.equals(other.fDate))) {
            return false;
        }
        if (this.linielid != other.linielid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fly.entities.BuchungPK[ bNummer=" + bNummer + ", fDate=" + fDate + ", linielid=" + linielid + " ]";
    }
    
}
