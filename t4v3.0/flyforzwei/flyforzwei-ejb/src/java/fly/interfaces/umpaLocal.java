/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.interfaces;

import fly.dtos.*;
import java.io.File;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aernst
 */
@Local
public interface umpaLocal {
    
//    List<allDTODTO> Csvlesen(File f);
    
   List<allDTODTO> xls(String fileName);
    
}
