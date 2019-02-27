/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.beans;


import fly.interfaces.insertenLocal;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import fly.dtos.*;
import fly.interfaces.*;


/**
 *
 * @author aernst
 */
@Stateless
public class inserten implements insertenLocal {

    @EJB
    private prufLocal p;
    

   

    @Override
    public void insertLand(allDTODTO all) {

//        String path = "C:\\new\\" + dateiname;
//        File file = new File(path);
        Connection connect = null;
        Statement s = null;

        
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String line;
//            br.readLine();
//            br.readLine();

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                connect = DriverManager.getConnection("jdbc:sqlserver:"
                        + "//10.140.130.16:1433;"
                        + "databaseName=Firma8;user=dba8;password=dba8;");

                s = connect.createStatement();

            
//            while ((line = br.readLine()) != null) {
                
//                    String[] arr = line.split(";");

                    if (!p.prufPassLand(all)) {
                        String sql = "INSERT INTO Land "
                                + "(l_name) "
                                + "VALUES ('" + all.getPassDTO().getPx_Land() + "') ";
                        System.out.println("Import success!");
                        s.execute(sql);
                    }
                    if (!p.prufAbfFHLand(all)) {
                        String sql1 = "INSERT INTO Land "
                                + "(l_name) "
                                + "VALUES ('" + all.getAbFlDTO().getFlh_AbfLand() + "') ";
                        System.out.println("Import success!");
                        s.execute(sql1);
                    }
                    if (!p.prufAnkFHLand(all)) {
                        String sql2 = "INSERT INTO Land "
                                + "(l_name) "
                                + "VALUES ('" + all.getAnFlDTO().getFlh_AnkLand() + "') ";
                        System.out.println("Import success!");
                        s.execute(sql2);
                    } else {
                        System.out.println("Land bereits vorhanden");
                    }
                }
            catch (SQLException e) 
            {
                    e.getLocalizedMessage();
                }
              catch (ClassNotFoundException e) 
            {
                    e.getLocalizedMessage();
                }
//            }
//            System.out.println("Ende");
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void insertStadt(String dateiname, allDTODTO all) {
        String path = "C:\\new\\" + dateiname;
        File file = new File(path);
        Connection connect = null;
        Statement s = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            br.readLine();

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                connect = DriverManager.getConnection("jdbc:sqlserver:"
                        + "//10.140.130.16:1433;"
                        + "databaseName=Firma11;user=dba11;password=dba11;");

                s = connect.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split(";");

                    if (!p.prufPassStadt(all)) {
                        String sql = "INSERT INTO Stadt "
                                + "(s_name, Land_l_name) "
                                + "VALUES ('" + all.getPassDTO().getStadt_S_Name().replace("'", "''") + "','" + all.getPassDTO().getPx_Land() + "') ";
                        System.out.println("Import success!");
                        s.execute(sql);
                    }
                    if (!p.prufAbflFHStadt(all)) {
                        String sql1 = "INSERT INTO Stadt "
                                + "(s_name, Land_l_name) "
                                + "VALUES ('" + all.getAbFlDTO().getStadt_S_name().replace("'", "''") + "','" + all.getAbFlDTO().getFlh_AbfLand() + "') ";
                        System.out.println("Import success!");
                        s.execute(sql1);
                    }
                    if (!p.prufAnkFHStadt(all)) {
                        String sql2 = "INSERT INTO Stadt "
                                + "(s_name, Land_l_name) "
                                + "VALUES ('" + all.getAnFlDTO().getStadt_S_name().replace("'", "''") + "','" + all.getAnFlDTO().getFlh_AnkLand() + "') ";
                        System.out.println("Import success!");
                        s.execute(sql2);
                    } else {
//                            System.out.println("PK bereits vorhanden");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Ende");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertFlughafen(String dateiname, allDTODTO all) {
        String path = "C:\\new\\" + dateiname;
        File file = new File(path);
        Connection connect = null;
        Statement s = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            br.readLine();

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                connect = DriverManager.getConnection("jdbc:sqlserver:"
                        + "//10.140.130.16:1433;"
                        + "databaseName=Firma11;user=dba11;password=dba11;");

                s = connect.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split(";");

                    if (!p.prufAbfFlughafen(all)) {
                        String sql = "INSERT INTO Flughafen "
                                + "(flh_name, Stadt_s_name) "
                                + "VALUES ('" + all.getAbFlDTO().getFlh_Name() + "','" + all.getAbFlDTO().getStadt_S_name().replace("'", "''") + "') ";
                        System.out.println("Import success!");
                        s.execute(sql);

                    }
                    if (!p.prufAnkFlughafen(all)) {
                        String sql1 = "INSERT INTO Flughafen "
                                + "(flh_name, Stadt_s_name) "
                                + "VALUES ('" + all.getAnFlDTO().getFlh_Name() + "','" + all.getAnFlDTO().getStadt_S_name().replace("'", "''") + "') ";
                        System.out.println("Import success!");
                        s.execute(sql1);
                    } else {

                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Ende");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertFluggesellschaft(String dateiname, allDTODTO all) {
        String path = "C:\\new\\" + dateiname;
        File file = new File(path);
        Connection connect = null;
        Statement s = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            br.readLine();

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                connect = DriverManager.getConnection("jdbc:sqlserver:"
                        + "//10.140.130.16:1433;"
                        + "databaseName=Firma11;user=dba11;password=dba11;");

                s = connect.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split(";");
                 

                    if (!p.prufFluggesselschaft(all)) {
                        String sql = "INSERT INTO Fluggesellschaft "
                                + "(fg_id, fg_name) "
                                + "VALUES ('" + all.getFgDTO().getFg_ID() + "','" + all.getFgDTO().getFg_Name() + "') ";
                        System.out.println("Import success!");
                        s.execute(sql);
                    } else {
//                        System.out.println("PK bereits vorhanden");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Ende");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertLinie(String dateiname, allDTODTO all) {
        String path = "C:\\new\\" + dateiname;
        File file = new File(path);
        Connection connect = null;
        Statement s = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            br.readLine();

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                connect = DriverManager.getConnection("jdbc:sqlserver:"
                        + "//10.140.130.16:1433;"
                        + "databaseName=Firma11;user=dba11;password=dba11;");

                s = connect.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split(";");

                    LinieDTO xxxxx = new LinieDTO(Integer.parseInt(arr[3]), arr[4], arr[7], arr[0]);

                    if (!p.prufLinie(all)) {
                        String sql = "INSERT INTO Linie "
                                + "(l_id, abflug_flh, ankuft_flh, Fluggesellschaft_Fg_id) "
                                + "VALUES ('" + all.getLinDTO().getL_ID() + "','" + all.getLinDTO().getAbflug_FH() + "','" + all.getLinDTO().getAnkunft_FH() + "','" + all.getLinDTO().getFluggesellschaft_FG_ID() + "') ";
                        System.out.println("Import success!");
                        s.execute(sql);
                    } else {
//                        System.out.println("PK bereits vorhanden");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Ende");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertPassagiere(String dateiname, allDTODTO all) {
        String path = "C:\\new\\" + dateiname;
        File file = new File(path);
        Connection connect = null;
        Statement s = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            br.readLine();

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                connect = DriverManager.getConnection("jdbc:sqlserver:"
                        + "//10.140.130.16:1433;"
                        + "databaseName=Firma11;user=dba11;password=dba11;");

                s = connect.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split(";");

                    if (!p.prufPassagier(all)) {
                        String sql = "INSERT INTO Passagiere "
                                + "(px_nr, px_anrede, px_name, px_strasse, px_plz, Stadt_s_name) "
                                + "VALUES ('" + all.getPassDTO().getPx_NR() + "','" + all.getPassDTO().getPx_Anrede() + "','" + all.getPassDTO().getPx_Name().replace("'", "''") + "','" + all.getPassDTO().getPx_Strasse().replace("'", "''") + "','" + all.getPassDTO().getPx_PLZ() + "','" + all.getPassDTO().getStadt_S_Name().replace("'", "''") + "') ";
                        System.out.println("Import success!");
                        s.execute(sql);
                    } else {
//                        System.out.println("PK bereits vorhanden");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Ende");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertHersteller(String dateiname, allDTODTO all) {
        String path = "C:\\new\\" + dateiname;
        File file = new File(path);
        Connection connect = null;
        Statement s = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            br.readLine();

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                connect = DriverManager.getConnection("jdbc:sqlserver:"
                        + "//10.140.130.16:1433;"
                        + "databaseName=Firma11;user=dba11;password=dba11;");

                s = connect.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split(";");
                    Fl_HerstellerDTO x = new Fl_HerstellerDTO(arr[14]);

                    if (!p.prufHersteller(all)) {
                        String sql = "INSERT INTO Fl_Hersteller "
                                + "(h_name) "
                                + "VALUES ('" + all.getFl_HerstDTO().getFh_Name() + "') ";
                        System.out.println("Import success!");
                        s.execute(sql);
                    } else {
//                        System.out.println("Land bereits vorhanden");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Ende");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertFlugzeug(String dateiname, allDTODTO all) {
        String path = "C:\\new\\" + dateiname;
        File file = new File(path);
        Connection connect = null;
        Statement s = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            br.readLine();

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                connect = DriverManager.getConnection("jdbc:sqlserver:"
                        + "//10.140.130.16:1433;"
                        + "databaseName=Firma11;user=dba11;password=dba11;");

                s = connect.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split(";");
                    FlugzeugDTO x = new FlugzeugDTO(arr[13], Integer.parseInt(arr[16]), arr[14]);

                    if (!p.prufFlugzeug(all)) {
                        String sql = "INSERT INTO Flugzeug "
                                + "(f_type, f_sitzegesamt, Fl_Hersteller_h_name) "
                                + "VALUES ('" + all.getFlugzeugDTO().getF_Typ() + "','" + all.getFlugzeugDTO().getF_SitzeGesamt() + "','" + all.getFlugzeugDTO().getHersteller_H_Name() + "') ";
                        System.out.println("Import success!");
                        s.execute(sql);
                    } else {
//                        System.out.println("PK bereits vorhanden");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Ende");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertFlug(String dateiname, allDTODTO all) {
        String path = "C:\\new\\" + dateiname;
        File file = new File(path);
        Connection connect = null;
        Statement s = null;

        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            br.readLine();

            try 
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                connect = DriverManager.getConnection("jdbc:sqlserver:"
                        + "//10.140.130.16:1433;"
                        + "databaseName=Firma11;user=dba11;password=dba11;");

                s = connect.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }
            while ((line = br.readLine()) != null)
            {
               
                    String[] arr = line.split(";");

//                    SimpleDateFormat sdf1 = new SimpleDateFormat("MM.dd.yyyy");
//                    java.util.Date date = sdf1.parse(arr[11]);
//                    java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//
//                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
//                    java.sql.Time timeValue = new java.sql.Time(timeFormat.parse(arr[10]).getTime());
//
//                   
                    if (!p.prufFlug(all)) 
                    {
                        String sql = "INSERT INTO Flug "
                                + "(f_date, f_dauer, f_belegtesitze, Linie_l_id, Flugzeug_f_type) "
                                + "VALUES ('" + all.getFl_DTO().getF_Date() + "','" + all.getFl_DTO().getF_dauer() + "','" + all.getFl_DTO().getF_BelegteSitze() + "','" + all.getFl_DTO().getLinie_L_ID() + "','" + all.getFl_DTO().getFlugzeug_F_Typ() + "') ";
                        System.out.println("Import success!");
                        s.execute(sql);
                     }
//                        System.out.println("PK bereits vorhanden");
                              System.out.println("Ende");
//            br.close();
                
                } 
        }catch (SQLException e)
                {
                    e.printStackTrace();
                } 
                
  
        
                catch (IOException e) 
                {
            e.printStackTrace();
    }
            }
    

    @Override
    public void insertBuchung(String dateiname, allDTODTO all) 
    {
        try {
            //        String path = "C:\\new\\" + dateiname;
//        File file = new File(path);
            Connection connect = null;
            Statement s = null;
//
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String line;
//            br.readLine();
//            br.readLine();
//
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            connect = DriverManager.getConnection("jdbc:sqlserver:"
                    + "//10.140.130.16:1433;"
                    + "databaseName=Firma11;user=dba11;password=dba11;");

            s = connect.createStatement();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            while ((line = br.readLine()) != null) {
//                try {
//                    String[] arr = line.split(";");

//                    SimpleDateFormat sdf1 = new SimpleDateFormat("MM.dd.yyyy");
//                    java.util.Date bdate = sdf1.parse(arr[18]);
//                    java.util.Date fdate = sdf1.parse(arr[11]);
//                    java.sql.Date Buchungsdatum = new java.sql.Date(bdate.getTime());
//                    java.sql.Date Flugdatum = new java.sql.Date(fdate.getTime());
//                    double value = Double.parseDouble(arr[12].replace(",", "."));
//                    double value2 = Double.parseDouble(arr[12].replace(".", " "));
//                    arr[12].replace(",", ".");
//                    String wert=arr[12].replace(".", "");
//                    String superwert=wert.replace(",", ".");
//                    double d = Double.parseDouble(superwert);
//                    double value2 = Double.parseDouble(arr[12]);
//                    double preis = Double.parseDouble(arr[12].trim().replaceAll("\\.", "").replaceAll(",", "."));
//                    double preis2 = Double.parseDouble(arr[12].replaceAll("\\.", "").replaceAll(",", "."));
//                     NumberFormat nf = NumberFormat.getInstance();
//                    double d = nf.parse(arr[12]).doubleValue();
//                    BuchungDTO xx = new BuchungDTO(Integer.parseInt(arr[17]), Buchungsdatum, d, arr[0], Integer.parseInt(arr[19]), Flugdatum, Integer.parseInt(arr[3]));
            if (!p.prufBuchung(all)) 
            {
                String sql = "INSERT INTO Buchung "
                        + "(b_nummer, b_datum, b_preis, Fluggesellschaft_Fg_Id, Passagiere_px_nr, Flug_f_date, Flug_Linie_l_id) "
                        + "VALUES ('" + all.getBuchDTO().getB_Nummer() + "','" + all.getBuchDTO().getB_Datum() + "','" + all.getBuchDTO().getB_Preis() + "','" + all.getBuchDTO().getFluggesellschaft_FG_ID() + "','" + all.getBuchDTO().getPassagier_PX_NR() + "','" + all.getBuchDTO().getFlug_F_Date() + "','" + all.getBuchDTO().getFlug_Linie_L_ID() + "') ";
                System.out.println("Import success!");
                s.execute(sql); 
                System.out.println("Ende");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(inserten.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(inserten.class.getName()).log(Level.SEVERE, null, ex);
        }

        } 
      
        
//            br.close();
   
           
    }



