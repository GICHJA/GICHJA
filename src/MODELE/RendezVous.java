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
    //private Hospitalisation hospitalisation;
    //private Docteur soigne; 
    
        public RendezVous() {
        this.no_rdv = 0;
        this.date_arr = new  Date();
        this.date_dep = new  Date();
        this.motif = "";
    }

    public RendezVous(int no_rdv, Date date_arr, Date date_dep, String motif) {
        this.no_rdv = no_rdv;
        this.date_arr = date_arr;
        this.date_dep = date_dep;
        this.motif = motif;
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
    
    
}

