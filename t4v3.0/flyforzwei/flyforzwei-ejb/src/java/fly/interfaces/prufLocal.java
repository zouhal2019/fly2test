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
public interface prufLocal 
{
    boolean prufAnkFHLand(allDTODTO land) ;
    
    boolean prufAnkFHStadt(allDTODTO stadt);
    
    boolean prufAbfFHLand(allDTODTO land);
    
    boolean prufAbflFHStadt(allDTODTO stadt);
    
    boolean prufPassStadt(allDTODTO stadt);
    
    boolean prufPassLand(allDTODTO land) ;
    
    boolean prufFluggesselschaft(allDTODTO fgs);
    
    boolean prufAnkFlughafen(allDTODTO flh );
    
    boolean prufAbfFlughafen(allDTODTO flh );
    
     boolean prufHersteller(allDTODTO  flh );
     
      boolean prufFlugzeug(allDTODTO flz);
      
      boolean prufLinie(allDTODTO lin);
      
      boolean prufPassagier(allDTODTO pas);
      
      boolean prufFlug(allDTODTO flug);
      
       boolean prufBuchung(allDTODTO buch);
  
    
}
