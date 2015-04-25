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
public class Infirmier extends Employe{
    
    private String rotation;
    private int salaire;
    private List<Chambre> listchambresurveillant;
    
    Infirmier(){
        
    }   
    
    public String getRotation()
    {
        return rotation;
    }
    
    public void setRotation(String rotation)
    {
        this.rotation=rotation ;
    }
    
    public int getSalaire()
    {
        return salaire;
    }
    
    public void setSalaire(int salaire)
    {
        this.salaire=salaire ;
    }
    
    public List<Chambre> getListchambresurveillant()
    {
        return listchambresurveillant  ;
    }
    
    public void setListchambresurveillant (List<Chambre> list)
    {
        this.listchambresurveillant = list ;
    }
    
    public void ajoutChambre(Chambre chambre)
    {
        this.listchambresurveillant.add(chambre);
    }
}
