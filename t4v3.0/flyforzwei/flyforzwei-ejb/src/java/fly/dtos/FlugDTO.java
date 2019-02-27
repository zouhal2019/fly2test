

package fly.dtos;

import java.util.*;

public class FlugDTO
{
    private Date f_Date;
    private java.sql.Time f_dauer;
    private int f_BelegteSitze;
    private int linie_L_ID;
    private String flugzeug_F_Typ;

    public FlugDTO() {
    }

    public FlugDTO(Date f_Date, java.sql.Time f_dauer, int f_BelegteSitze, int linie_L_ID, String flugzeug_F_Typ) {
        this.f_Date = f_Date;
        this.f_dauer = f_dauer;
        this.f_BelegteSitze = f_BelegteSitze;
        this.linie_L_ID = linie_L_ID;
        this.flugzeug_F_Typ = flugzeug_F_Typ;
    }

    public Date getF_Date() {
        return f_Date;
    }

    public void setF_Date(Date f_Date) {
        this.f_Date = f_Date;
    }

    public java.sql.Time getF_dauer() {
        return f_dauer;
    }

    public void setF_dauer(java.sql.Time f_dauer) {
        this.f_dauer = f_dauer;
    }

    public int getF_BelegteSitze() {
        return f_BelegteSitze;
    }

    public void setF_BelegteSitze(int f_BelegteSitze) {
        this.f_BelegteSitze = f_BelegteSitze;
    }

    public int getLinie_L_ID() {
        return linie_L_ID;
    }

    public void setLinie_L_ID(int linie_L_ID) {
        this.linie_L_ID = linie_L_ID;
    }

    public String getFlugzeug_F_Typ() {
        return flugzeug_F_Typ;
    }

    public void setFlugzeug_F_Typ(String flugzeug_F_Typ) {
        this.flugzeug_F_Typ = flugzeug_F_Typ;
    }
    
    
    
    
    
}
