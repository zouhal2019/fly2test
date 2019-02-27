/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.beans;

import fly.interfaces.umpaLocal;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.ejb.Stateless;
import fly.dtos.*;
import java.text.*;
import java.util.logging.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;


@Stateless
public class umpa implements umpaLocal {


    @Override
    public List<allDTODTO> xls(String fileName) {
        File inputFile = new File("C:\\new\\002" + fileName);
        int re = 2;
        int spalte;
        List<allDTODTO> flugdaten = new ArrayList();
        try {

            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(inputFile));

            HSSFSheet sheet = workbook.getSheetAt(0);

            while (re < sheet.getLastRowNum() - 1) {
                   allDTODTO csvDTO = new allDTODTO();
                    Time timeValue;
                    FluggesellschaftDTO flge = new FluggesellschaftDTO();
                    Fl_HerstellerDTO flh = new Fl_HerstellerDTO();
                    FlugzeugDTO flgz = new FlugzeugDTO();
                    LinieDTO lin = new LinieDTO();
                    AbfFlughafenDTO abfh = new AbfFlughafenDTO();
                    AnkFlughafenDTO akfh = new AnkFlughafenDTO();
                    PassagierDTO pas = new PassagierDTO();
                    FlugDTO flug = new FlugDTO();
                    BuchungDTO buch = new BuchungDTO();
                HSSFRow reihe = sheet.getRow(re);
                spalte=0;
                
                while (spalte < reihe.getLastCellNum()) {
                    
                    HSSFCell cell = reihe.getCell(spalte,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
              
                    double d=0;
                    String dd="";
                    
                    switch (spalte) {
                        case 0: //FG_ID
                            
                            flge.setFg_ID(cell.getStringCellValue());
                            break;

                        case 1://FG_Name
                          
                            flge.setFg_Name( cell.getStringCellValue());
                            break;
                        case 2:
                            //leer
                            break;
                        case 3: //Lin_ID
                             
                            
                            lin.setL_ID((int)cell.getNumericCellValue() );
                            break;
                        case 4://abf_flughafen
                            
                            lin.setAbflug_FH( cell.getStringCellValue());
                            abfh.setFlh_Name( cell.getStringCellValue());
                            break;
                        case 5://abf_land
                             
                            abfh.setFlh_AbfLand(cell.getStringCellValue());
                            break;
                        case 6://abf_stadt
                             
                            abfh.setStadt_S_name(cell.getStringCellValue());
                            break;
                        case 7://ank_flughafen
                            akfh.setFlh_Name(cell.getStringCellValue());
                            lin.setAnkunft_FH(cell.getStringCellValue());
                            break;
                        case 8://ank_land
                             
                            akfh.setFlh_AnkLand(cell.getStringCellValue());
                            break;
                        case 9://ank_stadt
                             
                            akfh.setStadt_S_name(cell.getStringCellValue());
                            break;
                        case 10://flugdauer
                            String t = cell.getStringCellValue();
                            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                            timeValue = new java.sql.Time(timeFormat.parse(t).getTime());
                            flug.setF_dauer(timeValue);
                            break;
                        case 11://flugdate
                            
                            flug.setF_Date( cell.getDateCellValue());
                            break;
                        case 12://flugpreis
                             
                            buch.setB_Preis(cell.getNumericCellValue());
                            break;
                        case 13://fl_typ
                            
                            flgz.setF_Typ( cell.getStringCellValue());
                            break;
                        case 14://fl_hersteller
                            flh.setFh_Name(cell.getStringCellValue());
                            break;
                        case 15://fl_sitze_belegt
                             
                            flug.setF_BelegteSitze((int) cell.getNumericCellValue());
                            break;
                        case 16://fl_sitze_gesamt
                             
                            flgz.setF_SitzeGesamt((int)cell.getNumericCellValue() );
                            break;
                        case 17://buchung_nr
                             
                            buch.setB_Nummer((int)cell.getNumericCellValue() );
                            break;
                        case 18://buchung_date
                            
                            buch.setB_Datum( cell.getDateCellValue());
                            break;
                        case 19://pas_nr
                            
                            pas.setPx_NR((int)cell.getNumericCellValue());
                            break;
                        case 20://pas_anrede
                            pas.setPx_Anrede(cell.getStringCellValue());
                            break;
                        case 21://pas_name
                            pas.setPx_Name(cell.getStringCellValue());
                            break;
                        case 22://pas_plz
                           if(cell.getCellType()== CellType.NUMERIC)
                           {
                            d= cell.getNumericCellValue();
                            dd=String.format("%f", d);
                            pas.setPx_PLZ(dd);
                           } else 
                            pas.setPx_PLZ(cell.getStringCellValue());
                            
                            break;
                        case 23://pas_stadt
                            pas.setStadt_S_Name(cell.getStringCellValue());
                            break;
                        case 24://pas_strasse
                            pas.setPx_Strasse(cell.getStringCellValue());
                            break;
                        case 25://pas_land
                            pas.setPx_Land(cell.getStringCellValue());
                            break;
                    }
                   
                    spalte++;
                }
                    csvDTO.setFgDTO(flge);
                    csvDTO.setFl_HerstDTO(flh);
                    csvDTO.setFlugzeugDTO(flgz);
                    csvDTO.setAbFlDTO(abfh);
                    csvDTO.setAnFlDTO(akfh);
                    csvDTO.setLinDTO(lin);
                    csvDTO.setPassDTO(pas);
                    csvDTO.setFl_DTO(flug);
                    csvDTO.setBuchDTO(buch);
                    flugdaten.add(csvDTO);
                    re++;
            }
            

        } catch (ParseException | IOException ex) {
            Logger.getLogger(umpa.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flugdaten;

    }

}
