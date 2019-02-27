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
public class FlugPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Linie_l_id")
    private int linielid;

    public FlugPK() {
    }

    public FlugPK(Date fDate, int linielid) {
        this.fDate = fDate;
        this.linielid = linielid;
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
        hash += (fDate != null ? fDate.hashCode() : 0);
        hash += (int) linielid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FlugPK)) {
            return false;
        }
        FlugPK other = (FlugPK) object;
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
        return "fly.entities.FlugPK[ fDate=" + fDate + ", linielid=" + linielid + " ]";
    }
    
}
