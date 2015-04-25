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
    
    public int getId_batiment()
    {
        return id_batiment ;
    }
    
    public void setId_batiment (int x)
    {
        this.id_batiment = x ;
    }
}
