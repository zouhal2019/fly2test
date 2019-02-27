/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.interfaces;

import fly.dtos.*;
import javax.ejb.Local;

/**
 *
 * @author aernst
 */
@Local
public interface insertenLocal 
{
    void insertLand( allDTODTO all);
    
     void insertStadt(String dateiname, allDTODTO all);
     
     void insertFlughafen(String dateiname, allDTODTO all);
     
     void insertFluggesellschaft(String dateiname, allDTODTO all);
     
     void insertLinie(String dateiname, allDTODTO all);
     
     void insertPassagiere(String dateiname, allDTODTO all);
     
     void insertHersteller(String dateiname, allDTODTO all);
     
     void insertFlugzeug(String dateiname, allDTODTO all);
     
     void insertFlug(String dateiname, allDTODTO all);
     
     void insertBuchung(String dateiname, allDTODTO all);
    
}
