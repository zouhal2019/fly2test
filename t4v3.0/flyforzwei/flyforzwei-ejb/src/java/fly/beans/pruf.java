/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.beans;

import java.util.List;
import fly.interfaces.prufLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fly.entities.*;
import fly.dtos.*;


@Stateless
public class pruf implements prufLocal {
    
    @PersistenceContext(unitName = "flyforzwei-ejbPU")
    private EntityManager em;
    
  
  
    @Override
    public boolean prufAnkFHLand(allDTODTO land) 
    {
        Land la=em.find(Land.class,land.getAnFlDTO().getFlh_AnkLand());
        if(la!=null||!la.getLName().equalsIgnoreCase(""))
            return true;                                    //gibt es berreits
        else
            return false;                                   //noch nicht vorhanden
    }
    
    @Override
    public boolean prufAnkFHStadt(allDTODTO stadt)
    {
         Stadt st=em.find(Stadt.class,stadt.getAnFlDTO().getStadt_S_name());
        if(st!=null)
            return true;
        else
            return false;
    }
    
    @Override
    public boolean prufAbfFHLand(allDTODTO land) 
    {
        Land la=em.find(Land.class,land.getAbFlDTO().getFlh_AbfLand());
        if(la!=null||!la.getLName().equalsIgnoreCase(""))
            return true;                                    //gibt es berreits
        else
            return false;                                   //noch nicht vorhanden
    }
@Override
    public boolean prufAbflFHStadt(allDTODTO stadt)
    {
         Stadt st=em.find(Stadt.class,stadt.getAbFlDTO().getStadt_S_name());
        if(st!=null)
            return true;
        else
            return false;
    }
    
    @Override
    public boolean prufPassStadt(allDTODTO stadt)
    {
         Stadt st=em.find(Stadt.class,stadt.getPassDTO().getStadt_S_Name());
        if(st!=null)
            return true;
        else
            return false;
    }
    
     @Override
    public boolean prufPassLand(allDTODTO land) 
    {
        Land la=em.find(Land.class,land.getPassDTO().getPx_Land());
        if(la!=null||!la.getLName().equalsIgnoreCase(""))
            return true;                                    //gibt es berreits
        else
            return false;                                   //noch nicht vorhanden
    }
    
    
  @Override
public boolean prufFluggesselschaft(allDTODTO fgs)
    {
         Fluggesellschaft fluggs=em.find(Fluggesellschaft.class,fgs.getFgDTO().getFg_ID());
        if(fluggs!=null)
            return true;
        else
            return false;
    }
  

    @Override
    public boolean prufAnkFlughafen(allDTODTO flh )
    {
         Flughafen flugha=em.find(Flughafen.class,flh.getAnFlDTO().getFlh_Name());
        if(flugha!=null)
            return true;
        else
            return false;
    }
@Override
public boolean prufAbfFlughafen(allDTODTO flh )
    {
         Flughafen flugha=em.find(Flughafen.class,flh.getAbFlDTO().getFlh_Name());
        if(flugha!=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean prufHersteller(allDTODTO  flh )
    {
         FlHersteller flugha=em.find(FlHersteller.class,flh.getFl_HerstDTO().getFh_Name());
        if(flugha!=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean prufFlugzeug(allDTODTO flz)
{
      Flugzeug flugz=em.find(Flugzeug.class,flz.getFlugzeugDTO().getF_Typ());
        if(flugz!=null)
            return true;
        else
            return false;
}
@Override
    public boolean prufLinie(allDTODTO lin)
{
      Linie l=em.find(Linie.class,lin.getLinDTO().getL_ID());
        if(l!=null)
            return true;
        else
            return false;
}
    
    @Override
   public boolean prufPassagier(allDTODTO pas)
{
      Passagiere p=em.find(Passagiere.class,pas.getPassDTO().getPx_NR());
        if(p!=null)
            return true;
        else
            return false;
}

   
@Override   
public boolean prufFlug(allDTODTO flug)
{ 
    String sql1="SELECT f FROM Flug f WHERE f.flugPK.fDate = :pk1 AND f.linie.lId=:pk2";
//    String sql2="SELECT l.lId FROM Linie l WHERE l.lId=:pk2";
    Query q =em.createQuery(sql1);
    q.setParameter("pk1",flug.getFl_DTO().getF_Date());
    q.setParameter("pk2",flug.getFl_DTO().getLinie_L_ID() );
    
    List<FlugDTO> fdo=q.getResultList();
        if(!fdo.isEmpty())
            return true;
        else
            return false;
}

    @Override
    public boolean prufBuchung(allDTODTO buch) {
       String sql1="SELECT b FROM Buchung b WHERE b.buchungPK.bNummer = :pk1 AND "
                 + " b.buchungPK.fDate=:pk2 AND b.buchungPK.linielid=:pk3";

    Query q =em.createQuery(sql1);
    q.setParameter("pk1",buch.getBuchDTO().getB_Nummer());
    q.setParameter("pk2",buch.getFl_DTO().getF_Date() );
    q.setParameter("pk3",buch.getFl_DTO().getLinie_L_ID() );
    List<BuchungDTO> fdo=q.getResultList();
        
         if(!fdo.isEmpty())
            return true;
        else
            return false;
    }

    public void persist(Object object) {
        em.persist(object);
    }




}
