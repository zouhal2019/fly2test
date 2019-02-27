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
public class FluggesellschaftDTO
{
    private String fg_ID;
    private String fg_Name;

    public FluggesellschaftDTO() {
    }

    public FluggesellschaftDTO(String fg_ID, String fg_Name) {
        this.fg_ID = fg_ID;
        this.fg_Name = fg_Name;
    }

    public String getFg_ID() {
        return fg_ID;
    }

    public void setFg_ID(String fg_ID) {
        this.fg_ID = fg_ID;
    }

    public String getFg_Name() {
        return fg_Name;
    }

    public void setFg_Name(String fg_Name) {
        this.fg_Name = fg_Name;
    }
     
    
    
    
}
