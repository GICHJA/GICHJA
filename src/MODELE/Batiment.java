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
public class Batiment {
    private int id_batiment;
    private List<Service> listservice;
    
    Batiment(){
        
    }
    
    
    public List<Service> getListservice()
    {
        return listservice ;
    }
    
    public void setId_batiment (List<Service> list)
    {
        this.listservice = list ;
    }
    
    public int getId_batiment()
    {
        return id_batiment ;
    }
    
    public void setId_batiment (int x)
    {
        this.id_batiment = x ;
    }
    
    public void ajoutService(Service service)
    {
        this.listservice.add(service);
    }
}
