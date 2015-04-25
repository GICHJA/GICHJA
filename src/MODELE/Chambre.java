/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELE;

import java.util.List;

/**
 *
 * @author Adrien
 */
public class Chambre {
    
    private int id_chambre;
    private int nb_lit;
    private List<Hospitalisation> listhospitalisation;
    
    Chambre(){
        
    }
    
    public List<Hospitalisation> getListhospitalisation()
    {
        return listhospitalisation ;
    }
    
    public void setListhospitalisation (List<Hospitalisation> list)
    {
        this.listhospitalisation = list ;
    }
    
    public int getId_chambre()
    {
        return id_chambre ;
    }
    
    public void setId_batiment (int x)
    {
        this.id_chambre = x ;
    }
    
    public int getNb_lit()
    {
        return nb_lit ;
    }
    
    public void setNb_lit (int x)
    {
        this.nb_lit = x ;
    }
    
    public void ajoutHospitalisation(Hospitalisation hospitalisation)
    {
        this.listhospitalisation.add(hospitalisation);
    }
    
    
}   
