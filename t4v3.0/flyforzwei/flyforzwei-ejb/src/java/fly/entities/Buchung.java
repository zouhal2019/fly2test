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
@Table(name = "Buchung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buchung.findAll", query = "SELECT b FROM Buchung b")})
public class Buchung implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BuchungPK buchungPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_datum")
    @Temporal(TemporalType.DATE)
    private Date bDatum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_preis")
    private long bPreis;
    @JoinColumn(name = "Fluggesellschaft_Fg_Id", referencedColumnName = "fg_id")
    @ManyToOne(optional = false)
    private Fluggesellschaft fluggesellschaft;
    @JoinColumn(name = "Passagiere_px_nr", referencedColumnName = "px_nr")
    @ManyToOne(optional = false)
    private Passagiere passagiere;

    public Buchung() {
    }

    public Buchung(BuchungPK buchungPK) {
        this.buchungPK = buchungPK;
    }

    public Buchung(BuchungPK buchungPK, Date bDatum, long bPreis) {
        this.buchungPK = buchungPK;
        this.bDatum = bDatum;
        this.bPreis = bPreis;
    }

    public Buchung(int bNummer, Date fDate, int linielid) {
        this.buchungPK = new BuchungPK(bNummer, fDate, linielid);
    }

    public BuchungPK getBuchungPK() {
        return buchungPK;
    }

    public void setBuchungPK(BuchungPK buchungPK) {
        this.buchungPK = buchungPK;
    }

    public Date getBDatum() {
        return bDatum;
    }

    public void setBDatum(Date bDatum) {
        this.bDatum = bDatum;
    }

    public long getBPreis() {
        return bPreis;
    }

    public void setBPreis(long bPreis) {
        this.bPreis = bPreis;
    }

    public Fluggesellschaft getFluggesellschaft() {
        return fluggesellschaft;
    }

    public void setFluggesellschaft(Fluggesellschaft fluggesellschaft) {
        this.fluggesellschaft = fluggesellschaft;
    }

    public Passagiere getPassagiere() {
        return passagiere;
    }

    public void setPassagiere(Passagiere passagiere) {
        this.passagiere = passagiere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buchungPK != null ? buchungPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buchung)) {
            return false;
        }
        Buchung other = (Buchung) object;
        if ((this.buchungPK == null && other.buchungPK != null) || (this.buchungPK != null && !this.buchungPK.equals(other.buchungPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fly.entities.Buchung[ buchungPK=" + buchungPK + " ]";
    }
    
}
