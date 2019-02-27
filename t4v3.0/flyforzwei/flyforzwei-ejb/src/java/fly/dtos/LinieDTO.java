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
public class LinieDTO 
{
    private int l_ID; 
    private String abflug_FH;
    private String ankunft_FH;
    private String fluggesellschaft_FG_ID;

    public LinieDTO() {
    }

    public LinieDTO(int l_ID, String abflug_FH, String ankunft_FH, String fluggesellschaft_FG_ID) {
        this.l_ID = l_ID;
        this.abflug_FH = abflug_FH;
        this.ankunft_FH = ankunft_FH;
        this.fluggesellschaft_FG_ID = fluggesellschaft_FG_ID;
    }

    public int getL_ID() {
        return l_ID;
    }

    public void setL_ID(int l_ID) {
        this.l_ID = l_ID;
    }

    public String getAbflug_FH() {
        return abflug_FH;
    }

    public void setAbflug_FH(String abflug_FH) {
        this.abflug_FH = abflug_FH;
    }

    public String getAnkunft_FH() {
        return ankunft_FH;
    }

    public void setAnkunft_FH(String ankunft_FH) {
        this.ankunft_FH = ankunft_FH;
    }

    public String getFluggesellschaft_FG_ID() {
        return fluggesellschaft_FG_ID;
    }

    public void setFluggesellschaft_FG_ID(String fluggesellschaft_FG_ID) {
        this.fluggesellschaft_FG_ID = fluggesellschaft_FG_ID;
    }
    
    
}
