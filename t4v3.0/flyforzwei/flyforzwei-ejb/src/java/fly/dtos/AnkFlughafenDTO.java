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
public class AnkFlughafenDTO 
{
    private String flh_Name;
    private String stadt_S_name;
    private String flh_AnkLand;

    public AnkFlughafenDTO(String flh_Name, String stadt_S_name, String flh_AnkLand) {
        this.flh_Name = flh_Name;
        this.stadt_S_name = stadt_S_name;
        this.flh_AnkLand = flh_AnkLand;
    }

   
    
    public AnkFlughafenDTO() {
    }

    public String getFlh_AnkLand() {
        return flh_AnkLand;
    }

    public void setFlh_AnkLand(String flh_AnkLand) {
        this.flh_AnkLand = flh_AnkLand;
    }

   
    

    public String getFlh_Name() {
        return flh_Name;
    }

    public void setFlh_Name(String flh_Name) {
        this.flh_Name = flh_Name;
    }

    public String getStadt_S_name() {
        return stadt_S_name;
    }

    public void setStadt_S_name(String stadt_S_name) {
        this.stadt_S_name = stadt_S_name;
    }
    
    
    
}
