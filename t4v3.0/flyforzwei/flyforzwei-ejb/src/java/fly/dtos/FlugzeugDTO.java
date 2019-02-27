/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.dtos;

/**
 *
 * @author aernst
 */
public class FlugzeugDTO 
{
    private String f_Typ;
    private int f_SitzeGesamt;
    private String hersteller_H_Name;

    public FlugzeugDTO() {
    }

    public FlugzeugDTO(String f_Typ, int f_SitzeGesamt, String hersteller_H_Name) {
        this.f_Typ = f_Typ;
        this.f_SitzeGesamt = f_SitzeGesamt;
        this.hersteller_H_Name = hersteller_H_Name;
    }

    public String getF_Typ() {
        return f_Typ;
    }

    public void setF_Typ(String f_Typ) {
        this.f_Typ = f_Typ;
    }

    public int getF_SitzeGesamt() {
        return f_SitzeGesamt;
    }

    public void setF_SitzeGesamt(int f_SitzeGesamt) {
        this.f_SitzeGesamt = f_SitzeGesamt;
    }

    public String getHersteller_H_Name() {
        return hersteller_H_Name;
    }

    public void setHersteller_H_Name(String hersteller_H_Name) {
        this.hersteller_H_Name = hersteller_H_Name;
    }
    
    
    
}
