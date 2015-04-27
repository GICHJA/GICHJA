/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELE;
import java.util.Date; //https://docs.oracle.com/javase/7/docs/api/java/util/Date.html

/**
 *
 * @author Davy
 */

public class RendezVous 
{
    
    
    private int no_rdv;
    private Date date_arr;
    private Date date_dep ;
    private String motif;
    private Hospitalisation hospitalisation;
    private Soigne soigne; 
    
    RendezVous(){
        
    }
    
    
    public int getNo_rdv()
    {
        return no_rdv;
    }
    
    public void setNo_rdv(int no)
    {
        this.no_rdv=no;
    }
    
    public Date getDate_arr()
    {
        return date_arr;
    }
    
    public void setDate_arr(Date d)
    {
        this.date_arr=d;
    }
    
    public Date getDate_dep()
    {
        return date_dep;
    }
    
    public void setDate_dep(Date d)
    {
        this.date_dep=d;
    }
    
    public String getMotif()
    {
        return motif ;
    }
    
    public void setMotif(String motif)
    {
        this.motif=motif;
    }
    
    public Hospitalisation getHospitalisation()
    {
        return hospitalisation;
    }
    
    public void setHospitalisation(Hospitalisation hospitalisation)
    {
        this.hospitalisation=hospitalisation;
    }
    
    public Soigne getSoigne()
    {
        return soigne;
    }
    
    public void setSoigne(Soigne soigne)
    {
        this.soigne=soigne;
    }
    
    
}

