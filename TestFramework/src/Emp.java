/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Utilitaires.*;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author yohan
 */
public class Emp {
    String  nom;
    Date dateHeure;

    
    @Url(url = "/get-all")
    public ModelView getAll(){
        ModelView view=new ModelView();
        view.setView("lasa.jsp");
        Vector<Emp> all=new Vector<>();
        all.add(new Emp("Rabe"));
        all.add(new Emp("Yohan"));
        view.addItem("list", all);
        return view;
    }
    
    @Url(url = "/insertEmp")
    public ModelView save(String id){
        ModelView view=new ModelView();
        view.setView("index.jsp");
        view.addItem("nom", this.getNom());
        view.addItem("id", id);
        return view;
    }
    
    public Emp(String nom){
        this.setNom(nom);
    }
    
    
    public Emp(){
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
      public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }
    
}
