/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Utilitaires.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author yohan
 */
public class Emp {
    String nom;
  
    @Url(url = "/get-all")
    public ModelView getAll(){
        ModelView view=new ModelView();
        view.setView("lasa.jsp");
        Vector<Emp> all=new Vector<>();
        all.add(new Emp("Rabe"));
        all.add(new Emp("Yohan"));
        all.add(new Emp("Ambinintsoa"));
        view.addItem("list",all);
        return view;
    }
    
    @Url(url = "/Rava io")
    public void Insert(){
        
    }
    
    public Emp(String nom){
        this.setNom(nom);
    }
    
    public Emp(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
