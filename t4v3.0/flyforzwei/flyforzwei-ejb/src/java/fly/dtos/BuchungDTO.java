/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.dtos;

import java.util.Date;

/**
 *
 * @author aernst
 */
public class BuchungDTO 
{
    private int b_Nummer;
    private Date b_Datum;
    private double b_Preis;
    private int passagier_PX_NR;
    private String fluggesellschaft_FG_ID;
    private Date flug_F_Date;
    private int flug_Linie_L_ID;

    public BuchungDTO() {
    }

    public BuchungDTO(int b_Nummer, Date b_Datum, double b_Preis, int passagier_PX_NR, String fluggesellschaft_FG_ID, Date flug_F_Date, int flug_Linie_L_ID) {
        this.b_Nummer = b_Nummer;
        this.b_Datum = b_Datum;
        this.b_Preis = b_Preis;
        this.passagier_PX_NR = passagier_PX_NR;
        this.fluggesellschaft_FG_ID = fluggesellschaft_FG_ID;
        this.flug_F_Date = flug_F_Date;
        this.flug_Linie_L_ID = flug_Linie_L_ID;
    }

    public int getB_Nummer() {
        return b_Nummer;
    }

    public void setB_Nummer(int b_Nummer) {
        this.b_Nummer = b_Nummer;
    }

    public Date getB_Datum() {
        return b_Datum;
    }

    public void setB_Datum(Date b_Datum) {
        this.b_Datum = b_Datum;
    }

    public double getB_Preis() {
        return b_Preis;
    }

    public void setB_Preis(double b_Preis) {
        this.b_Preis = b_Preis;
    }

    public int getPassagier_PX_NR() {
        return passagier_PX_NR;
    }

    public void setPassagier_PX_NR(int passagier_PX_NR) {
        this.passagier_PX_NR = passagier_PX_NR;
    }

    public String getFluggesellschaft_FG_ID() {
        return fluggesellschaft_FG_ID;
    }

    public void setFluggesellschaft_FG_ID(String fluggesellschaft_FG_ID) {
        this.fluggesellschaft_FG_ID = fluggesellschaft_FG_ID;
    }

    public Date getFlug_F_Date() {
        return flug_F_Date;
    }

    public void setFlug_F_Date(Date flug_F_Date) {
        this.flug_F_Date = flug_F_Date;
    }

    public int getFlug_Linie_L_ID() {
        return flug_Linie_L_ID;
    }

    public void setFlug_Linie_L_ID(int flug_Linie_L_ID) {
        this.flug_Linie_L_ID = flug_Linie_L_ID;
    }
    
    
    
    
}
