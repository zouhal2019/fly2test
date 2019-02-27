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
public class PassagierDTO
{
    private int px_NR;
    private String px_Anrede;
    private String px_Name;
    private String px_Strasse;
    private String px_PLZ;
    private String stadt_S_Name;
    private String px_Land;

    public PassagierDTO() {
    }

    public PassagierDTO(int px_NR, String px_Anrede, String px_Name, String px_Strasse, String px_PLZ, String stadt_S_Name, String px_Land) {
        this.px_NR = px_NR;
        this.px_Anrede = px_Anrede;
        this.px_Name = px_Name;
        this.px_Strasse = px_Strasse;
        this.px_PLZ = px_PLZ;
        this.stadt_S_Name = stadt_S_Name;
        this.px_Land = px_Land;
    }

    public String getPx_Land() {
        return px_Land;
    }

    public void setPx_Land(String px_Land) {
        this.px_Land = px_Land;
    }

    

    public int getPx_NR() {
        return px_NR;
    }

    public void setPx_NR(int px_NR) {
        this.px_NR = px_NR;
    }

    public String getPx_Anrede() {
        return px_Anrede;
    }

    public void setPx_Anrede(String px_Anrede) {
        this.px_Anrede = px_Anrede;
    }

    public String getPx_Name() {
        return px_Name;
    }

    public void setPx_Name(String px_Name) {
        this.px_Name = px_Name;
    }

    public String getPx_Strasse() {
        return px_Strasse;
    }

    public void setPx_Strasse(String px_Strasse) {
        this.px_Strasse = px_Strasse;
    }

    public String getPx_PLZ() {
        return px_PLZ;
    }

    public void setPx_PLZ(String px_PLZ) {
        this.px_PLZ = px_PLZ;
    }

    public String getStadt_S_Name() {
        return stadt_S_Name;
    }

    public void setStadt_S_Name(String stadt_S_Name) {
        this.stadt_S_Name = stadt_S_Name;
    }
    
    
    
}
