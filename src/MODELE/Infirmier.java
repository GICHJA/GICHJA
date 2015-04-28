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
    
    public Infirmier(){
                super();
        this.rotation = "";
        this.salaire = 0;
        this.listchambresurveillant = null;
    }   

    public Infirmier(String rotation, int salaire, List<Chambre> listchambresurveillant, int id_employe, String nom, String prenom, String tel) {
        super(id_employe, nom, prenom, tel);
        this.rotation = rotation;
        this.salaire = salaire;
        this.listchambresurveillant = listchambresurveillant;
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
